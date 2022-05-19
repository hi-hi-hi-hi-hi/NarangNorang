package com.narangnorang.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.narangnorang.dao.TestResultDAO;
import com.narangnorang.dto.TestResultDTO;

@Service("TestResultService")
public class TestResultServiceImpl implements TestResultService {

	@Autowired
	TestResultDAO testResultDAO;

	// 테스트 결과 저장
	@Override
	public int insert(TestResultDTO testResultDTO) throws Exception {
		return testResultDAO.insert(testResultDTO);
	}

	// 지난 테스트 결과
	@Override
	public List<TestResultDTO> selectList(String memberId) throws Exception {
		return testResultDAO.selectList(memberId);
	}

}
