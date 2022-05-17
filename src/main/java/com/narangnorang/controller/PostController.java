package com.narangnorang.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.narangnorang.dto.MemberDTO;
import com.narangnorang.dto.PostDTO;
import com.narangnorang.service.PostService;

@Controller
public class PostController {

	@Autowired
	PostService postService;
	
	// 게시판 목록 보기
	@GetMapping("/post")
	public ModelAndView postList(String category) throws Exception{
		ModelAndView mav = new ModelAndView("postList");
		List<PostDTO> list = postService.selectAllByCategory(category);

		mav.addObject("postList", list);
		mav.addObject("category", category);
		return mav;
	}
	
	//글 검색
	@ResponseBody
	@GetMapping("/post/search")
	public List<PostDTO> search(String searchCol, String keyword, String category) throws Exception{
		HashMap<String, Object> map = new HashMap<>();
		map.put("searchCol", searchCol);
		map.put("keyword", keyword);
		map.put("category", category);
		return postService.search(map);

	}
	
	@GetMapping("/post/{id}")
	public ModelAndView postRetrieve(@PathVariable int id) throws Exception{
		PostDTO pDto = postService.selectById(id);
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("postRetrieve");
		mav.addObject("retrieve", pDto);
		return mav;
	}
	

	// 글쓰기 페이지
	@GetMapping("/post/write")
	public ModelAndView postWrite(String category) throws Exception{
		ModelAndView mav = new ModelAndView("postWrite");
		mav.addObject("category", category);
		return mav;
	}

	// 글 등록
	@PostMapping("/post/write")
	public ModelAndView postWritePro(PostDTO pDto, HttpSession session) throws Exception{
		ModelAndView mav = new ModelAndView("post/postWriteSuccess");
		MemberDTO mDto = (MemberDTO)session.getAttribute("login");
		String userId = mDto.getId();
		pDto.setMemberId(userId);
		mav.addObject("category", pDto.getCategory());
		int result = postService.insert(pDto);
		return mav;
	}
	
	// 게시글 삭제
	@ResponseBody
	@DeleteMapping("/post/{id}")
	public int postDelete(@PathVariable int id) throws Exception{
		int result = postService.delete(id);
		return result;
	}
	
	// 게시글 수정 페이지
	@GetMapping("/post/edit/{id}")
	public ModelAndView postEdit(@PathVariable int id) throws Exception{
		PostDTO pDto = postService.selectById(id);
		ModelAndView mav = new ModelAndView("post/postEdit");
		mav.addObject("pDto", pDto);
		return mav;
	}
	
	// 게시글 수정
	@ResponseBody
	@PutMapping("/post/{id}")
	public int postEditPro(@PathVariable int id, PostDTO pDto) throws Exception{
		int result = postService.update(pDto);
		return result;
	}
	
	// 에러 처리
	@ExceptionHandler({ Exception.class })
	public String error() throws Exception {
		return "common/error";
	}
}
