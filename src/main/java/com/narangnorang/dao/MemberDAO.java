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
	
	// 아이디 중복 체크
	public int checkId(String id) {
		return sqlSession.selectOne("com.config.MemberMapper.checkId", id);
	}
	
	// 닉네임 중복 체크
	public int checkNickname(String nickname) {
		return sqlSession.selectOne("com.config.MemberMapper.checkNickname", nickname);
	}
	
	// 일반회원가입
	public int generalSignUp(MemberDTO dto) {
		return sqlSession.insert("com.config.MemberMapper.generalSignUp", dto);
	}
	
	// 상담사 회원가입
	public int counselorSignUp(MemberDTO dto) {
		return sqlSession.insert("com.config.MemberMapper.counselorSignUp", dto);
	}

}
