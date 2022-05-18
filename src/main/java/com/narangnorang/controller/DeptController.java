package com.narangnorang.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.servlet.ModelAndView;

import com.narangnorang.dto.DeptDTO;
import com.narangnorang.service.DeptService;

@Controller
public class DeptController {

	@Autowired
	DeptService deptService;

	// 목록보기 ==> select ==> GET 처리
	@GetMapping("/departments")
	@ModelAttribute("deptList")
	public List<DeptDTO> selectAll() {
		return deptService.selectAll();
	}

	// 저장 ==> insert ==> POST 처리
	@PostMapping("/departments")
	public String insert(DeptDTO deptDTO) {
		deptService.insert(deptDTO);
		return "redirect:/departments";
	}

	// 자세히보기 ==> select ==> GET 처리
	@GetMapping("/departments/{deptno}")
	public ModelAndView select(@PathVariable("deptno") int deptno) {
		DeptDTO deptDTO = deptService.selectByDeptno(deptno);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("retrieve");
		modelAndView.addObject("deptDTO", deptDTO);
		return modelAndView;
	}

	// 수정 ==> update ==> PUT 처리
	@PutMapping("/departments/{deptno}")
	public String update(@PathVariable("deptno") int deptno, DeptDTO deptDTO) {
		deptService.update(deptDTO);
		return "redirect:/departments";
	}

	// 삭제 ==> delete ==> DELETE 처리
	@DeleteMapping("/departments/{deptno}")
	public String delete(@PathVariable("deptno") int deptno) {
		deptService.delete(deptno);
		return "redirect:/departments";
	}

}
