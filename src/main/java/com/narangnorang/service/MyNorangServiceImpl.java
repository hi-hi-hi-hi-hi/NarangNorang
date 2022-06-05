package com.narangnorang.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.narangnorang.dao.MyNorangDAO;
import com.narangnorang.dto.ChallengeDTO;
import com.narangnorang.dto.DailyLogDTO;
import com.narangnorang.dto.MoodStateDTO;

@Service("myNorangService")
public class MyNorangServiceImpl implements MyNorangService {

	@Autowired
	MyNorangDAO myNorangDAO;

	// 일일 데이터 조회(한달)
	@Override
	public List<DailyLogDTO> selectDailyLogList(DailyLogDTO dailyLogDTO) throws Exception {
		return myNorangDAO.selectDailyLogList(dailyLogDTO);
	}

	// 일일 데이터 조회(하루)
	@Override
	public DailyLogDTO selectDailyLog(DailyLogDTO dailyLogDTO) {
		return myNorangDAO.selectDailyLog(dailyLogDTO);
	}

	// 일일 데이터 저장
	@Override
	public int insertDailyLog(DailyLogDTO dailyLogDTO) throws Exception {
		return myNorangDAO.insertDailyLog(dailyLogDTO);
	}

	// 일일 데이터 수정
	@Override
	public int updateDailyLog(DailyLogDTO dailyLogDTO) throws Exception {
		return myNorangDAO.updateDailyLog(dailyLogDTO);
	}

	// 일일 데이터 삭제
	@Override
	public int deleteDailyLog(DailyLogDTO dailyLogDTO) throws Exception {
		return myNorangDAO.deleteDailyLog(dailyLogDTO);
	}

	// 기분 상태 조회(주간)
	@Override
	public List<MoodStateDTO> selectMoodStateList(MoodStateDTO moodStateDTO) throws Exception {
		return myNorangDAO.selectMoodStateList(moodStateDTO);
	}

	// 챌린지 조회(전체)
	@Override
	public List<ChallengeDTO> selectChallengeList(int memberId) throws Exception {
		return myNorangDAO.selectChallengeList(memberId);
	}

}
