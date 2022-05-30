package com.narangnorang.service;

import java.util.HashMap;
import java.util.List;

import com.narangnorang.dto.*;

public interface MiniroomService {
	public List<ItemDTO> selectAllItems(String category) throws Exception;
	public int insertBuy(MyItemDTO dto, HashMap<String, Integer> pointMap) throws Exception;
	public int wishupdate(int itemId) throws Exception;
	public int wishzero(int itemId) throws Exception;
	public int applyMiniroom(MyItemDTO myItemDTO) throws Exception;
	public MyItemDTO selectByMyItemId(HashMap<String, Object> map) throws Exception;
	public List<MyItemDTO> selectAllMyItems(HashMap<String, Object> map) throws Exception;
	public MyRoomDTO selectMyRoom(int id) throws Exception;
}
