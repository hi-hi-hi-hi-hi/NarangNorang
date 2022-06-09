package com.narangnorang.controller;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.narangnorang.dto.ChallengeDTO;
import com.narangnorang.dto.DailyLogDTO;
import com.narangnorang.dto.MemberDTO;
import com.narangnorang.dto.MoodStateDTO;
import com.narangnorang.service.Norang2Service;

@RestController
public class Norang2Controller {

	@Autowired
	Norang2Service norang2Service;

	// 챌린지 조회(하루)
	@GetMapping("/norang2/challenge")
	public Map<String, Object> selectChallenge(HttpSession session) throws Exception {
		Map<String, Object> response = new HashMap<String, Object>();
		response.put("flag", false);
		MemberDTO memberDTO = (MemberDTO) session.getAttribute("login");
		int memberId = memberDTO.getId();
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String datetime = simpleDateFormat.format(calendar.getTime());
		ChallengeDTO challengeDTO = new ChallengeDTO(0, memberId, datetime, null);
		challengeDTO = norang2Service.selectChallenge(challengeDTO);
		if (challengeDTO != null) {
			response.put("flag", true);
		} else {
			int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
			String challenge = null;
			if (dayOfWeek == 1) {
				challenge = "셀카";
			} else if (dayOfWeek == 2) {
				challenge = "동물";
			} else if (dayOfWeek == 3) {
				challenge = "새";
			} else if (dayOfWeek == 4) {
				challenge = "나무";
			} else if (dayOfWeek == 5) {
				challenge = "벤치";
			} else if (dayOfWeek == 6) {
				challenge = "케이크";
			} else {
				challenge = "음료";
			}
			response.put("challenge", challenge);
		}
		return response;
	}

	// 일일 데이터 조회(하루)
	@GetMapping("/norang2/dailylog")
	public Map<String, Object> selectDailyLog(HttpSession session) throws Exception {
		Map<String, Object> response = new HashMap<String, Object>();
		response.put("flag", false);
		MemberDTO memberDTO = (MemberDTO) session.getAttribute("login");
		int memberId = memberDTO.getId();
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String datetime = simpleDateFormat.format(calendar.getTime());
		DailyLogDTO dailyLogDTO = new DailyLogDTO(0, memberId, datetime, 0, null);
		dailyLogDTO = norang2Service.selectDailyLog(dailyLogDTO);
		if (dailyLogDTO != null) {
			response.put("flag", true);
		}
		return response;
	}

	// 기분 상태 조회(접속일시 이후)
	@GetMapping("/norang2/moodstate")
	public Map<String, Object> selectMoodState(HttpSession session) throws Exception {
		Map<String, Object> response = new HashMap<String, Object>();
		response.put("flag", false);
		MemberDTO memberDTO = (MemberDTO) session.getAttribute("login");
		int memberId = memberDTO.getId();
		String datetime = memberDTO.getDatetime();
		MoodStateDTO moodStateDTO = new MoodStateDTO(0, memberId, datetime, 0);
		moodStateDTO = norang2Service.selectMoodState(moodStateDTO);
		if (moodStateDTO != null) {
			response.put("flag", true);
		}
		return response;
	}

	// 챌린지 저장
	@PostMapping("/norang2/challenge")
	public Map<String, Object> insertChallenge(HttpSession session, HttpServletRequest request,
			ChallengeDTO challengeDTO, @RequestParam("multipartFile") MultipartFile multipartFile) throws Exception {
		Map<String, Object> response = new HashMap<String, Object>();
		response.put("flag", false);
		MemberDTO memberDTO = (MemberDTO) session.getAttribute("login");
		int memberId = memberDTO.getId();
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String datetime = simpleDateFormat.format(calendar.getTime());
		String uploadPath = request.getSession().getServletContext().getRealPath("/")
				.concat("resources\\images\\challenge");
		multipartFile.transferTo(new File(uploadPath, memberId + "_" + datetime + ".png"));
		challengeDTO.setMemberId(memberId);
		challengeDTO.setDatetime(datetime);
		int cnt = norang2Service.insertChallenge(challengeDTO);
		if (cnt == 1) {
			response.put("flag", true);
		}
		return response;
	}

	// 일일 데이터 저장
	@PostMapping("/norang2/dailylog")
	public Map<String, Object> insertDailyLog(HttpSession session, DailyLogDTO dailyLogDTO) throws Exception {
		Map<String, Object> response = new HashMap<String, Object>();
		response.put("flag", false);
		MemberDTO memberDTO = (MemberDTO) session.getAttribute("login");
		int memberId = memberDTO.getId();
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String datetime = simpleDateFormat.format(calendar.getTime());
		dailyLogDTO.setMemberId(memberId);
		dailyLogDTO.setDatetime(datetime);
		int cnt = norang2Service.insertDailyLog(dailyLogDTO);
		if (cnt == 1) {
			response.put("flag", true);
		}
		return response;
	}

	// 기분 상태 저장
	@PostMapping("/norang2/moodstate")
	public Map<String, Object> insertMoodState(HttpSession session, MoodStateDTO moodStateDTO) throws Exception {
		Map<String, Object> response = new HashMap<String, Object>();
		response.put("flag", false);
		MemberDTO memberDTO = (MemberDTO) session.getAttribute("login");
		int memberId = memberDTO.getId();
		moodStateDTO.setMemberId(memberId);
		int cnt = norang2Service.insertMoodState(moodStateDTO);
		if (cnt == 1) {
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
