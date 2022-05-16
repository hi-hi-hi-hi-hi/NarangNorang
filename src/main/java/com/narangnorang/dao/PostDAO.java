package com.narangnorang.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.narangnorang.dto.PostDTO;

@Repository
public class PostDAO {

	
	@Autowired
	SqlSession sqlSession;
	
	public List<PostDTO> selectAll() {
		return sqlSession.selectList("com.config.PostMapper.selectAll");
	}
	public PostDTO selectById(int id) {
		return sqlSession.selectOne("com.config.PostMapper.selectById", id);
	}
	
	public int insert(PostDTO postDTO) {
		
		return sqlSession.insert("com.config.PostMapper.insert", postDTO);
	}
}
