package com.narangnorang.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.narangnorang.dto.PageDTO;
import com.narangnorang.dto.PostDTO;
import com.narangnorang.dto.PostLikerDTO;
import com.narangnorang.dto.ReplyDTO;

@Repository("postDAO")
public class PostDAO {
	@Autowired
	SqlSession session;
	
	public List<PostDTO> selectAllByCategory(HashMap<String, Object> map) throws Exception {
		return session.selectList("com.config.PostMapper.selectAllByCategory", map);
	}
	
	public PageDTO<PostDTO> totalRecord(HashMap<String, Object> map) throws Exception {
		return session.selectOne("com.config.PostMapper.totalRecord", map);
	}
	
	public PostDTO selectById(int id) throws Exception {
		return session.selectOne("com.config.PostMapper.selectById", id);
	}
	
	public List<ReplyDTO> selectAllReply(int id) throws Exception {
		return session.selectList("com.config.PostMapper.selectAllReply", id);
	}
	
	public PostDTO selectByLikes(HashMap<String, Object> map) throws Exception {
		return session.selectOne("com.config.PostMapper.selectByLikes", map);
	}
	
	public int updateViews(int id) throws Exception {
		return session.update("com.config.PostMapper.updateViews", id);
	}
	
	public List<PostDTO> search(HashMap<String, Object> map) throws Exception {
		return session.selectList("com.config.PostMapper.search", map);
	}
	
	public PageDTO<PostDTO> searchRecord(HashMap<String, Object> map) throws Exception {
		return session.selectOne("com.config.PostMapper.searchRecord", map);
	}
	
	public int insert(PostDTO dto) throws Exception {
		return session.insert("com.config.PostMapper.insert", dto);
	}
	
	public int update(PostDTO dto) throws Exception {
		return session.update("com.config.PostMapper.update", dto);
	}
	
	public int delete(int id) throws Exception {
		return session.delete("com.config.PostMapper.delete", id);
	}
	
	public int insertReply(ReplyDTO dto) throws Exception {
		return session.insert("com.config.PostMapper.insertReply", dto);
	}
	
	public int deleteReply(int id) {
		return session.delete("com.config.PostMapper.deleteReply", id);
	}
	
	public int updateReplyContent(ReplyDTO dto) {
		return session.update("com.config.PostMapper.updateReplyContent", dto);
	}
	
	public int updateReplies(HashMap<String, Object> map) {
		return session.update("com.config.PostMapper.updateReplies", map);
	}
	
	public int insertPostLiker(PostLikerDTO dto) {
		return session.insert("com.config.PostMapper.insertPostLiker", dto);
	}
	
	public int plusPostLike(int id) {
		return session.update("com.config.PostMapper.plusPostLike", id);
	}
	
	public int minusPostLike(int id) {
		return session.update("com.config.PostMapper.minusPostLike", id);
	}
	
	public List<PostLikerDTO> selectPostLiker(PostLikerDTO dto) {
		return session.selectList("com.config.PostMapper.selectPostLiker", dto);
	}
	
	public int deletePostLiker(int id) {
		return session.delete("com.config.PostMapper.deletePostLiker", id);
	}
}
