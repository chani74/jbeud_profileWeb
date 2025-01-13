package com.chani74.profile.controller;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.chani74.profile.dao.MemberDao;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
public class MemberController {

	@Autowired
	private SqlSession sqlSession;
	
	@PostMapping("/joinOk")
	public String joinOk(HttpServletRequest request, Model model) {
		String mid = request.getParameter("mid");
		String mpw = request.getParameter("mpw");
		String mname = request.getParameter("mname");
		String memail = request.getParameter("memail");
		
		MemberDao mdao = sqlSession.getMapper(MemberDao.class);
		
		int idFlag = mdao.idCheckDao(mid);
		
		if (idFlag==0 ) {
			
			int joinFlag = mdao.joinMemberDao(mid, mpw, mname, memail);
	
			if ( joinFlag == 1 ) {
				model.addAttribute("msg", mname + "님, 가입을 축하드립니다.");
				model.addAttribute("url", "login");
			} else { // 가입실패
				model.addAttribute("msg", "회원 가입 실패! 다시 확인하세요.");
				model.addAttribute("url", "join");
			}
		} else {
			model.addAttribute("msg", "이미 존재하는 아이디 입니다.");
			model.addAttribute("url", "join");
		}
		
		return "alert/alert";
	}
	
	@GetMapping("idcheck")
	public String idcheck(@RequestParam String param) {
		return new String();
	}
	
}
