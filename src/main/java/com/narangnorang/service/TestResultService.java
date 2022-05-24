package com.narangnorang.service;

import java.util.List;

import com.narangnorang.dto.TestResultDTO;

public interface TestResultService {

	// 테스트 결과 저장
	public int insert(TestResultDTO testResultDTO) throws Exception;

	// 지난 테스트 결과
	public List<TestResultDTO> selectList(int memberId) throws Exception;

}
