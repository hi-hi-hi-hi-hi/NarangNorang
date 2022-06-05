package com.narangnorang.service;

import java.util.List;

import com.narangnorang.dto.ChallengeDTO;
import com.narangnorang.dto.DailyLogDTO;
import com.narangnorang.dto.MoodStateDTO;

public interface MyNorangService {

	// 일일 데이터 조회(한달)
	public List<DailyLogDTO> selectDailyLogList(DailyLogDTO dailyLogDTO) throws Exception;

	// 일일 데이터 조회(하루)
	public DailyLogDTO selectDailyLog(DailyLogDTO dailyLogDTO);

	// 일일 데이터 저장
	public int insertDailyLog(DailyLogDTO dailyLogDTO) throws Exception;

	// 일일 데이터 수정
	public int updateDailyLog(DailyLogDTO dailyLogDTO) throws Exception;

	// 일일 데이터 삭제
	public int deleteDailyLog(DailyLogDTO dailyLogDTO) throws Exception;

	// 기분 상태 조회(주간)
	public List<MoodStateDTO> selectMoodStateList(MoodStateDTO moodStateDTO) throws Exception;

	// 챌린지 조회(전체)
	public List<ChallengeDTO> selectChallengeList(int memberId) throws Exception;

}
