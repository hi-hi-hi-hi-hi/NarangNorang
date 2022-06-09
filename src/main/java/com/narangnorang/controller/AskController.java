package com.narangnorang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AskController {
	
	@GetMapping("/ask")
	public String post() throws Exception{
		return "ask";
	}
}
