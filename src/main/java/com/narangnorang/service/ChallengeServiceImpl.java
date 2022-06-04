package com.narangnorang.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.narangnorang.dao.ChallengeDAO;
import com.narangnorang.dto.ChallengeDTO;

@Service("challengeService")
public class ChallengeServiceImpl implements ChallengeService {

	@Autowired
	ChallengeDAO challengeDAO;

	// 챌린지 조회
	@Override
	public List<ChallengeDTO> selectList(int memberId) throws Exception {
		return challengeDAO.selectList(memberId);
	}

}
