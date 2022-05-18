package com.narangnorang.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.narangnorang.dto.DeptDTO;

@Repository("deptDAO")
public class DeptDAO {

	@Autowired
	SqlSession sqlSession;

	public List<DeptDTO> selectAll() {
		return sqlSession.selectList("com.config.DeptMapper.selectAll");
	}

	public int insert(DeptDTO deptDTO) {
		return sqlSession.insert("com.config.DeptMapper.insert", deptDTO);
	}

	public DeptDTO selectByDeptno(int deptno) {
		return sqlSession.selectOne("com.config.DeptMapper.selectByDeptno", deptno);
	}

	public int update(DeptDTO deptDTO) {
		return sqlSession.update("com.config.DeptMapper.update", deptDTO);
	}

	public int delete(int deptno) {
		return sqlSession.delete("com.config.DeptMapper.delete", deptno);
	}

}
