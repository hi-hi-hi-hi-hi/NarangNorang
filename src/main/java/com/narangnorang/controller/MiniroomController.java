package com.narangnorang.controller;

import com.narangnorang.dto.*;
import com.narangnorang.service.MiniroomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpSession;
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
	public ModelAndView wish(HttpSession session,
							@RequestParam(value="category",required=false,defaultValue="bed") String category
	) throws Exception {

		HashMap<String,Object> map = new HashMap<>();
		map.put("category",category);

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
	@PostMapping("/home/buy")
	public ModelAndView buy(HttpSession session,
							MyItemDTO myItemDTO,
							int price,
							String category) throws Exception {
		ModelAndView mav = new ModelAndView();
		mav.addObject("category", category);

		//세션 받아오기.
		MemberDTO mDto = (MemberDTO) session.getAttribute("login");

		//member고유번호
		int memberId = mDto.getId();

		//파라미터 이용해서 구매 버튼 클릭한 해당 itemId 받아옴.
		int itemId = myItemDTO.getItemId();

		// myItem에 insert하는 부분에 사용(insertBuy)
		myItemDTO.setMemberId(memberId);

		// Check에 쓰임. click한 아이템 price찾기에 쓰임.
		HashMap<String, Object> map = new HashMap<>();
		map.put("itemId", itemId);
		map.put("memberId", memberId);

		int point = mDto.getPoint();

		//price랑 memberId 등록.
		HashMap<String, Integer> pointMap = new HashMap<>();
		pointMap.put("price", price);
		pointMap.put("memberId", memberId);

		//아이디와 아이템id 이용해서 myItem에 구매할 아이템이 있는지 check로 받아옴.
		MyItemDTO check = miniroomService.selectByMyItemId(map);
		String mesg = null;

		//구매할 아이템이 myItem테이블에 없고 포인트가 price 이상이면구매. point없으면 포인트 부족메세지.
		if (check == null) {
			if (point >= price) {

				//point 차감.
				miniroomService.insertBuy(myItemDTO, pointMap);
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
		mav.addObject("mesg", mesg);
		mav.setViewName("miniroom/miniroomBuySuccess");
		return mav;
	}

	// 위시리스트 추가
	@PostMapping("/home/buy/{itemId}")
	public ModelAndView wishupdate(@PathVariable("itemId") int itemId, MyItemDTO myItemDTO,HttpSession session,String category) throws Exception{

		ModelAndView mav = new ModelAndView();
		mav.addObject("category",category);
		MemberDTO mDto = (MemberDTO)session.getAttribute("login");
		String mesg;
		int memberId = mDto.getId();
		int result=0;
		myItemDTO.setMemberId(memberId);
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

		mav.addObject("mesg",mesg);
		mav.setViewName("miniroom/miniroomWishSuccess");
		return mav;
	}

	//미니룸에 내아이템 적용
	@PutMapping("/home/style")
	public String applyMiniroom(MyItemDTO myItemDTO) throws Exception{
		miniroomService.applyMiniroom(myItemDTO);
		//@Responsebody했을때 검은색화면으로 넘어가는데 이유를 모르겠음.. js에 alert는 뜬다.
		return "redirect:/home/style";
	}
}