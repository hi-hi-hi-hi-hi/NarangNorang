package com.narangnorang.service;

import java.util.HashMap;
import java.util.List;

import com.narangnorang.dto.PageDTO;
import com.narangnorang.dto.PostDTO;
import com.narangnorang.dto.PostLikerDTO;
import com.narangnorang.dto.ReplyDTO;

public interface PostService {
	public List<PostDTO> selectAllByCategory(HashMap<String, Object> map) throws Exception;
	public PageDTO<PostDTO> totalRecord(HashMap<String,Object> map) throws Exception;
	public PostDTO selectById(int id) throws Exception;
	public List<ReplyDTO> selectAllReply(int id) throws Exception;
	public PostDTO selectByLikes(HashMap<String,Object> map) throws Exception;
	public int insert(PostDTO dto) throws Exception;
	public int update(PostDTO dto) throws Exception;
	public int delete(int id) throws Exception;
	public List<PostDTO> search(HashMap<String,Object> map) throws Exception;
	public PageDTO<PostDTO> searchRecord(HashMap<String, Object> map) throws Exception;
	public int insertReply(HashMap<String, Object> map) throws Exception;
	public int deleteReply(HashMap<String, Object> map) throws Exception;
	public int updateReplyContent(ReplyDTO dto) throws Exception;
	public int insertPostLiker(PostLikerDTO dto) throws Exception;
	public List<PostLikerDTO> selectPostLiker(PostLikerDTO dto) throws Exception;
	public int deletePostLiker(PostLikerDTO dto) throws Exception;
}