package com.narangnorang.service;

import java.util.Map;

import com.narangnorang.dto.MemberDTO;

public interface MemberService {

	// 로그인
	public MemberDTO selectMember(Map<String, String> map) throws Exception;
	
	// 아이디 중복 체크
	public int checkId(String id) throws Exception;
	
	// 닉네임 중복 체크
	public int checkNickname(String nickname) throws Exception;
	
	// 일반회원가입
	public int generalSignUp(MemberDTO dto) throws Exception;
	
}
