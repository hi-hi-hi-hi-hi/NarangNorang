package com.narangnorang.service;

import com.narangnorang.dto.TestResultDTO;

public interface TestResultService {

	// 테스트결과 저장
	public int insert(TestResultDTO testResultDTO) throws Exception;

}
