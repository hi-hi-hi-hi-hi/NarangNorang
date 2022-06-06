package com.narangnorang.service;

import com.narangnorang.dto.ChallengeDTO;
import com.narangnorang.dto.DailyLogDTO;
import com.narangnorang.dto.MoodStateDTO;

public interface Norang2Service {

	// 챌린지 조회(하루)
	public ChallengeDTO selectChallenge(ChallengeDTO challengeDTO) throws Exception;

	// 일일 데이터 조회(하루)
	public DailyLogDTO selectDailyLog(DailyLogDTO dailyLogDTO) throws Exception;

	// 기분 상태 조회(접속일시 이후)
	public MoodStateDTO selectMoodState(MoodStateDTO moodStateDTO) throws Exception;

	// 챌린지 저장
	public int insertChallenge(ChallengeDTO challengeDTO) throws Exception;

	// 일일 데이터 저장
	public int insertDailyLog(DailyLogDTO dailyLogDTO) throws Exception;

	// 기분 상태 저장
	public int insertMoodState(MoodStateDTO moodStateDTO) throws Exception;

}
