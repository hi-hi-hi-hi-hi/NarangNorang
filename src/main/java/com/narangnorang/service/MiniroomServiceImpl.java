package com.narangnorang.service;

import java.util.HashMap;
import java.util.List;

import com.narangnorang.dto.MyItemDTO;
import com.narangnorang.dto.MyRoomDTO;
import org.springframework.stereotype.Service;

import com.narangnorang.dao.MiniroomDAO;
import com.narangnorang.dto.ItemDTO;
import org.springframework.transaction.annotation.Transactional;


@Service("miniroomService")
public class MiniroomServiceImpl implements MiniroomService {

	MiniroomDAO miniroomDAO;
	//생성자 주입
	public MiniroomServiceImpl(MiniroomDAO dao) {
		this.miniroomDAO = dao;
	}
	@Override
	public List<ItemDTO> selectAllItems(String category) throws Exception{
		List<ItemDTO> list = miniroomDAO.selectAllItems(category);
		return list;
	}
	@Transactional
	@Override
	public int insertBuy(MyItemDTO myItemDTO,HashMap<String, Integer> pointMap) throws Exception {
		miniroomDAO.updatePoint(pointMap);
		return miniroomDAO.insertBuy(myItemDTO);
	}

	@Override
	public int wishupdate(int itemId) throws Exception {
		return miniroomDAO.wishupdate(itemId);
	}

	@Override
	public int wishzero(int itemId) throws Exception {
		return miniroomDAO.wishzero(itemId);
	}

	@Override
	public int applyMiniroom(MyItemDTO myItemDTO) throws Exception {
		return miniroomDAO.applyMiniroom(myItemDTO);
	}

	@Override
	public MyItemDTO selectByMyItemId(HashMap<String, Object> map) throws Exception {
		MyItemDTO myItemDTO = miniroomDAO.selectByMyItemId(map);
		return myItemDTO;
	}
	@Override
	public List<MyItemDTO> selectAllMyItems(HashMap<String, Object> map) throws Exception {
		List<MyItemDTO> list = miniroomDAO.selectAllMyItems(map);

		return list;
	}

	@Override
	public MyRoomDTO selectMyRoom(int id) throws Exception {
		MyRoomDTO myRoomDTO = miniroomDAO.selectMyRoom(id) ;
		return myRoomDTO;
	}
}
