package com.narangnorang.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.narangnorang.dao.NorangDAO;
import com.narangnorang.dto.ChallengeDTO;

@Service("norangService")
public class NorangServiceImpl implements NorangService {

	@Autowired
	NorangDAO norangDAO;
	
	// 일일 챌린지 도전 유무 조회
	@Override
	public int dailyChallengeDo(ChallengeDTO dto) throws Exception {
		return norangDAO.dailyChallengeDo(dto);
	}

	// 일일 챌린지 사진 업로드
	@Override
	public int dailyChallengeUpload(ChallengeDTO dto) throws Exception {
		return norangDAO.dailyChallengeUpload(dto);
	}

}
