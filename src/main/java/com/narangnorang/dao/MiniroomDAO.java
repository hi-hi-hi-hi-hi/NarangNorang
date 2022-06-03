package com.narangnorang.dao;

import java.util.HashMap;
import java.util.List;

import com.narangnorang.dto.*;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MiniroomDAO {


	@Autowired
	SqlSession sqlSession;

	public List<ItemDTO> selectAllItems(String category){
		return sqlSession.selectList("com.config.MiniroomMapper.selectAllItems",category);
	}
	public int insertBuy(HashMap<String, Object> map){
		return sqlSession.insert("com.config.MiniroomMapper.insertBuy",map);
	}

	public int insertDefaultItems(String name) {
		return sqlSession.insert("com.config.MiniroomMapper.insertDefaultItems",name);
	}
	public int applyMiniroom(HashMap<String, Object>map){
		return sqlSession.update("com.config.MiniroomMapper.applyMiniroom",map);
	}

	public MyItemDTO selectByMyItemId(HashMap<String, Object> map){
		return sqlSession.selectOne("com.config.MiniroomMapper.selectByMyItemId",map);
	}
	public List<MyItemDTO> selectAllMyItems(HashMap<String, Object> map) {
		return sqlSession.selectList("com.config.MiniroomMapper.selectAllMyItems",map);
	}

	public MyRoomDTO selectMyRoom(int id){
		return sqlSession.selectOne("com.config.MiniroomMapper.selectMyRoom",id);
	}

	public int updatePoint(HashMap<String, Integer> pointMap) {
		return sqlSession.update("com.config.MiniroomMapper.updatePoint",pointMap);
	}

	public int wishInsert(HashMap<String, Object> map){
		return sqlSession.insert("com.config.MiniroomMapper.wishInsert", map);
	}
	public int wishDelete(HashMap<String, Object> map){
		return sqlSession.delete("com.config.MiniroomMapper.wishDelete", map);
	}

	public int wishZero(HashMap<String, Object> map) {
		return sqlSession.update("com.config.MiniroomMapper.wishZero", map);
	}
	public List<ItemDTO> selectAllWishItems(HashMap<String, Object> map) {
		return sqlSession.selectList("com.config.MiniroomMapper.selectAllWishItems",map);
	}
}
