package com.narangnorang.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.narangnorang.dao.MessageDAO;
import com.narangnorang.dto.MessageDTO;

@Service("messageService")
public class MessageServiceImpl implements MessageService {

	@Autowired
	MessageDAO messageDAO;

	@Override
	public List<MessageDTO> selectMessageList(int id) throws Exception {
		return messageDAO.selectMessageList(id);
	}

	@Override
	public int sendMessage(Map<String, Object> messageInfo) throws Exception {
		return messageDAO.sendMessage(messageInfo);
	}

	@Override
	public List<MessageDTO> getChats(Map<String, Object> map) throws Exception {
		return messageDAO.getChats(map);
	}



}
