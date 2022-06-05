package com.narangnorang.controller;

import java.io.File;
import java.util.Calendar;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.narangnorang.dto.ChallengeDTO;
import com.narangnorang.dto.MemberDTO;
import com.narangnorang.service.DailyLogService;
import com.narangnorang.service.MemberService;
import com.narangnorang.service.MoodStateService;
import com.narangnorang.service.NorangService;

@Controller
public class NorangController {

	@Autowired
	DailyLogService dailyLogService;
	@Autowired
	MoodStateService moodStateService;
	@Autowired
	NorangService norangService;
	@Autowired
	MemberService memberService;

	@GetMapping("/norang")
	@ResponseBody
	public String norang(HttpSession session) throws Exception {
		MemberDTO memberDTO = (MemberDTO) session.getAttribute("login");
		int memberId = memberDTO.getId();
		return "norang";
	}
	
	@GetMapping("/dailyChallenge")
	public ModelAndView dailyChallenge(HttpSession session) throws Exception {
		MemberDTO mDTO = (MemberDTO) session.getAttribute("login");
		int memberId = mDTO.getId();
		ModelAndView mav = new ModelAndView();
		Calendar cal = Calendar.getInstance();
		int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
		String dailyChallenge = "";
		String today = cal.get(Calendar.YEAR)+"-"+(cal.get(Calendar.MONTH)+1)+"-"+cal.get(Calendar.DAY_OF_MONTH);
		if(dayOfWeek == 1) {
			dailyChallenge = "셀카찍기";
		} else if(dayOfWeek == 2) {
			dailyChallenge = "동물찍기";
		} else if(dayOfWeek == 3) {
			dailyChallenge = "새찍기";
		} else if(dayOfWeek == 4) {
			dailyChallenge = "나무찍기";
		} else if(dayOfWeek == 5) {
			dailyChallenge = "벤치찍기";
		} else if(dayOfWeek == 6) {
			dailyChallenge = "케이크찍기";
		} else{
			dailyChallenge = "음료찍기";
		}
		File file = new File("C:/bootstudy/sts-bundle/sts-3.9.14.RELEASE/project/HighFive/NarangNorang/src/main/resources/static/images/norang/dailyChallenge/" + String.valueOf(memberId) + "_"+today + ".png");
		if(file.exists()) {
			mav.addObject("file", true);
		}else {
			mav.addObject("file", false);
		}
		mav.setViewName("dailyChallenge");
		mav.addObject("dailyChallenge", dailyChallenge);
		mav.addObject("today", today);
		return mav;
	}
	
	@PostMapping("/dailyChallengeUpload")
	public String dailyChallengeUpload(HttpSession session, ChallengeDTO challengeDTO, @RequestParam("img_upload") MultipartFile mFile) throws Exception {
		String uploadPath = "C:/bootstudy/sts-bundle/sts-3.9.14.RELEASE/project/HighFive/NarangNorang/src/main/resources/static/images/norang/dailyChallenge/";
		MemberDTO mDTO = (MemberDTO) session.getAttribute("login");
		int memberId = mDTO.getId();
		int cnt = norangService.dailyChallengeDo(challengeDTO);
		Calendar cal = Calendar.getInstance();
		try {
			if(cnt != 1) {
				String newName = mFile.getOriginalFilename();
				newName = String.valueOf(mDTO.getId());
				String newNameSub = cal.get(Calendar.YEAR)+"-"+(cal.get(Calendar.MONTH)+1)+"-"+cal.get(Calendar.DAY_OF_MONTH);
				mFile.transferTo(new File(uploadPath + newName + "_" + newNameSub + ".png"));
			
				challengeDTO.setMemberId(memberId);
				norangService.dailyChallengeUpload(challengeDTO);
				
				memberService.pointUpdate(mDTO.getId());
				mDTO.setPoint(mDTO.getPoint()+5);
				session.setAttribute("login", mDTO);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/home";
	}

	// 에러 처리
	@ExceptionHandler({ Exception.class })
	public String error() throws Exception {
		return "common/error";
	}

}
