package com.narangnorang.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.narangnorang.dto.ChallengeDTO;
import com.narangnorang.dto.DailyLogDTO;
import com.narangnorang.dto.MemberDTO;
import com.narangnorang.dto.MoodStateDTO;
import com.narangnorang.service.ChallengeService;
import com.narangnorang.service.DailyLogService;
import com.narangnorang.service.MoodStateService;

@Controller
public class MyNorangController {

	@Autowired
	DailyLogService dailyLogService;

	// 일일 데이터 조회(한달)
	@GetMapping("/mynorang/dailylog")
	public ModelAndView selectList(HttpSession session, Integer year, Integer month) throws Exception {
		Calendar calendar = Calendar.getInstance();
		if (year == null) {
			year = calendar.get(Calendar.YEAR);
		}
		if (month == null) {
			month = calendar.get(Calendar.MONTH) + 1;
		}
		calendar.set(year, month - 1, 1);
		int start = calendar.get(Calendar.DAY_OF_WEEK);
		int end = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);

		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM");
		String datetime = simpleDateFormat.format(calendar.getTime());
		MemberDTO memberDTO = (MemberDTO) session.getAttribute("login");
		int memberId = memberDTO.getId();
		DailyLogDTO dailyLogDTO = new DailyLogDTO(0, memberId, datetime, 0, null);
		List<DailyLogDTO> dailyLogList = dailyLogService.selectList(dailyLogDTO);

		/* ----------코드 개선 필요함---------- */
		List<DailyLogDTO> dailyLogCalendar = new ArrayList<DailyLogDTO>();
		for (int i = 0; i < end; i++) {
			dailyLogCalendar.add(null);
		}
		Iterator<DailyLogDTO> iterator = dailyLogList.iterator();
		while (iterator.hasNext()) {
			DailyLogDTO element = iterator.next();
			int index = Integer.parseInt(element.getDatetime().substring(8, 10)) - 1;
			dailyLogCalendar.set(index, element);
		}
		for (int i = 1; i < start; i++) {
			dailyLogCalendar.add(0, null);
		}
		/* ------------------------------ */

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("year", year);
		modelAndView.addObject("month", month);
		modelAndView.addObject("start", start);
		modelAndView.addObject("dailyLogCalendar", dailyLogCalendar);
		modelAndView.setViewName("mynorang");
		return modelAndView;
	}

	// 일일 데이터 조회(하루)
	@GetMapping("/mynorang/dailylog/{datetime}")
	public ModelAndView selectOne(HttpSession session, @PathVariable String datetime) throws Exception {
		MemberDTO memberDTO = (MemberDTO) session.getAttribute("login");
		int memberId = memberDTO.getId();
		DailyLogDTO dailyLogDTO = new DailyLogDTO(0, memberId, datetime, 0, null);
		dailyLogDTO = dailyLogService.selectOne(dailyLogDTO);

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("datetime", datetime);
		modelAndView.addObject("dailyLogDTO", dailyLogDTO);
		modelAndView.setViewName("/mynorang/dailyLog");
		return modelAndView;
	}

	// 일일 데이터 저장
	@PostMapping("/mynorang/dailylog/{datetime}")
	public String insert(HttpSession session, DailyLogDTO dailyLogDTO) throws Exception {
		MemberDTO memberDTO = (MemberDTO) session.getAttribute("login");
		int memberId = memberDTO.getId();
		dailyLogDTO.setMemberId(memberId);
		dailyLogService.insert(dailyLogDTO);
		return "redirect:/mynorang/success";
	}

	// 일일 데이터 수정
	@PutMapping("/mynorang/dailylog/{datetime}")
	public String update(HttpSession session, DailyLogDTO dailyLogDTO) throws Exception {
		MemberDTO memberDTO = (MemberDTO) session.getAttribute("login");
		int memberId = memberDTO.getId();
		dailyLogDTO.setMemberId(memberId);
		dailyLogService.update(dailyLogDTO);
		return "redirect:/mynorang/success";
	}

	// 일일 데이터 삭제
	@DeleteMapping("/mynorang/dailylog/{datetime}")
	public String delete(HttpSession session, DailyLogDTO dailyLogDTO) throws Exception {
		MemberDTO memberDTO = (MemberDTO) session.getAttribute("login");
		int memberId = memberDTO.getId();
		dailyLogDTO.setMemberId(memberId);
		dailyLogService.delete(dailyLogDTO);
		return "redirect:/mynorang/success";
	}

	// 성공
	@GetMapping("/mynorang/success")
	public String success() {
		return "/mynorang/success";
	}

	@Autowired
	MoodStateService moodStateService;

	// 기분 상태 조회
	@GetMapping("/mynorang/moodstate")
	public String moodstate() {
		return "mynorang";
	}

	// 기분 상태 조회(주간)
	@PostMapping("/mynorang/moodstate")
	@ResponseBody
	public List<MoodStateDTO> moodstate(HttpSession session, Integer year, Integer month, Integer date)
			throws Exception {
		Calendar calendar = Calendar.getInstance();
		if (year == null) {
			year = calendar.get(Calendar.YEAR);
		}
		if (month == null) {
			month = calendar.get(Calendar.MONTH) + 1;
		}
		if (date == null) {
			date = calendar.get(Calendar.DATE);
		}
		calendar.set(year, month - 1, date);

		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String datetime = simpleDateFormat.format(calendar.getTime());
		MemberDTO memberDTO = (MemberDTO) session.getAttribute("login");
		int memberId = memberDTO.getId();
		MoodStateDTO moodStateDTO = new MoodStateDTO(0, memberId, datetime, 0);
		List<MoodStateDTO> moodStateList = moodStateService.selectList(moodStateDTO);
		return moodStateList;
	}

	@Autowired
	ChallengeService challengeService;

	// 챌린지 조회
	@GetMapping("/mynorang/challenge")
	public String challenge(HttpSession session, Model model) throws Exception {
		MemberDTO memberDTO = (MemberDTO) session.getAttribute("login");
		int memberId = memberDTO.getId();
		List<ChallengeDTO> challengeList = challengeService.selectList(memberId);
		model.addAttribute("challengeList", challengeList);
		return "mynorang";
	}

	// 에러 처리
	@ExceptionHandler({ Exception.class })
	public String error() throws Exception {
		return "/common/error";
	}

}
