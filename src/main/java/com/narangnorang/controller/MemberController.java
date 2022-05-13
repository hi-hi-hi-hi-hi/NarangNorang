package com.narangnorang.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.narangnorang.dto.MemberDTO;
import com.narangnorang.service.MemberService;

@Controller
public class MemberController {

	@Autowired
	MemberService memberService;

	// 메인 (로그인 X)
	@GetMapping("/main")
	public String main() throws Exception {
		return "main";
	}

	// 홈 (로그인 O)
	@GetMapping("/home")
	public String home() throws Exception {
		return "home";
	}

	// 로그인 폼
	@GetMapping("/login")
	public String loginForm() throws Exception {
		return "loginForm";
	}

	// 로그인 처리
	@PostMapping("/login")
	public String login(HttpSession session, @RequestParam Map<String, String> map) throws Exception {
		String nextPage = "";
		MemberDTO memberDTO = memberService.selectMember(map);
		if (memberDTO != null) {
			session.setAttribute("login", memberDTO);
			nextPage = "redirect:/home";
		} else {
			nextPage = "member/loginFail";
		}
		return nextPage;
	}

	// 로그아웃
	@GetMapping("/logout")
	public String logout(HttpSession session) throws Exception {
		session.invalidate();
		return "redirect:/main";
	}

	// 세션 만료
	@GetMapping("/sessionInvalidate")
	public String sessionInvalidate() throws Exception {
		return "common/sessionInvalidate";
	}
	
	// 회원가입 폼
	@GetMapping("/signUp")
	public String memberForm() throws Exception {
		return "member/signUpForm";
	}
	
	// 계정찾기 폼
	@GetMapping("/findPw")
	public String findPw() throws Exception {
		return "member/findPwForm";
	}
	
	// mypage 폼
	@GetMapping("/mypage")
	public String mypage() throws Exception {
		return "mypage";
	}

	// 에러 처리
	@ExceptionHandler({ Exception.class })
	public String error() throws Exception {
		return "common/error";
	}

}
