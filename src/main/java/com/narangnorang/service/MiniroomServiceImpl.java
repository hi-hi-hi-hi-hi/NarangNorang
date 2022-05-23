package com.narangnorang.service;

import java.util.List;

import com.narangnorang.dto.MyItemDTO;
import com.narangnorang.dto.MyRoomDTO;
import org.springframework.stereotype.Service;

import com.narangnorang.dao.MiniroomDAO;
import com.narangnorang.dto.ItemDTO;


@Service("miniroomService")
public class MiniroomServiceImpl implements MiniroomService {

	MiniroomDAO miniroomDAO;
	//생성자 주입
	public MiniroomServiceImpl(MiniroomDAO dao) {
		this.miniroomDAO = dao;
	}
	@Override
	public List<ItemDTO> selectAllItems(String category){
		List<ItemDTO> list = miniroomDAO.selectAllItems(category);
		return list;
	}

	@Override
	public int insertBuy(MyItemDTO myItemDTO) {

		return miniroomDAO.insertBuy(myItemDTO);
	}

	@Override
	public int wishupdate(int itemId) {
		return miniroomDAO.wishupdate(itemId);
	}

	@Override
	public int applyMiniroom(MyItemDTO myItemDTO) {
		return miniroomDAO.applyMiniroom(myItemDTO);
	}

	@Override
	public MyItemDTO selectByMyItemId(int itemId) {
		MyItemDTO myItemDTO = miniroomDAO.selectByMyItemId(itemId);
		return myItemDTO;
	}

	//	@Override
//	public List<MyItemDTO> selectAllMyItems(Map<String,String> map) {
//		List<MyItemDTO> list = miniroomDAO.selectAllMyItems(map);
//
//		return list;
//	}
	@Override
	public List<MyItemDTO> selectAllMyItems(String category) {
		List<MyItemDTO> list = miniroomDAO.selectAllMyItems(category);

		return list;
	}

	@Override
	public MyRoomDTO selectMyRoom(String memberId) {
		MyRoomDTO myRoomDTO = miniroomDAO.selectMyRoom(memberId) ;
		return myRoomDTO;
	}

}
