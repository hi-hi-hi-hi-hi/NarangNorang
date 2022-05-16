package com.narangnorang.service;

import java.util.List;

import com.narangnorang.dto.ItemDTO;
import com.narangnorang.dto.MyItemDTO;
import com.narangnorang.dto.PostDTO;

public interface MiniroomService {
	public List<ItemDTO> selectAllItems(String category);
	public int insert(MyItemDTO dto);
}
