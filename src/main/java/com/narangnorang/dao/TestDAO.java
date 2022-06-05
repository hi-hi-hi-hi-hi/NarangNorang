package com.narangnorang.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.narangnorang.dto.TestResultDTO;

@Repository("testDAO")
public class TestDAO {

	@Autowired
	SqlSession sqlSession;

	// 테스트 결과 저장
	public int insert(TestResultDTO testResultDTO) throws Exception {
		return sqlSession.insert("com.config.TestMapper.insert", testResultDTO);
	}

	// 지난 테스트 결과
	public List<TestResultDTO> selectList(int memberId) throws Exception {
		return sqlSession.selectList("com.config.TestMapper.selectList", memberId);
	}

}
