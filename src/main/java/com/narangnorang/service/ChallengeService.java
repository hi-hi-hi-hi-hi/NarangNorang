package com.narangnorang.service;

import java.util.List;

import com.narangnorang.dto.ChallengeDTO;

public interface ChallengeService {

	// 챌린지 조회
	public List<ChallengeDTO> selectList(int memberId) throws Exception;

}
