package com.narangnorang.service;

import java.util.List;

import com.narangnorang.dto.DeptDTO;

public interface DeptService {

	public List<DeptDTO> selectAll();

	public int insert(DeptDTO deptDTO);

	public DeptDTO selectByDeptno(int deptno);

	public int update(DeptDTO deptDTO);

	public int delete(int deptno);

}
