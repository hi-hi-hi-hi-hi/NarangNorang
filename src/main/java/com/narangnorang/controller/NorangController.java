package com.narangnorang.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.narangnorang.dto.MemberDTO;
import com.narangnorang.service.DailyLogService;
import com.narangnorang.service.MoodStateService;

@Controller
public class NorangController {

	@Autowired
	DailyLogService dailyLogService;
	@Autowired
	MoodStateService moodStateService;

	@GetMapping("/norang")
	@ResponseBody
	public String norang(HttpSession session) throws Exception {
		MemberDTO memberDTO = (MemberDTO) session.getAttribute("login");
		int memberId = memberDTO.getId();
		return "norang";
	}

	// 에러 처리
	@ExceptionHandler({ Exception.class })
	public String error() throws Exception {
		return "common/error";
	}

}
