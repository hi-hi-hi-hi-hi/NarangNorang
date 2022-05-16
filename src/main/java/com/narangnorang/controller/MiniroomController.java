package com.narangnorang.controller;

import com.narangnorang.dto.*;
import com.narangnorang.service.MemberService;
import com.narangnorang.service.MiniroomService;
import com.narangnorang.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
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
		System.out.println(myItemDTO);
		int num = miniroomService.insert(myItemDTO);

		return "redirect:/home";
	}

	@PutMapping("/home/{itemId}")
	public String wishAdd(@PathVariable("itemId") int itemId, MyItemDTO myItemDTO) throws Exception{
//		System.out.println(myItemDTO);
//		myItemDTO = miniroomService.selectByMyItemId(itemId);
//		model.addAttribute("myItem", myItemDTO);
		miniroomService.update(myItemDTO);

		return "redirect:/home";
	}

	@GetMapping("/home/style")
	public ModelAndView style(HttpSession session,
							  @RequestParam(value="category",required=false,defaultValue="bed") String category

	) throws Exception {
		List<MyItemDTO> list =  miniroomService.selectAllMyItems(category);
		MemberDTO mDto = (MemberDTO)session.getAttribute("login");
		ModelAndView mav = new ModelAndView("home");


		String userId = mDto.getId();
		mav.addObject("myItemList",list);
		mav.addObject("memberId",userId);
		return mav;
	}
	@GetMapping("/home/buy")
	public ModelAndView buy(HttpSession session,
							  @RequestParam(value="category",required=false,defaultValue="bed") String category

	) throws Exception {

		List<ItemDTO> list =  miniroomService.selectAllItems(category);
		MemberDTO mDto = (MemberDTO)session.getAttribute("login");
		ModelAndView mav = new ModelAndView("home");


		String userId = mDto.getId();
		mav.addObject("itemList",list);
		mav.addObject("memberId",userId);
		return mav;
	}



}
