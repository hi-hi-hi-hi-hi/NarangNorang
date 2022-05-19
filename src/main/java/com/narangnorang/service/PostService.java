package com.narangnorang.service;

import java.util.HashMap;
import java.util.List;

import com.narangnorang.dto.PageDTO;
import com.narangnorang.dto.PostDTO;

public interface PostService {
	public List<PostDTO> selectAllByCategory(HashMap<String, Object> map) throws Exception;
//	public PageDTO<PostDTO> totalRecord(String category) throws Exception;
	public PostDTO selectById(int id) throws Exception;
	public int insert(PostDTO dto) throws Exception;
	public int update(PostDTO dto) throws Exception;
	public int delete(int id) throws Exception;
	public List<PostDTO> search(HashMap<String,Object> map) throws Exception;
}