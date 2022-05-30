package com.narangnorang.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.narangnorang.dto.MessageDTO;

@Repository("messageDAO")
public class MessageDAO {
	
	@Autowired
	SqlSession sqlSession;
	
	public List<MessageDTO> selectMessageList(int id)  throws Exception {
		return sqlSession.selectList("com.config.MessageMapper.selectMessageList", id);
	}
	
	public int sendMessage(Map<String, Object> messageInfo)  throws Exception {
		return sqlSession.insert("com.config.MessageMapper.sendMessage", messageInfo);
	}
	
	public List<MessageDTO> getChats(Map<String, Object> map)  throws Exception {
		return sqlSession.selectList("com.config.MessageMapper.getChats", map);
	}
	
}
