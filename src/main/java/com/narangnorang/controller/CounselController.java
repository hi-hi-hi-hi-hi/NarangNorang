package com.narangnorang.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

import com.narangnorang.dto.MemberDTO;
import com.narangnorang.service.CounselService;

@Controller
public class CounselController {
	
	@Autowired
	CounselService counselService;
	
	@GetMapping("/counsel")
	@ModelAttribute("counselorList")
	public List<MemberDTO> selectCounselorList() throws Exception{
		return counselService.selectCounselorList();
	}
	
	@GetMapping("/counsel/center")
	public ModelAndView selectCenterList() throws Exception{
		ModelAndView mav = new ModelAndView();
		mav.setViewName("counsel");
		mav.addObject("centerList", counselService.selectCenterList());
		return mav;
	}
	
}