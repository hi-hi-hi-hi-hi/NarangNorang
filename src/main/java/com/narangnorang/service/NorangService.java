package com.narangnorang.service;

import com.narangnorang.dto.ChallengeDTO;

public interface NorangService {
	
	// 일일 챌린지 도전 유무 조회
	public int dailyChallengeDo(ChallengeDTO dto) throws Exception;
	
	// 일일 챌린지 사진 업로드
	public int dailyChallengeUpload(ChallengeDTO dto) throws Exception;
	
}
