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

	// 메세지 리스트
	public List<MessageDTO> selectMessageList(int userId) throws Exception {
		return sqlSession.selectList("com.config.MessageMapper.selectMessageList", userId);
	}

	// 메시지 전송 (insert)
	public int sendMessage(Map<String, Object> messageInfo) throws Exception {
		return sqlSession.insert("com.config.MessageMapper.sendMessage", messageInfo);
	}

	// 특정 사용자와 대화내역 가져오기
	public List<MessageDTO> getChats(Map<String, Object> map) throws Exception {
		return sqlSession.selectList("com.config.MessageMapper.getChats", map);
	}

	// 쪽지 확인
	public int readMessage(Map<String, Object> map) {
		return sqlSession.update("com.config.MessageMapper.readMessage", map);
	}

	// 확인하지 않은 쪽지 수
	public int countUnread(int userId) throws Exception {
		return sqlSession.selectOne("com.config.MessageMapper.countUnread", userId);
	}

}
