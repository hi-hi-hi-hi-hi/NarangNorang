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
	public int insertBuy(MyItemDTO myItemDTO){
		return sqlSession.insert("com.config.MiniroomMapper.insertBuy",myItemDTO);
	}

	public int insertDefaultItems(String name) {
		return sqlSession.insert("com.config.MiniroomMapper.insertDefaultItems",name);
	}
	public int applyMiniroom(MyItemDTO myItemDTO){
		if(myItemDTO.getItemId() <= 10){
			return sqlSession.update("com.config.MiniroomMapper.applyMiniroomFloor",myItemDTO);
		}else if(myItemDTO.getItemId() <= 20){
			return sqlSession.update("com.config.MiniroomMapper.applyMiniroomWallpaper",myItemDTO);
		}else if(myItemDTO.getItemId() <= 30){
			return sqlSession.update("com.config.MiniroomMapper.applyMiniroomBed",myItemDTO);
		}else if(myItemDTO.getItemId() <= 40){
			return sqlSession.update("com.config.MiniroomMapper.applyMiniroomCloset",myItemDTO);
		}else if(myItemDTO.getItemId() <= 50){
			return sqlSession.update("com.config.MiniroomMapper.applyMiniroomDesk",myItemDTO);
		}
		return sqlSession.update("com.config.MiniroomMapper.applyMiniroomWalldeco",myItemDTO);

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
		return sqlSession.update("com.config.MiniroomMapper.wishzero", map);
	}
	public List<ItemDTO> selectAllWishItems(HashMap<String, Object> map) {
		return sqlSession.selectList("com.config.MiniroomMapper.selectAllWishItems",map);
	}
}
