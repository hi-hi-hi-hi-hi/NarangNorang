package com.narangnorang.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.narangnorang.dao.MessageDAO;
import com.narangnorang.dto.MessageDTO;

@Service("messageService")
public class MessageServiceImpl implements MessageService {

	@Autowired
	MessageDAO messageDAO;

	@Override
	public List<MessageDTO> selectMessageList(String id) throws Exception {
		return messageDAO.selectMessageList(id);
	}



}
