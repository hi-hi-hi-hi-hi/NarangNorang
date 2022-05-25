package com.narangnorang.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.narangnorang.dto.PageDTO;
import com.narangnorang.dto.PostDTO;
import com.narangnorang.dto.ReplyDTO;

@Repository("postDAO")
public class PostDAO {
	@Autowired
	SqlSession session;
	
	public List<PostDTO> selectAllByCategory(HashMap<String, Object> map){
		return session.selectList("com.config.PostMapper.selectAllByCategory", map);
	}
	
	public PageDTO<PostDTO> totalRecord(HashMap<String, Object> map) {
		return session.selectOne("com.config.PostMapper.totalRecord", map);
	}
	
	public PostDTO selectById(int id) {
		return session.selectOne("com.config.PostMapper.selectById", id);
	}
	
	public List<ReplyDTO> selectAllReply(int id) {
		return session.selectList("com.config.PostMapper.selectAllReply", id);
	}
	
	public PostDTO selectByLikes(HashMap<String, Object> map) {
		return session.selectOne("com.config.PostMapper.selectByLikes", map);
	}
	
	public int updateViews(int id) {
		return session.update("com.config.PostMapper.updateViews", id);
	}
	
	public List<PostDTO> search(HashMap<String, Object> map) {
		return session.selectList("com.config.PostMapper.search", map);
	}
	
	public int insert(PostDTO dto) {
		return session.insert("com.config.PostMapper.insert", dto);
	}
	
	public int update(PostDTO dto) {
		return session.update("com.config.PostMapper.update", dto);
	}
	
	public int delete(int id) {
		return session.delete("com.config.PostMapper.delete", id);
	}
	
	public int insertReply(ReplyDTO dto) {
		return session.insert("com.config.PostMapper.insertReply", dto);
	}
	
	public int updateReplies(int id) {
		return session.update("com.config.PostMapper.updateReplies", id);
	}
}
