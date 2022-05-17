package com.narangnorang.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.narangnorang.dto.MessageDTO;

@Repository("messageDAO")
public class MessageDAO {
	
	@Autowired
	SqlSession sqlSession;
	
	public List<MessageDTO> selectMessageList(String id) {
		return sqlSession.selectList("com.config.MessageMapper.selectMessageList", id);
	}
	

}
