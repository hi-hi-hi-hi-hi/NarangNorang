package com.narangnorang.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.narangnorang.dto.MemberDTO;
import com.narangnorang.dto.TestResultDTO;
import com.narangnorang.service.TestResultService;

@Controller
public class TestResultController {

	@Autowired
	TestResultService testResultService;

	// 테스트 목록보기
	@GetMapping("/test")
	public String test() throws Exception {
		return "test";
	}

	// 테스트 폼, 테스트결과 보기
	@GetMapping("/test/{num}")
	public String testType(@PathVariable("num") int num) throws Exception {
		return "test" + num;
	}

	// 테스트결과 저장
	@PostMapping("/test/{num}")
	public String testResult(HttpSession session, @PathVariable("num") int num) throws Exception {
		MemberDTO memberDTO = (MemberDTO) session.getAttribute("login");
		TestResultDTO testResultDTO = new TestResultDTO(0, memberDTO.getId(), null, num);
		testResultService.insert(testResultDTO);
		return "redirect:/test/" + num;
	}

}
