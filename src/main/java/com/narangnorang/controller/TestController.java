package com.narangnorang.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.narangnorang.dto.MemberDTO;
import com.narangnorang.dto.TestResultDTO;
import com.narangnorang.service.TestResultService;

@Controller
public class TestController {

	@Autowired
	TestResultService testResultService;

	// @GetMapping({ "테스트 목록 보기", "테스트 보기", "테스트 결과 보기" })
	@GetMapping({ "/test", "/test/{type}", "/test/{type}/{result}" })
	public String test(@PathVariable(value = "type", required = false) @ModelAttribute("type") Integer type,
			@PathVariable(value = "result", required = false) @ModelAttribute("result") Integer result)
			throws Exception {
		return "test";
	}

	// 테스트 결과 저장
	@PostMapping("/test/{type}/{result}")
	public String insert(HttpSession session, @PathVariable("type") int type, @PathVariable("result") int result)
			throws Exception {
		MemberDTO login = (MemberDTO) session.getAttribute("login");
		int memberId = login.getId();
		TestResultDTO testResultDTO = new TestResultDTO(0, memberId, null, type, result);
		testResultService.insert(testResultDTO);
		return "redirect:/test/" + type + "/" + result;
	}

	// 지난 테스트 결과
	@GetMapping("/test/results")
	public String selectList(HttpSession session, Model model) throws Exception {
		MemberDTO memberDTO = (MemberDTO) session.getAttribute("login");
		int memberId = memberDTO.getId();
		List<TestResultDTO> testResultList = testResultService.selectList(memberId);
		model.addAttribute("testResultList", testResultList);
		return "test";
	}

	// 에러 처리
	@ExceptionHandler({ Exception.class })
	public String error() throws Exception {
		return "common/error";
	}

}
