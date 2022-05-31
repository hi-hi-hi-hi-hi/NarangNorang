package com.narangnorang.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.narangnorang.dto.DailyLogDTO;

@Repository("dailyLogDAO")
public class DailyLogDAO {

	@Autowired
	SqlSession sqlSession;

	// 일일 데이터 저장
	public int insert(DailyLogDTO dailyLogDTO) throws Exception {
		return sqlSession.insert("com.config.DailyLogMapper.insert", dailyLogDTO);
	}

	// 일일 데이터 조회
	public List<DailyLogDTO> selectList(DailyLogDTO dailyLogDTO) throws Exception {
		return sqlSession.selectList("com.config.DailyLogMapper.selectList", dailyLogDTO);
	}

}
