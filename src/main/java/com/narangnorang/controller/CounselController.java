package com.narangnorang.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

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
	
}
