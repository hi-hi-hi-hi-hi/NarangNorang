package com.narangnorang.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.narangnorang.dao.PostDAO;
import com.narangnorang.dto.PostDTO;


@Service("postService")
public class PostServiceImpl implements PostService {

	PostDAO postDAO;
	//생성자 주입
	public PostServiceImpl(PostDAO dao) {
		this.postDAO = dao;
	}

	@Override
	public List<PostDTO> selectAll() {
		return postDAO.selectAll();
	}

	@Override
	public PostDTO selectById(int id) {
		return postDAO.selectById(id);
	}

	@Override
	public int insert(PostDTO postDTO) {
		return postDAO.insert(postDTO);
	}

}
