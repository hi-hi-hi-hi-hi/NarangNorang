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
		List<MyItemDTO> myItemList =  miniroomService.selectAllMyItems(map);
		mav.addObject("myItemList",myItemList);
		mav.addObject("itemList",itemList);
		mav.addObject("myRoomDTO", myRoomDTO);

		mav.addObject("memberId",id);
		return mav;
	}

	//물건 구매
	@PostMapping("/home/buy")
	public String buy(HttpSession session, MyItemDTO myItemDTO,Integer price, HttpServletResponse response) throws Exception{
		//alert 출력하고 싶다. 맞왜틀?
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();

		//세션 받아오기.
		MemberDTO mDto = (MemberDTO)session.getAttribute("login");

		//member고유번호
		int memberId = mDto.getId();

		//파라미터 이용해서 구매 버튼 클릭한 해당 itemId 받아옴.
		int itemId = myItemDTO.getItemId();

		// myItem에 insert하는 부분에 사용(insertBuy)
		myItemDTO.setMemberId(memberId);

		// Check에 쓰임. click한 아이템 price찾기에 쓰임.
		HashMap<String, Object> map = new HashMap<>();
		map.put("itemId",itemId);
		map.put("memberId",memberId);

		//click한 아이템 price찾기
		//ItemDTO itemDTO = miniroomService.selectClickItem((Integer)(itemId));

		int point =mDto.getPoint();

		//price랑 memberId 등록.
		HashMap<String, Object> pointMap = new HashMap<>();
		pointMap.put("memberId",memberId);
		pointMap.put("price",price);

		//아이디와 아이템id 이용해서 myItem에 구매할 아이템이 있는지 check로 받아옴.
		MyItemDTO check = miniroomService.selectByMyItemId(map);
		String mesg=null;


		//구매할 아이템이 myItem테이블에 없고 포인트가 price 이상이면구매. point없으면 포인트 부족메세지.
		if(check == null){
			if(point >= price){
				//point 차감.
				miniroomService.updatePoint(pointMap);
				miniroomService.insertBuy(myItemDTO);
				mesg="구매완료";
			}else{
				mesg="포인트가 부족합니다.";
			}

			//구매할 아이템이 이미 있는데, wish가 1이면 wish를 0으로 만들고 구매하기.
		}else if(check.getWish() == 1){
			if(point >= price){
				miniroomService.wishzero(itemId);
				//point 차감.
				miniroomService.updatePoint(pointMap);
				miniroomService.insertBuy(myItemDTO);
				mesg="구매완료";

			}else{
				mesg="포인트가 부족합니다.";

			}

		//구매할 아이템이 이미 있는데 wish가 0이면 이미 구매한 아이템.
		}else if(check.getWish() == 0){
			mesg="이미 구매한 아이템입니다.";
		}
//		out.println("<script language='javascript'>");
//		out.println("alert('"+mesg);
//		out.println("');");
//		out.println("</script>");
//		out.flush();
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
