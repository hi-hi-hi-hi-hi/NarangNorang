package com.narangnorang.dao;

import java.util.List;

import com.narangnorang.dto.MyItemDTO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.narangnorang.dto.ItemDTO;
import com.narangnorang.dto.PostDTO;

@Repository
public class MiniroomDAO {

	
	@Autowired
	SqlSession sqlSession;
	
	public List<ItemDTO> selectAllItems(String category){
		return sqlSession.selectList("com.config.MiniroomMapper.selectAllItems",category);
	}
	public int insert(MyItemDTO myItemDTO){
		return sqlSession.insert("com.config.MiniroomMapper.insert",myItemDTO);
	}
	
}
