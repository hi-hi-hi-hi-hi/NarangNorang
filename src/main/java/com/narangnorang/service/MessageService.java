package com.narangnorang.service;

import java.util.List;
import java.util.Map;

import com.narangnorang.dto.MessageDTO;

public interface MessageService {
	
	// 메세지 리스트
	public List<MessageDTO> selectMessageList(String id) throws Exception;
	
	// 메시지 전송 (insert)
	public int insertMessage(Map<String, String> messageInfo) throws Exception;

}
