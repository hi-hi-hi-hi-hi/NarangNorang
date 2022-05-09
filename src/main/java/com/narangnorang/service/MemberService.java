package com.narangnorang.service;

import java.util.Map;

import com.narangnorang.dto.MemberDTO;

public interface MemberService {

	// 로그인
	public MemberDTO selectMember(Map<String, String> map) throws Exception;

}
