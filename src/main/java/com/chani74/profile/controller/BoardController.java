package com.chani74.profile.controller;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.chani74.profile.dao.BoardDao;
import com.chani74.profile.dao.MemberDao;
import com.chani74.profile.dto.BoardDto;
import com.chani74.profile.dto.MemberDto;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@Controller
public class BoardController {
	@Autowired
	private SqlSession sqlSession;
	
	@GetMapping("/write")
	public String getMethodName(HttpSession session, Model model) {
		
		String sid = (String) session.getAttribute("sessionId");
		
		if(sid != null) {
			
			MemberDao mdao = sqlSession.getMapper(MemberDao.class);
			MemberDto mdto = mdao.memberInfoDao(sid);
			
			model.addAttribute("mdto", mdto);	
			
			return "writeForm";
		} else {
			model.addAttribute("msg", "로그인한 회원만 글쓰기가 가능합니다.");
			model.addAttribute("url", "login");
			return "alert/alert";
		}
				
		
	}
	
	@PostMapping("writeOk")
	public String writeOk(HttpServletRequest request, Model model) {
		
		String bid = request.getParameter("bid");
		String bname = request.getParameter("bname");
		String btitle = request.getParameter("btitle");
		String bcontent = request.getParameter("bcontent");

		BoardDao bDao = sqlSession.getMapper(BoardDao.class);
		bDao.writeDao(bid, bname, btitle, bcontent);
		
		return "redirect:list";
	}

	
	@GetMapping("/list")
	public String list(HttpServletRequest request, Model model) {
		
		BoardDao bDao = sqlSession.getMapper(BoardDao.class);
		ArrayList<BoardDto> bDtos = bDao.listDao();
		
		model.addAttribute("bDtos", bDtos);
		
		return "board";
	}
	
	@GetMapping("/viewContent")
	public String viewContent(HttpServletRequest request, Model model) {
		
		int bnum = Integer.parseInt(request.getParameter("bnum"));
		
		BoardDao bDao = sqlSession.getMapper(BoardDao.class);

		bDao.hitContentDao(bnum);
		BoardDto bdto = bDao.viewContentDao(bnum);
		
		model.addAttribute("bdto", bdto);
		
		return "viewContent";
	}
	@GetMapping("/modifyContent")
	public String modifyContent(HttpServletRequest request, Model model, HttpSession session) {
		
		int bnum = Integer.parseInt(request.getParameter("bnum"));
		
		BoardDao bDao = sqlSession.getMapper(BoardDao.class);
		BoardDto bdto = bDao.viewContentDao(bnum);
		
		String sid= (String) session.getAttribute("sessionId");
		if(sid.equals(bdto.getBid())) {
			model.addAttribute("bdto", bdto);
			return "modifyContent";
		} else {
			model.addAttribute("msg", "글작성자만 수정할 수 있습니다.");
			return "alert/alert2";
		}

		
	}
	
	@PostMapping("/modifyContentOk")
	public String modifyOk(HttpServletRequest request, Model model) {
		int bnum = Integer.parseInt(request.getParameter("bnum"));
		String btitle = request.getParameter("btitle");
		String bcontent = request.getParameter("bcontent");
		
		BoardDao bDao = sqlSession.getMapper(BoardDao.class);
		bDao.modifyContentDao(bnum, btitle, bcontent);
				
		return "redirect:list";
	}
	
	@GetMapping("/deleteContent")
	public String deleteContent(HttpServletRequest request, Model model, HttpSession session) {
		
		int bnum = Integer.parseInt(request.getParameter("bnum"));
		
		BoardDao bDao = sqlSession.getMapper(BoardDao.class);
		BoardDto bdto = bDao.viewContentDao(bnum);
		
		String sid= (String) session.getAttribute("sessionId");
		if(sid.equals(bdto.getBid())) {
			
			bDao.deleteContentDao(bnum);
			return "redirect:list";
		} else {
			model.addAttribute("msg", "글작성자만 삭제 할 수 있습니다.");
			return "alert/alert2";
		}

		
	}	
	
}
