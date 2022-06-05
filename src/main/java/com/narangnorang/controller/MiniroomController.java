package com.narangnorang.controller;

import com.narangnorang.dto.*;
import com.narangnorang.service.MiniroomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpSession;
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

		ModelAndView mav = new ModelAndView("homeBuy");

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
		ModelAndView mav = new ModelAndView("homeStyle");

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

	@GetMapping("/home/wish")
	public ModelAndView wish(HttpSession session) throws Exception {

		HashMap<String,Object> map = new HashMap<>();

		MemberDTO mDto = (MemberDTO)session.getAttribute("login");
		ModelAndView mav = new ModelAndView("homeWish");

		int id = mDto.getId();
		map.put("id",id);
		List<ItemDTO> list =  miniroomService.selectAllWishItems(map);
		MyRoomDTO myRoomDTO = miniroomService.selectMyRoom(id);
		myRoomDTO.setMemberId(id);
		mav.addObject("wishItemList",list);
		mav.addObject("memberId",id);
		mav.addObject("myRoomDTO", myRoomDTO);

		return mav;
	}

	//물건 구매
	@ResponseBody
	@PostMapping("/home/buy")
	public String buy(HttpSession session,int memberId, int price,int itemId) throws Exception {


		MemberDTO mDTO = (MemberDTO)session.getAttribute("login");
//		//파라미터 이용해서 구매 버튼 클릭한 해당 itemId 받아옴.
//		int itemId = myItemDTO.getItemId();

		// Check에 쓰임. click한 아이템 price찾기에 쓰임.
		HashMap<String, Object> map = new HashMap<>();
		map.put("itemId", itemId);
		map.put("memberId", memberId);

		int point = mDTO.getPoint();

		//price랑 memberId 등록.
		HashMap<String, Integer> pointMap = new HashMap<>();
		pointMap.put("price", price);
		pointMap.put("memberId", memberId);

		//아이디와 아이템id 이용해서 myItem에 구매할 아이템이 있는지 check로 받아옴.
		MyItemDTO check = miniroomService.selectByMyItemId(map);
		String mesg = null;

		//구매할 아이템이 myItem테이블에 없고 포인트가 price 이상이면 구매. point 없으면 포인트 부족메세지.
		if (check == null) {
			if (point >= price) {

				//point 차감.
				miniroomService.insertBuy(map, pointMap);
				mesg = "구매완료, 포인트가" + price + " 만큼 차감 되었습니다.";
			} else {
				mesg = "포인트가 부족합니다.";
			}

		}else{
			if (check.getWish()==0){
				mesg="이미 구매한 상품입니다.";
			}else{
				miniroomService.wishZero(map);
				mesg="위시리스트 상품을 구매했습니다.";

			}
		}

		return mesg;
	}

	// 위시리스트 추가
	@ResponseBody
	@PostMapping("/home/buy/{itemId}")
	public String wishupdate(@PathVariable("itemId") int itemId, int memberId) throws Exception{

		String mesg;
		int result=0;
		HashMap<String, Object> map = new HashMap<>();
		map.put("itemId",itemId);
		map.put("memberId",memberId);

		MyItemDTO check = miniroomService.selectByMyItemId(map);
		if(check == null){
			result = miniroomService.wishInsert(map);
			mesg = "위시리스트에 추가 되었습니다.";
		}else{
			if(check.getWish()==0){
				mesg="이미 구매한 상품입니다.";
			}else{
				result = miniroomService.wishDelete(map);
				mesg = "위시리스트에서 제거 되었습니다.";
			}
		}


		return mesg;
	}

	//미니룸에 내아이템 적용
	@ResponseBody
	@PutMapping("/home/style")
	public int applyMiniroom(int itemId, int memberId, String category) throws Exception{
		HashMap<String,Object> map = new HashMap<>();

		map.put("itemId", itemId);
		map.put("memberId", memberId);
		map.put("category", category);

		int result = miniroomService.applyMiniroom(map);
		return result;
	}
}