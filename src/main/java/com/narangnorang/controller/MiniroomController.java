package com.narangnorang.controller;

import com.narangnorang.dto.*;
import com.narangnorang.service.MemberService;
import com.narangnorang.service.MiniroomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class MiniroomController {

	@Autowired
	MiniroomService miniroomService;

	//구매 버튼 클릭시 실행
	@PostMapping("/home/buy")
	public String buy(HttpSession session,MyItemDTO myItemDTO) throws Exception{
		System.out.println(myItemDTO);

		MemberDTO mDto = (MemberDTO)session.getAttribute("login");

		String userId = mDto.getId();
		myItemDTO.setMemberId(userId);

		int num = miniroomService.insertBuy(myItemDTO);


		return "redirect:/home/buy";
	}

	@PutMapping("/home/buy/{itemId}")
	public String wishupdate(@PathVariable("itemId") int itemId) throws Exception{
//		System.out.println(myItemDTO);
//		myItemDTO = miniroomService.selectByMyItemId(itemId);
//		model.addAttribute("myItem", myItemDTO);
		miniroomService.wishupdate(itemId);

		return "redirect:/home/buy";
	}

	@PutMapping("/home/style")
	public String applyMiniroom(MyItemDTO myItemDTO) throws Exception{
		System.out.println(myItemDTO);
//		myItemDTO = miniroomService.selectByMyItemId(itemId);
//		model.addAttribute("myItem", myItemDTO);
		miniroomService.applyMiniroom(myItemDTO);

		return "redirect:/home/style";
	}

	@GetMapping("/home/buy")
	public ModelAndView buy(HttpSession session,
							  @RequestParam(value="category",required=false,defaultValue="bed") String category

	) throws Exception {

		List<ItemDTO> list =  miniroomService.selectAllItems(category);
		MemberDTO mDto = (MemberDTO)session.getAttribute("login");
		ModelAndView mav = new ModelAndView("home_buy");

		String memberId = mDto.getId();
		MyRoomDTO myRoomDTO = miniroomService.selectMyRoom(memberId);
		myRoomDTO.setMemberId(memberId);
		mav.addObject("itemList",list);
		mav.addObject("memberId",memberId);
		mav.addObject("myRoomDTO", myRoomDTO);

		return mav;
	}

//	@GetMapping("/home/style")
//	public ModelAndView style(HttpSession session,
//							  @RequestParam(value="category",required=false,defaultValue="bed") String category,
//							  @RequestParam Map<String, String> map
//	) throws Exception {
//
//
//		MemberDTO mDto = (MemberDTO)session.getAttribute("login");
//		String memberId = mDto.getId();
//		map.put(category,memberId);
//
//		List<MyItemDTO> myItemList =  miniroomService.selectAllMyItems(map);
//		List<ItemDTO> itemList =  miniroomService.selectAllItems(category);
//		ModelAndView mav = new ModelAndView("home_style");
//
//
//		MyRoomDTO myRoomDTO = miniroomService.selectMyRoom(memberId);
//		myRoomDTO.setMemberId(memberId);
//
//		mav.addObject("myItemList",myItemList);
//		mav.addObject("itemList",itemList);
//		mav.addObject("myRoomDTO", myRoomDTO);
//
//		mav.addObject("memberId",memberId);
//		return mav;
//	}
@GetMapping("/home/style")
public ModelAndView style(HttpSession session,
						  @RequestParam(value="category",required=false,defaultValue="bed") String category
) throws Exception {


	MemberDTO mDto = (MemberDTO)session.getAttribute("login");
	String memberId = mDto.getId();

	List<MyItemDTO> myItemList =  miniroomService.selectAllMyItems(category);
	List<ItemDTO> itemList =  miniroomService.selectAllItems(category);
	ModelAndView mav = new ModelAndView("home_style");


	MyRoomDTO myRoomDTO = miniroomService.selectMyRoom(memberId);
	myRoomDTO.setMemberId(memberId);

	mav.addObject("myItemList",myItemList);
	mav.addObject("itemList",itemList);
	mav.addObject("myRoomDTO", myRoomDTO);

	mav.addObject("memberId",memberId);
	return mav;
}


}
