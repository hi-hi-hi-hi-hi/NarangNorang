package com.narangnorang.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.narangnorang.dao.MessageDAO;
import com.narangnorang.dto.MessageDTO;

@Service("messageService")
public class MessageServiceImpl implements MessageService {

	@Autowired
	MessageDAO messageDAO;

	@Override
	public List<MessageDTO> selectMessageList(int userId) throws Exception {
		return messageDAO.selectMessageList(userId);
	}

	@Override
	public int sendMessage(Map<String, Object> messageInfo) throws Exception {
		return messageDAO.sendMessage(messageInfo);
	}
	
	@Transactional
	@Override
	public List<MessageDTO> getChats(Map<String, Object> map) throws Exception {
		messageDAO.readMessage(map);
		return messageDAO.getChats(map);
	}

	@Override
	public int countUnread(int userId) throws Exception {
		return messageDAO.countUnread(userId);
	}



}
