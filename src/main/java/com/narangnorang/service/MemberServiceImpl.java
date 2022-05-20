package com.narangnorang.service;

import java.util.Map;

import com.narangnorang.dao.MiniroomDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.narangnorang.dao.MemberDAO;
import com.narangnorang.dto.MemberDTO;
import org.springframework.transaction.annotation.Transactional;

@Service("memberService")
public class MemberServiceImpl implements MemberService {

	@Autowired
	MemberDAO memberDAO;
	@Autowired
	MiniroomDAO miniroomDAO;

	// 로그인
	@Override
	public MemberDTO selectMember(Map<String, String> map) throws Exception {
		return memberDAO.selectMember(map);
	}

	// 아이디 중복 체크
	@Override
	public int checkId(String id) throws Exception {
		return memberDAO.checkId(id);
	}
	
	// 닉네임 중복 체크
	@Override
	public int checkNickname(String nickname) throws Exception {
		return memberDAO.checkNickname(nickname);
	}
	
	// 일반회원가입
	@Transactional
	@Override
	public int generalSignUp(MemberDTO dto) throws Exception {
		String id = dto.getId();
		return memberDAO.generalSignUp(dto) & miniroomDAO.insertDefaultItems(id);
	}
	
	// 상담사 회원가입
	@Override
	public int counselorSignUp(MemberDTO dto) throws Exception {
		return memberDAO.counselorSignUp(dto);
	}

	// id로 회원 찾기
	@Override
	public MemberDTO selectById(String id) throws Exception {
		return memberDAO.selectById(id);
	}
	
	// 새 비밀번호 설정
	@Override
	public int newPw(MemberDTO dto) throws Exception {
		return memberDAO.newPw(dto);
	}
	
}
