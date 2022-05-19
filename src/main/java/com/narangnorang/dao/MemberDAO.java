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
	public int checkId(String id) throws Exception {
		return sqlSession.selectOne("com.config.MemberMapper.checkId", id);
	}
	
	// 닉네임 중복 체크
	public int checkNickname(String nickname) throws Exception {
		return sqlSession.selectOne("com.config.MemberMapper.checkNickname", nickname);
	}
	
	// 일반회원가입
	public int generalSignUp(MemberDTO dto) throws Exception {
		return sqlSession.insert("com.config.MemberMapper.generalSignUp", dto);
	}
	
	// 상담사 회원가입
	public int counselorSignUp(MemberDTO dto) throws Exception {
		return sqlSession.insert("com.config.MemberMapper.counselorSignUp", dto);
	}
	
	// id로 회원찾기
	public MemberDTO selectById(String id) throws Exception {
		return sqlSession.selectOne("com.config.MemberMapper.selectById", id);
	}
	
	// 새 비밀번호 설정
	public int newPw(MemberDTO dto) throws Exception {
		return sqlSession.update("com.config.MemberMapper.newPw", dto);
	}

}
