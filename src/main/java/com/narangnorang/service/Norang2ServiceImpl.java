package com.narangnorang.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.narangnorang.dao.Norang2DAO;
import com.narangnorang.dto.ChallengeDTO;
import com.narangnorang.dto.DailyLogDTO;
import com.narangnorang.dto.MoodStateDTO;

@Service("norang2Service")
public class Norang2ServiceImpl implements Norang2Service {

	@Autowired
	Norang2DAO norang2DAO;

	// 챌린지 조회(하루)
	@Override
	public ChallengeDTO selectChallenge(ChallengeDTO challengeDTO) throws Exception {
		return norang2DAO.selectChallenge(challengeDTO);
	}

	// 일일 데이터 조회(하루)
	@Override
	public DailyLogDTO selectDailyLog(DailyLogDTO dailyLogDTO) throws Exception {
		return norang2DAO.selectDailyLog(dailyLogDTO);
	}

	// 기분 상태 조회(접속일시 이후)
	@Override
	public MoodStateDTO selectMoodState(MoodStateDTO moodStateDTO) throws Exception {
		return norang2DAO.selectMoodState(moodStateDTO);
	}

	// 챌린지 저장
	@Transactional
	@Override
	public int insertChallenge(ChallengeDTO challengeDTO) throws Exception {
		norang2DAO.updatePoint(challengeDTO); // 챌린지 보상
		return norang2DAO.insertChallenge(challengeDTO);
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
