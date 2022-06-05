package com.narangnorang.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.narangnorang.dao.Norang2DAO;
import com.narangnorang.dto.DailyLogDTO;
import com.narangnorang.dto.MoodStateDTO;

@Service("norang2Service")
public class Norang2ServiceImpl implements Norang2Service {

	@Autowired
	Norang2DAO norang2DAO;

	// 일일 데이터 조회(하루)
	@Override
	public DailyLogDTO selectDailyLog(DailyLogDTO dailyLogDTO) {
		return norang2DAO.selectDailyLog(dailyLogDTO);
	}

	// 일일 데이터 저장
	@Override
	public int insertDailyLog(DailyLogDTO dailyLogDTO) throws Exception {
		return norang2DAO.insertDailyLog(dailyLogDTO);
	}

	// 기분 상태 저장
	@Override
	public int insertMoodState(MoodStateDTO moodStateDTO) throws Exception {
		return norang2DAO.insertMoodState(moodStateDTO);
	}

}
