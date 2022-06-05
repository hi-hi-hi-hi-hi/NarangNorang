package com.narangnorang.controller;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.narangnorang.dto.DailyLogDTO;
import com.narangnorang.dto.MemberDTO;
import com.narangnorang.dto.MoodStateDTO;
import com.narangnorang.service.Norang2Service;

@RestController
public class Norang2Controller {

	@Autowired
	Norang2Service norang2Service;

	@GetMapping("/norang2/dailylog")
	public DailyLogDTO selectDailyLog(HttpSession session) throws Exception {
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String datetime = simpleDateFormat.format(calendar.getTime());
		MemberDTO memberDTO = (MemberDTO) session.getAttribute("login");
		int memberId = memberDTO.getId();
		DailyLogDTO dailyLogDTO = new DailyLogDTO(0, memberId, datetime, 0, null);
		dailyLogDTO = norang2Service.selectDailyLog(dailyLogDTO);
		return dailyLogDTO;
	}

	@PostMapping("/norang2/dailylog")
	public Map<String, Boolean> insertDailyLog(HttpSession session, DailyLogDTO dailyLogDTO) throws Exception {
		Map<String, Boolean> response = new HashMap<String, Boolean>();
		response.put("flag", false);
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String datetime = simpleDateFormat.format(calendar.getTime());
		MemberDTO memberDTO = (MemberDTO) session.getAttribute("login");
		int memberId = memberDTO.getId();
		dailyLogDTO.setMemberId(memberId);
		dailyLogDTO.setDatetime(datetime);
		int flag = norang2Service.insertDailyLog(dailyLogDTO);
		if (flag == 1) {
			response.put("flag", true);
		}
		return response;
	}

	@PostMapping("/norang2/moodstate")
	public Map<String, Boolean> insertMoodState(HttpSession session, MoodStateDTO moodStateDTO) throws Exception {
		Map<String, Boolean> response = new HashMap<String, Boolean>();
		response.put("flag", false);
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String datetime = simpleDateFormat.format(calendar.getTime());
		MemberDTO memberDTO = (MemberDTO) session.getAttribute("login");
		int memberId = memberDTO.getId();
		moodStateDTO.setMemberId(memberId);
		moodStateDTO.setDatetime(datetime);
		int flag = norang2Service.insertMoodState(moodStateDTO);
		if (flag == 1) {
			response.put("flag", true);
		}
		return response;
	}

	// 에러 처리
	@ExceptionHandler({ Exception.class })
	public String error() throws Exception {
		return "common/error";
	}

}
