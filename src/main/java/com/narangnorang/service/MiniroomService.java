package com.narangnorang.service;

import java.util.List;

import com.narangnorang.dto.ItemDTO;
import com.narangnorang.dto.MyItemDTO;
import com.narangnorang.dto.MyRoomDTO;
import com.narangnorang.dto.PostDTO;

public interface MiniroomService {
	public List<ItemDTO> selectAllItems(String category);
	public int insertBuy(MyItemDTO dto);
	public int insertStyle(MyRoomDTO dto);
	public int wishupdate(int itemId);
	public MyItemDTO selectByMyItemId(int itemId);
	public List<MyItemDTO> selectAllMyItems(String category);

}
