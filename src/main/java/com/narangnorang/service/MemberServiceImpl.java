package com.narangnorang.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.narangnorang.dao.MemberDAO;
import com.narangnorang.dto.MemberDTO;

@Service("memberService")
public class MemberServiceImpl implements MemberService {

	@Autowired
	MemberDAO memberDAO;

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

}
