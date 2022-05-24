package com.narangnorang.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.narangnorang.dto.MyRoomDTO;
import com.narangnorang.service.MiniroomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.narangnorang.dto.MemberDTO;
import com.narangnorang.service.MemberService;

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
		MemberDTO mDTO = (MemberDTO) session.getAttribute("login");

		String email = mDTO.getEmail();
		int id = mDTO.getId();
		MyRoomDTO myRoomDTO = miniroomService.selectMyRoom(id);
		myRoomDTO.setMemberId(id);

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
	@GetMapping("/myPage/newPwForm")
	public String myPageNewPwForm(HttpSession session) throws Exception {
		session.getAttribute("login");
		return "member/myPageNewPwForm";
	}
	
	// 새 비번 변경
	@PutMapping("/newPw")
	@ResponseBody
	public int newPw(MemberDTO memberDTO) throws Exception {
		return memberService.newPw(memberDTO);
	}
	@PutMapping("/myPage/newPw")
	@ResponseBody
	public int myPageNewPw(MemberDTO memberDTO) throws Exception {
		return memberService.newPw(memberDTO);
	}
	
	// mypage 폼
	@GetMapping("/mypage")
	public String mypage(HttpSession session) throws Exception {
		session.getAttribute("login");
		return "mypage";
	}
	
	// mypage 개인정보 수정 화면
	@GetMapping("/mypage/edit")
	public String edit(HttpSession session) throws Exception {
		session.getAttribute("login");
		return "mypageEdit";
	}
	
	// 일반회원 정보 수정
	@PutMapping("/generalEdit")
	public String generalEdit(HttpSession session, MemberDTO memberDTO) throws Exception {
		memberService.generalEdit(memberDTO);
		session.invalidate();
		return "redirect:/login";
	}
	
	// 상담사회원 정보 수정
	@PutMapping("/counselorEdit")
	public String counselorEdit(HttpSession session, MemberDTO memberDTO) throws Exception {
		memberService.counselorEdit(memberDTO);
		session.invalidate();
		return "redirect:/login";
	}
	
	// 관리자 페이지 - 회원 관리
	@GetMapping(value="/admin", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ModelAndView getAllLists() throws Exception{
		List<MemberDTO> lists = memberService.selectAll();
		ModelAndView mav = new ModelAndView("member/adminEdit");
		mav.addObject("lists", lists);
		return mav;
	}
	
	// 관리자 페이지 - 선택 계정 삭제
	@GetMapping("/admin/delMember")
	public String delMember(HttpServletRequest request) throws Exception{
		String nextPage = "";
		String [] check = request.getParameterValues("check");
		if(check == null) {
			nextPage = "member/delFail";
		}else {
			List<String> list = Arrays.asList(check);
			memberService.delSelected(list);
			nextPage = "redirect:/admin";
		}
		return nextPage;
	}
	
	// 관리자 페이지 - 상담사 권한 관리
	@GetMapping("/admin/counselPrivileage2")
	@ResponseBody
	public ModelAndView getPrivileage2() throws Exception{
		List<MemberDTO> lists = memberService.selectByPrivileage2();
		ModelAndView mav = new ModelAndView("member/counselPrivileage2");
		mav.addObject("lists", lists);
		return mav;
	}
	
	// 관리자 페이지 - 상담사 권한 UP
	@GetMapping("/admin/privileageUp")
	public String privileageUp(HttpServletRequest request) throws Exception{
		String nextPage = "";
		String [] check = request.getParameterValues("check");
		if(check == null) {
			nextPage = "member/upFail";
		}else {
			List<String> list = Arrays.asList(check);
			memberService.privileageUp(list);
			nextPage = "redirect:/admin/counselPrivileage2";
		}
		return nextPage;
	}
	
	// 아이디 중복 체크
	@PostMapping("/checkEmail")
	@ResponseBody
	public int checkEmail(@RequestParam("email") String email) throws Exception {
		return memberService.checkId(email);
	}
	
	// 닉네임 중복 체크
	@PostMapping("/checkName")
	@ResponseBody
	public int checkNickname(@RequestParam("name") String name) throws Exception {
		return memberService.checkNickname(name);
	}
	
	// 인증 이메일
	@PostMapping("/checkMail")
	@ResponseBody
	public String sendMail(String email) throws Exception{
		Random random = new Random();  //난수 생성을 위한 랜덤 클래스
		String key="";  //인증번호 

		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(email); //스크립트에서 보낸 메일을 받을 사용자 이메일 주소 
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
