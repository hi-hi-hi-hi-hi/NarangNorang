package com.narangnorang.service;

import java.util.HashMap;
import java.util.List;

import com.narangnorang.dto.MemberDTO;

public interface CounselService {
	
	// 상담사 List
	public List<MemberDTO> selectCounselorList() throws Exception;
	
	// 센터 List
	public List<HashMap<String, String>> selectCenterList() throws Exception;

}
