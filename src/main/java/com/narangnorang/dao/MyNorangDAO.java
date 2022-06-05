package com.narangnorang.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.narangnorang.dto.ChallengeDTO;
import com.narangnorang.dto.DailyLogDTO;
import com.narangnorang.dto.MoodStateDTO;

@Repository("myNorangDAO")
public class MyNorangDAO {

	@Autowired
	SqlSession sqlSession;

	// 일일 데이터 조회(한달)
	public List<DailyLogDTO> selectDailyLogList(DailyLogDTO dailyLogDTO) throws Exception {
		return sqlSession.selectList("com.config.MyNorangMapper.selectDailyLogList", dailyLogDTO);
	}

	// 일일 데이터 조회(하루)
	public DailyLogDTO selectDailyLog(DailyLogDTO dailyLogDTO) {
		return sqlSession.selectOne("com.config.MyNorangMapper.selectDailyLog", dailyLogDTO);
	}

	// 일일 데이터 저장
	public int insertDailyLog(DailyLogDTO dailyLogDTO) throws Exception {
		return sqlSession.insert("com.config.MyNorangMapper.insertDailyLog", dailyLogDTO);
	}

	// 일일 데이터 수정
	public int updateDailyLog(DailyLogDTO dailyLogDTO) throws Exception {
		return sqlSession.update("com.config.MyNorangMapper.updateDailyLog", dailyLogDTO);
	}

	// 일일 데이터 삭제
	public int deleteDailyLog(DailyLogDTO dailyLogDTO) throws Exception {
		return sqlSession.delete("com.config.MyNorangMapper.deleteDailyLog", dailyLogDTO);
	}

	// 기분 상태 조회(주간)
	public List<MoodStateDTO> selectMoodStateList(MoodStateDTO moodStateDTO) throws Exception {
		return sqlSession.selectList("com.config.MyNorangMapper.selectMoodStateList", moodStateDTO);
	}

	// 챌린지 조회(전체)
	public List<ChallengeDTO> selectChallengeList(int memberId) throws Exception {
		return sqlSession.selectList("com.config.MyNorangMapper.selectChallengeList", memberId);
	}

}
