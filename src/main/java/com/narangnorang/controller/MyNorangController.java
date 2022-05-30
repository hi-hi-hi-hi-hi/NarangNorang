package com.narangnorang.controller;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.narangnorang.service.DailyLogService;
import com.narangnorang.service.MoodStateService;

@Controller
public class MyNorangController {

	@Autowired
	DailyLogService dailyLogService;
	@Autowired
	MoodStateService moodStateService;

	@GetMapping("/mynorang")
	public ModelAndView norang(HttpSession session, Integer year, Integer month) throws Exception {
//		MemberDTO memberDTO = (MemberDTO) session.getAttribute("login");
//		int memberId = memberDTO.getId();
//		dailyLogService.selectList(memberId);
//		System.out.println(dailyLogService.selectList(1));

		Calendar calendar = Calendar.getInstance();
		if (year == null) {
			year = calendar.get(Calendar.YEAR);
		}
		if (month == null) {
			month = calendar.get(Calendar.MONTH);
		} else {
			month -= 1;
		}
		calendar.set(year, month, 1);
		month += 1;

		Integer start = calendar.get(Calendar.DAY_OF_WEEK);
		Integer end = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);

		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("year", year);
		map.put("month", month);
		map.put("start", start);
		map.put("end", end);

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("map", map);
		modelAndView.setViewName("mynorang");
		return modelAndView;
	}

	// 에러 처리
	@ExceptionHandler({ Exception.class })
	public String error() throws Exception {
		return "common/error";
	}

}
