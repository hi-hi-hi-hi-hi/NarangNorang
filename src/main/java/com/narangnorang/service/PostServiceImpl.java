package com.narangnorang.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.narangnorang.dao.PostDAO;
import com.narangnorang.dto.LikerDTO;
import com.narangnorang.dto.PageDTO;
import com.narangnorang.dto.PostDTO;
import com.narangnorang.dto.ReplyDTO;

@Service("postService")
public class PostServiceImpl implements PostService {

	@Autowired
	PostDAO dao;
	
	@Override
	public List<PostDTO> selectAllByCategory(HashMap<String, Object> map) {
		return dao.selectAllByCategory(map);
	}
	
	@Override
	public PageDTO<PostDTO> totalRecord(HashMap<String,Object> map) throws Exception {
		return dao.totalRecord(map);
	}
	
	@Transactional
	@Override
	public PostDTO selectById(int id)  throws Exception{
		dao.updateViews(id);
		return dao.selectById(id);
	}
	
	@Override
	public List<ReplyDTO> selectAllReply(int id) throws Exception {
		return dao.selectAllReply(id);
	}
	
	@Override
	public PostDTO selectByLikes(HashMap<String, Object> map) throws Exception {
		return dao.selectByLikes(map);
	}

	@Override
	public int insert(PostDTO dto)  throws Exception{
		return dao.insert(dto);
	}

	@Override
	public int update(PostDTO dto)  throws Exception{
		return dao.update(dto);
	}
	
	@Override
	public int delete(int id)  throws Exception{
		return dao.delete(id);
	}

	@Override
	public List<PostDTO> search(HashMap<String, Object> map) throws Exception {
		return dao.search(map);
	}
	
	@Override
	public PageDTO<PostDTO> searchRecord(HashMap<String, Object> map) throws Exception {
		return dao.searchRecord(map);
	}
	
	@Transactional
	@Override
	public int insertReply(ReplyDTO dto) throws Exception {
		dao.updateReplies(Integer.parseInt(dto.getPostId()));
		return dao.insertReply(dto);
	}

	@Override
	public int insertLiker(LikerDTO dto) throws Exception {
		dao.updateLiker(Integer.parseInt(dto.getPostId()));
		return dao.insertLiker(dto);
	}
}
