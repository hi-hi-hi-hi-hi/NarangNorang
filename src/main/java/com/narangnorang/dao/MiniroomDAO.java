package com.narangnorang.dao;

import java.util.List;
import java.util.Map;

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

	public int insertDefaultItems(String id) {
		return sqlSession.insert("com.config.MiniroomMapper.insertDefaultItems",id);
	}
	public int wishupdate(int itemId) {
		return sqlSession.update("com.config.MiniroomMapper.wishupdate", itemId);
	}

	public int applyMiniroom(MyItemDTO myItemDTO){
		System.out.println(myItemDTO.getMemberId());
		System.out.println(myItemDTO.getItemId());
		if(myItemDTO.getItemId() <= 10){
			return sqlSession.update("com.config.MiniroomMapper.applyMiniroomFloor",myItemDTO);
		}else if(myItemDTO.getItemId() <= 20){
			return sqlSession.update("com.config.MiniroomMapper.applyMiniroomWallpaper",myItemDTO);
		}else if(myItemDTO.getItemId() <= 30){

			System.out.println(myItemDTO.getItemId());
			return sqlSession.update("com.config.MiniroomMapper.applyMiniroomBed",myItemDTO);
		}else if(myItemDTO.getItemId() <= 40){
			return sqlSession.update("com.config.MiniroomMapper.applyMiniroomCloset",myItemDTO);
		}else if(myItemDTO.getItemId() <= 50){
			return sqlSession.update("com.config.MiniroomMapper.applyMiniroomDesk",myItemDTO);
		}
			return sqlSession.update("com.config.MiniroomMapper.applyMiniroomWalldeco",myItemDTO);

	}
	public MyItemDTO selectByMyItemId(int itemId){
		return sqlSession.selectOne("com.config.MiniroomMapper.selectByMyItemId",itemId);
	}
//	public List<MyItemDTO> selectAllMyItems(Map<String,String> map) {
//		return sqlSession.selectList("com.config.MiniroomMapper.selectAllMyItems",map);
//	}
	public List<MyItemDTO> selectAllMyItems(String category) {
		return sqlSession.selectList("com.config.MiniroomMapper.selectAllMyItems",category);
	}
	public MyRoomDTO selectMyRoom(String memberId){
		return sqlSession.selectOne("com.config.MiniroomMapper.selectMyRoom",memberId);
	}
}
