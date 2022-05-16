package com.narangnorang.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.narangnorang.dto.MemberDTO;

@Repository("counselDAO")
public class CounselDAO {
	
	@Autowired
	SqlSession sqlSession;
	
	// 상담사 List
	public List<MemberDTO> selectCounselorList() {
		return sqlSession.selectList("com.config.CounselMapper.selectCounselorList");
	}

}
