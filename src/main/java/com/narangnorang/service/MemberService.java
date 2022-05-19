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
	
	// 일반회원가입
	public int counselorSignUp(MemberDTO dto) throws Exception;
	
	// id로 회원 찾기
	public MemberDTO selectById(String id) throws Exception;
	
	// 새 비밀번호 설정
	public int newPw(MemberDTO dto) throws Exception;
	
}
