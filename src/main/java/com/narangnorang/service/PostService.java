package com.narangnorang.service;

import java.util.List;

import com.narangnorang.dto.PostDTO;

public interface PostService {
	public List<PostDTO> selectAll();
	public PostDTO selectById(int id);
	public int insert(PostDTO postDTO);
}
