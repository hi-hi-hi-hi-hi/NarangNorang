package com.narangnorang.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.narangnorang.dto.ChallengeDTO;

@Repository("challengeDAO")
public class ChallengeDAO {

	@Autowired
	SqlSession sqlSession;

	// 챌린지 조회
	public List<ChallengeDTO> selectList(int memberId) throws Exception {
		return sqlSession.selectList("com.config.ChallengeMapper.selectList", memberId);
	}

}
