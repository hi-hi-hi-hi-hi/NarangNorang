package com.narangnorang.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.narangnorang.dto.DailyLogDTO;
import com.narangnorang.dto.MoodStateDTO;

@Repository("norang2DAO")
public class Norang2DAO {

	@Autowired
	SqlSession sqlSession;

	// 일일 데이터 조회(하루)
	public DailyLogDTO selectDailyLog(DailyLogDTO dailyLogDTO) {
		return sqlSession.selectOne("com.config.Norang2Mapper.selectDailyLog", dailyLogDTO);
	}

	// 일일 데이터 저장
	public int insertDailyLog(DailyLogDTO dailyLogDTO) throws Exception {
		return sqlSession.insert("com.config.Norang2Mapper.insertDailyLog", dailyLogDTO);
	}

	// 기분 상태 저장
	public int insertMoodState(MoodStateDTO moodStateDTO) throws Exception {
		return sqlSession.insert("com.config.Norang2Mapper.insertMoodState", moodStateDTO);
	}

}
