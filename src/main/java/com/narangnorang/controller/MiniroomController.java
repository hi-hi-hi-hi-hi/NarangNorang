package com.narangnorang.controller;

import com.narangnorang.dto.*;
import com.narangnorang.service.MemberService;
import com.narangnorang.service.MiniroomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;
import java.lang.reflect.Member;
import java.util.HashMap;
import java.util.List;

@Controller
public class MiniroomController {

	@Autowired
	MiniroomService miniroomService;

	@GetMapping("/home/buy")
	public ModelAndView buy(HttpSession session,
							@RequestParam(value="category",required=false,defaultValue="bed") String category

	) throws Exception {

		List<ItemDTO> list =  miniroomService.selectAllItems(category);
		MemberDTO mDto = (MemberDTO)session.getAttribute("login");
		ModelAndView mav = new ModelAndView("home_buy");


		int id = mDto.getId();

		MyRoomDTO myRoomDTO = miniroomService.selectMyRoom(id);
		myRoomDTO.setMemberId(id);
		mav.addObject("itemList",list);
		mav.addObject("memberId",id);
		mav.addObject("myRoomDTO", myRoomDTO);

		return mav;
	}

	@GetMapping("/home/style")
	public ModelAndView style(HttpSession session,
							  @RequestParam(value="category",required=false,defaultValue="bed") String category
	) throws Exception {

		HashMap<String, Object> map = new HashMap<>();
		MemberDTO mDto = (MemberDTO)session.getAttribute("login");


		int id = mDto.getId();


		List<ItemDTO> itemList =  miniroomService.selectAllItems(category);
		ModelAndView mav = new ModelAndView("home_style");


		MyRoomDTO myRoomDTO = miniroomService.selectMyRoom(id);
		myRoomDTO.setMemberId(id);
		map.put("category", category);
		map.put("id",id);
		System.out.println(map);
		List<MyItemDTO> myItemList =  miniroomService.selectAllMyItems(map);
		mav.addObject("myItemList",myItemList);
		mav.addObject("itemList",itemList);
		mav.addObject("myRoomDTO", myRoomDTO);

		mav.addObject("memberId",id);
		return mav;
	}

	//물건 구매
	@PostMapping("/home/buy")
	public String buy(HttpSession session, MyItemDTO myItemDTO, HttpServletResponse response) throws Exception{

		MemberDTO mDto = (MemberDTO)session.getAttribute("login");

		int id = mDto.getId();
		myItemDTO.setMemberId(id);
		int itemId = myItemDTO.getItemId();

		MyItemDTO check = miniroomService.selectByMyItemId(itemId);

		if(check == null){
			miniroomService.insertBuy(myItemDTO);
		}else if(check.getWish() == 1){
			miniroomService.wishzero(itemId);
		}else if(check.getWish() == 0){

			String mesg="이미 구매한 아이템입니다.";
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('"+mesg);
			out.println("')");
			out.println("</script>");
		}
		return "redirect:/home/buy";
	}

	// 위시리스트
	@PutMapping("/home/buy/{itemId}")
	public String wishupdate(@PathVariable("itemId") int itemId) throws Exception{
		miniroomService.wishupdate(itemId);
		return "redirect:/home/buy";
	}

	//미니룸에 내아이템 적용
	@PutMapping("/home/style")
	public String applyMiniroom(MyItemDTO myItemDTO) throws Exception{
		miniroomService.applyMiniroom(myItemDTO);

		return "redirect:/home/style";
	}
}
