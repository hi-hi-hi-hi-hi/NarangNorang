package com.narangnorang.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.narangnorang.dto.TestResultDTO;

@Repository("testResultDAO")
public class TestResultDAO {

	@Autowired
	SqlSession sqlSession;

	// 테스트결과 저장
	public int insert(TestResultDTO testResultDTO) {
		return sqlSession.insert("com.config.TestResultMapper.insert", testResultDTO);
	}

}
