package com.narangnorang.service;

import java.util.List;

import com.narangnorang.dto.MemberDTO;

public interface CounselService {
	
	// 상담사 List
	public List<MemberDTO> selectCounselorList() throws Exception;
	

}
