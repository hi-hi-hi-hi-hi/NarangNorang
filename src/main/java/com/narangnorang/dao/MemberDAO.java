package com.narangnorang.dao;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.narangnorang.dto.MemberDTO;

@Repository("memberDAO")
public class MemberDAO {

	@Autowired
	SqlSession sqlSession;

	// 로그인
	public MemberDTO selectMember(Map<String, String> map) throws Exception {
		return sqlSession.selectOne("com.config.MemberMapper.selectMember", map);
	}

}
