package com.narangnorang.controller;

import com.narangnorang.dto.MemberDTO;
import com.narangnorang.dto.MyItemDTO;
import com.narangnorang.dto.PostDTO;
import com.narangnorang.service.MemberService;
import com.narangnorang.service.MiniroomService;
import com.narangnorang.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class MiniroomController {

	@Autowired
	MiniroomService miniroomService;


	// 미니룸 구매 게시판
//	@GetMapping("/homew2s")
//	public ModelAndView buy(@RequestParam(value="category",required=false,defaultValue="bed") String category) throws Exception {
//		List<PostDTO> list =  postService.selectAll(category);
//		ModelAndView mav = new ModelAndView("home");
//		mav.addObject("postList",list);
//		return mav;
//	}
	@PostMapping("/home")
	public String buy(HttpSession session,MyItemDTO myItemDTO) throws Exception{

		int num = miniroomService.insert(myItemDTO);

		return "redirect:/home";
	}


}
