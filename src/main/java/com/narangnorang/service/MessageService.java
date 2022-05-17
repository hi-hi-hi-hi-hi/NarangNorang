package com.narangnorang.service;

import java.util.List;

import com.narangnorang.dto.MessageDTO;

public interface MessageService {
	
	// 메세지 리스트
	public List<MessageDTO> selectMessageList(String id) throws Exception;

}
