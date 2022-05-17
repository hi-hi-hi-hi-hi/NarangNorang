package com.narangnorang.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.narangnorang.dao.TestResultDAO;
import com.narangnorang.dto.TestResultDTO;

@Service("TestResultService")
public class TestResultServiceImpl implements TestResultService {

	@Autowired
	TestResultDAO testResultDAO;

	// 테스트결과 저장
	@Override
	public int insert(TestResultDTO testResultDTO) throws Exception {
		return testResultDAO.insert(testResultDTO);
	}

}
