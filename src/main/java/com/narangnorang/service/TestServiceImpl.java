package com.narangnorang.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.narangnorang.dao.TestDAO;
import com.narangnorang.dto.TestResultDTO;

@Service("testService")
public class TestServiceImpl implements TestService {

	@Autowired
	TestDAO testDAO;

	// 테스트 결과 저장
	@Override
	public int insert(TestResultDTO testResultDTO) throws Exception {
		return testDAO.insert(testResultDTO);
	}

	// 지난 테스트 결과
	@Override
	public List<TestResultDTO> selectList(int memberId) throws Exception {
		return testDAO.selectList(memberId);
	}

}
