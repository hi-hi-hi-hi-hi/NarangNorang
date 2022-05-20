package com.narangnorang.controller;

import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpSession;

import com.narangnorang.dto.MyRoomDTO;
import com.narangnorang.service.MiniroomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.narangnorang.dto.MemberDTO;
import com.narangnorang.service.MemberService;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MemberController {

	@Autowired
	MemberService memberService;
	@Autowired
	MiniroomService miniroomService;
	@Autowired
	JavaMailSender javaMailSender;

	// 메인 (로그인 X)
	@GetMapping("/main")
	public String main() throws Exception {
		return "main";
	}

	// 홈 (로그인 O)
	@GetMapping("/home")
	public ModelAndView home(HttpSession session) throws Exception {

		MemberDTO mDTO = (MemberDTO)session.getAttribute("login");
		String memberId = mDTO.getId();
		MyRoomDTO myRoomDTO = miniroomService.selectMyRoom(memberId);
		myRoomDTO.setMemberId(memberId);
		ModelAndView mav = new ModelAndView("home");
		mav.addObject("myRoomDTO", myRoomDTO);
		return mav;
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
	
	// 일반 회원가입 폼
	@GetMapping("/generalSignUp")
	public String generalSignUpForm() throws Exception {
		return "member/generalSignUpForm";
	}
	
	// 상담사 회원가입 폼
	@GetMapping("/counselorSignUp")
	public String counselorSignUpForm() throws Exception {
		return "member/counselorSignUpForm";
	}
	
	// 일반회원가입 처리
	@PostMapping("/generalSignUp")
	public String insertGeneral(MemberDTO memberDTO) throws Exception {
		memberService.generalSignUp(memberDTO);
		return "loginForm";
	}
	
	// 상담사 회원가입 처리
	@PostMapping("/counselorSignUp")
	public String insertCounselor(MemberDTO memberDTO) throws Exception {
		memberService.counselorSignUp(memberDTO);
		return "loginForm";
	}
	
	// 비번찾기 폼
	@GetMapping("/findPw")
	public String findPw() throws Exception {
		return "member/findPwForm";
	}
	
	// 새 비번 폼
	@PostMapping("/findPw")
	public String newPwForm(HttpSession session, @RequestParam("id") String id) throws Exception {
		MemberDTO memberDTO = memberService.selectById(id);
		session.setAttribute("findPw", memberDTO);
		return "member/newPwForm";
	}
	
	// 새 비번 변경
	@PostMapping("/newPw")
	@ResponseBody
	public int newPw(MemberDTO memberDTO) throws Exception {
		System.out.println(memberDTO);
		return memberService.newPw(memberDTO);
	}
	
	// mypage 폼
	@GetMapping("/mypage")
	public String mypage(HttpSession session) throws Exception {
		session.getAttribute("login");
		return "mypage";
	}
	
	// mypage 개인정보 수정 화면
	@PostMapping("/mypage/edit")
	public String edit(HttpSession session) throws Exception {
		session.getAttribute("login");
		return "mypageEdit";
	}
	
	// 아이디 중복 체크
	@PostMapping("/checkId")
	@ResponseBody
	public int checkId(@RequestParam("id") String id) throws Exception {
		return memberService.checkId(id);
	}
	
	// 닉네임 중복 체크
	@PostMapping("/checkNickname")
	@ResponseBody
	public int checkNickname(@RequestParam("nickname") String nickname) throws Exception {
		return memberService.checkNickname(nickname);
	}
	
	// 인증 이메일
	@PostMapping("/checkMail")
	@ResponseBody
	public String sendMail(String id) throws Exception{
		Random random = new Random();  //난수 생성을 위한 랜덤 클래스
		String key="";  //인증번호 

		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(id); //스크립트에서 보낸 메일을 받을 사용자 이메일 주소 
		//입력 키를 위한 코드
		for(int i =0; i<3;i++) {
			int index=random.nextInt(25)+65; //A~Z까지 랜덤 알파벳 생성
			key+=(char)index;
		}
		int numIndex=random.nextInt(9999)+1000; //4자리 랜덤 정수를 생성
		key+=numIndex;
		message.setSubject("인증번호 입력을 위한 메일 전송");
		message.setText("인증 번호 : "+key);
		javaMailSender.send(message);
        return key;
	}

	// 에러 처리
	@ExceptionHandler({ Exception.class })
	public String error() throws Exception {
		return "common/error";
	}

}
