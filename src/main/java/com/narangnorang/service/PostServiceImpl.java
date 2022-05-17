package com.narangnorang.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.narangnorang.dao.PostDAO;
import com.narangnorang.dto.PostDTO;

@Service("postService")
public class PostServiceImpl implements PostService {

	@Autowired
	PostDAO dao;
	
	@Override
	public List<PostDTO> selectAllByCategory(String category) {
		return dao.selectAllByCategory(category);
	}

	@Transactional
	@Override
	public PostDTO selectById(int id)  throws Exception{
		dao.updateViews(id);
		return dao.selectById(id);
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

}
