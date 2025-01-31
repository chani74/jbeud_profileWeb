package com.chani74.profile.controller;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.chani74.profile.dao.MemberDao;
import com.chani74.profile.dto.MemberDto;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

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
	
	@GetMapping("/idcheck")
	public String idcheck(HttpServletRequest request, Model model, HttpServletResponse response) {
		
		String idcheck = request.getParameter("idcheck");

		MemberDao mDao = sqlSession.getMapper(MemberDao.class);
		
		int idFlag = mDao.idCheckDao(idcheck);//1이 반환되면 이미 가입하려는 아이디가 존재->가입불가
		
		
		if(idFlag == 1) {			
			model.addAttribute("msg", "가입하시려는 아이디가 존재합니다!다시 확인하신 후 가입하세요.");		
			
			return "alert/alert2";
		} else {
			model.addAttribute("msg", "가입 가능한 아이디 입니다. 계속 가입을 진행해 주세요.");	
			
			return "alert/alert2";
		}
	}
	
	@PostMapping("loginOk")
	public String loginOk( HttpServletRequest request, Model model, HttpSession session) {
		String mid = request.getParameter("mid");
		String mpw = request.getParameter("mpw");
		
		MemberDao mdao = sqlSession.getMapper(MemberDao.class);
		int loginFlag = mdao.loginDao(mid, mpw);
		
		if (loginFlag == 1 ) {
			session.setAttribute("sessionId", mid);
			
		} else {
			model.addAttribute("msg", "아이디, 또는 비밀번호가 잘못되었습니다. 다시 확인하세요.");
			model.addAttribute("url", "join");
			
			return "alert/alert";
		}
		
		return "index";
	}
	

	@GetMapping("logout_confirm")
	public String logout_confirm(HttpServletRequest request, Model model, HttpSession session) {
		
		model.addAttribute("msg", "로그아웃하시겠습니까?");
		model.addAttribute("url", "logout");
		
		return "alert/confirm";
		
	}
	
	@GetMapping("logout")
	public String logout(HttpServletRequest request, Model model, HttpSession session) {
		
		session.invalidate();
		model.addAttribute("msg", "로그아웃되었습니다.");
		model.addAttribute("url", "index");
		
		return "alert/alert";
		
	}
	
	@GetMapping("/member")
	public String member(HttpServletRequest request, Model model, HttpSession session) {
		
		String mid = (String) session.getAttribute("sessionId");
		
		MemberDao mdao = sqlSession.getMapper(MemberDao.class);
		
		MemberDto mdto =  mdao.memberInfoDao(mid);
		
		model.addAttribute("mdto", mdto);		
		
		return "memberForm";
	}
	
	@PostMapping("/modifyOk")
	public String postMethodName(HttpServletRequest request, Model model, HttpSession session) {
		
		String mid = request.getParameter("mid");
		String mpw = request.getParameter("mpw");
		String mname = request.getParameter("mname");
		String memail = request.getParameter("memail");
		
		MemberDao mdao = sqlSession.getMapper(MemberDao.class);
		int modifyFlag = mdao.ModifyDao(mid, mpw, mname, memail);
		
		if ( modifyFlag==1) {
			model.addAttribute("msg", "회원정보 수정완료.");
			model.addAttribute("url", "member");
			return "alert/alert";
		} else {
			model.addAttribute("msg", "회원정보 수정 실패!!!.");
			return "alert/alert2";
		}
	}
	
}
