package com.narangnorang.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.narangnorang.dto.PostDTO;
import com.narangnorang.dto.DeptDTO;
import com.narangnorang.dto.MemberDTO;
import com.narangnorang.service.MemberService;
import com.narangnorang.service.PostService;

@Controller
public class PostController {

	@Autowired
	MemberService memberService;
	@Autowired
	PostService postService;
	
	
//	//글 자세히보기 
//	@GetMapping("/post/{id}")
//	public ModelAndView select(@PathVariable("id")int id){
//		
//		PostDTO postDTO =  postService.selectById(id);
//		ModelAndView modelAndView = new ModelAndView();
//		modelAndView.setViewName("retrieve");
//		modelAndView.addObject("postDTO", postDTO);
//		return modelAndView;
//	}
	//글 자세히 보기 
	@GetMapping("/post/{id}")
	public ModelAndView select(@PathVariable("id")int id) throws Exception{
		
		PostDTO postDTO =  postService.selectById(id);
		ModelAndView mav = new ModelAndView("retrieve");
		mav.addObject("postDTO", postDTO);
		return mav;
	}
	
	//글 쓰기 -> 글 저장 
	@PostMapping(value="/post")
	public String insert(PostDTO postDTO) throws Exception{
		postService.insert(postDTO);
		return "redirect:/home";
	}
	
	// 글쓰기 폼
		@GetMapping("post/writeUI")
		public String writeUI() throws Exception {
			return "post/writeUI";
		}
		//게시판 메인 
		@GetMapping("/post")
		public String post(HttpSession session) throws Exception {
			List<PostDTO> list =  postService.selectAll();
			session.setAttribute("postList", list);
			return "post";
		}

}
