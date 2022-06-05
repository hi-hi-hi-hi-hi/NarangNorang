package com.narangnorang.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.narangnorang.dto.ChallengeDTO;


@Repository("norangDAO")
public class NorangDAO {
	
	@Autowired
	SqlSession sqlSession;
	
	// 일일 챌린지 도전 유무 조회
	public int dailyChallengeDo(ChallengeDTO dto) throws Exception {
		return sqlSession.selectOne("com.config.NorangMapper.dailyChallengeDo", dto);
	}
	
	// 일일 챌린지 사진 업로드
	public int dailyChallengeUpload(ChallengeDTO dto) throws Exception {
		return sqlSession.insert("com.config.NorangMapper.dailyChallengeUpload", dto);
	}

}
