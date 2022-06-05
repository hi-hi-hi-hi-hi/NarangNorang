package com.narangnorang.service;

import com.narangnorang.dto.DailyLogDTO;
import com.narangnorang.dto.MoodStateDTO;

public interface Norang2Service {

	// 일일 데이터 조회(하루)
	public DailyLogDTO selectDailyLog(DailyLogDTO dailyLogDTO);

	// 일일 데이터 저장
	public int insertDailyLog(DailyLogDTO dailyLogDTO) throws Exception;

	// 기분 상태 저장
	public int insertMoodState(MoodStateDTO moodStateDTO) throws Exception;

}
