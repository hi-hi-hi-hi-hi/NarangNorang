package com.narangnorang.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.narangnorang.dao.DeptDAO;
import com.narangnorang.dto.DeptDTO;

@Service("deptService")
public class DeptServiceImpl implements DeptService {

	@Autowired
	DeptDAO deptDAO;

	@Override
	public List<DeptDTO> selectAll() {
		return deptDAO.selectAll();
	}

	@Override
	public int insert(DeptDTO deptDTO) {
		return deptDAO.insert(deptDTO);
	}

	@Override
	public DeptDTO selectByDeptno(int deptno) {
		return deptDAO.selectByDeptno(deptno);
	}

	@Override
	public int update(DeptDTO deptDTO) {
		return deptDAO.update(deptDTO);
	}

	@Override
	public int delete(int deptno) {
		return deptDAO.delete(deptno);
	}

}
