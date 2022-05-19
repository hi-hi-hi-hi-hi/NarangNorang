package com.narangnorang.service;

import java.util.List;

import com.narangnorang.dto.ItemDTO;
import com.narangnorang.dto.MyItemDTO;
import com.narangnorang.dto.MyRoomDTO;

public interface MiniroomService {
	public List<ItemDTO> selectAllItems(String category);
	public int insertBuy(MyItemDTO dto);
	public int wishupdate(int itemId);
	public int applyMiniroom(MyItemDTO myItemDTO);
	public MyItemDTO selectByMyItemId(int itemId);
	public List<MyItemDTO> selectAllMyItems(String category);
	public MyRoomDTO selectMyRoom(String memberId);

}
