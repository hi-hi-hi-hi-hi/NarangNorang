package com.narangnorang.service;

import java.util.HashMap;
import java.util.List;

import com.narangnorang.dto.*;

public interface MiniroomService {
	public List<ItemDTO> selectAllItems(String category);
	public int insertBuy(MyItemDTO dto);
	public int wishupdate(int itemId);
	public int wishzero(int itemId);
	public int applyMiniroom(MyItemDTO myItemDTO);
	public MemberDTO selectMember(String email);
	public MyItemDTO selectByMyItemId(HashMap<String, Object> map);
	public List<MyItemDTO> selectAllMyItems(HashMap<String, Object> map);
	public MyRoomDTO selectMyRoom(int id);
	public int updatePoint(HashMap<String, Object> pointMap);
	public ItemDTO selectClickItem(Integer itemId);

}
