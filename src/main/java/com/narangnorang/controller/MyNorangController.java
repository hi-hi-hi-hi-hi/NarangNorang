package com.narangnorang.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.narangnorang.dto.DailyLogDTO;
import com.narangnorang.dto.MemberDTO;
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
		int start = calendar.get(Calendar.DAY_OF_WEEK);
		int end = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);

		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM");
		String datetime = simpleDateFormat.format(calendar.getTime());
		MemberDTO memberDTO = (MemberDTO) session.getAttribute("login");
		int memberId = memberDTO.getId();
		DailyLogDTO dailyLogDTO = new DailyLogDTO(0, memberId, datetime, null, null);
		List<DailyLogDTO> dailyLogList = dailyLogService.selectList(dailyLogDTO);

		/* ----------코드 개선 필요함---------- */
		List<DailyLogDTO> dailyLogCalendar = new ArrayList<DailyLogDTO>();
		for (int i = 0; i < end; i++) {
			dailyLogCalendar.add(null);
		}
		Iterator<DailyLogDTO> iterator = dailyLogList.iterator();
		while (iterator.hasNext()) {
			DailyLogDTO element = iterator.next();
			int index = Integer.parseInt(element.getDatetime().substring(8, 10));
			dailyLogCalendar.set(index, element);
		}
		for (int i = 1; i < start; i++) {
			dailyLogCalendar.add(0, null);
		}
		/* ------------------------------ */

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("year", year);
		modelAndView.addObject("month", month + 1);
		modelAndView.addObject("start", start);
		modelAndView.addObject("dailyLogCalendar", dailyLogCalendar);
		modelAndView.setViewName("mynorang");
		return modelAndView;
	}

	// 에러 처리
	@ExceptionHandler({ Exception.class })
	public String error() throws Exception {
		return "common/error";
	}

}
