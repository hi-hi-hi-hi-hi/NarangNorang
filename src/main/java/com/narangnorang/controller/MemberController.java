package com.narangnorang.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import com.narangnorang.dto.MyItemDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.narangnorang.dto.ItemDTO;
import com.narangnorang.dto.MemberDTO;
import com.narangnorang.dto.PostDTO;
import com.narangnorang.service.MemberService;
import com.narangnorang.service.MiniroomService;
import com.narangnorang.service.PostService;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MemberController {

	@Autowired
	MemberService memberService;
	
	@Autowired
	MiniroomService miniroomService;

	// 메인 (로그인 X)
	@GetMapping("/main")
	public String main() throws Exception {
		return "main";
	}

//	// 홈 (로그인 O)
//	@GetMapping("/home")
//	public ModelAndView home(HttpSession session,
//							 @RequestParam(value="category",required=false,defaultValue="bed") String category,
//							 @PathVariable int itemId
//	) throws Exception {
//		List<ItemDTO> list =  miniroomService.selectAllItems(category);
//		MyItemDTO myItemDTO = miniroomService.selectByMyItemId(itemId);
//		MemberDTO mDto = (MemberDTO)session.getAttribute("login");
//		ModelAndView mav = new ModelAndView("home");
//		mav.addObject("itemList",list);
//
//		String userId = mDto.getId();
//		mav.addObject("memberId",userId);
//		mav.addObject("myItem",myItemDTO);
//		return mav;
//	}


	// 홈 (로그인 O)
	@GetMapping("/home")
	public ModelAndView home(HttpSession session,
							 @RequestParam(value="category",required=false,defaultValue="bed") String category

	) throws Exception {
		List<ItemDTO> list =  miniroomService.selectAllItems(category);
		List<MyItemDTO> myItemList =  miniroomService.selectAllMyItems(category);
		MemberDTO mDto = (MemberDTO)session.getAttribute("login");
		ModelAndView mav = new ModelAndView("home");


		String userId = mDto.getId();
		mav.addObject("itemList",list);
		mav.addObject("myItemList",myItemList);
		mav.addObject("memberId",userId);
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

	// 에러 처리
	@ExceptionHandler({ Exception.class })
	public String error() throws Exception {
		return "common/error";
	}

}
