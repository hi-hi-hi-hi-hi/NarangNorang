package com.narangnorang.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.narangnorang.dao.CounselDAO;
import com.narangnorang.dto.MemberDTO;

@Service("counselService")
public class CounselServiceImpl implements CounselService {
	
	@Autowired
	CounselDAO counselDAO;

	@Override
	public List<MemberDTO> selectCounselorList() throws Exception {
		return counselDAO.selectCounselorList();
	}



}
