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

	public int insertDefaultItems(HashMap<String, String> map) {
		return sqlSession.insert("com.config.MiniroomMapper.insertDefaultItems",map);
	}
	public int wishupdate(int itemId) {
		return sqlSession.update("com.config.MiniroomMapper.wishupdate", itemId);
	}
	public int wishzero(int itemId) {
		return sqlSession.update("com.config.MiniroomMapper.wishzero", itemId);
	}

	public int applyMiniroom(MyItemDTO myItemDTO){
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
	public MyItemDTO selectByMyItemId(HashMap<String, Object> map){
		return sqlSession.selectOne("com.config.MiniroomMapper.selectByMyItemId",map);
	}

	public List<MyItemDTO> selectAllMyItems(HashMap<String, Object> map) {
		return sqlSession.selectList("com.config.MiniroomMapper.selectAllMyItems",map);
	}
	public MyRoomDTO selectMyRoom(int id){
		return sqlSession.selectOne("com.config.MiniroomMapper.selectMyRoom",id);
	}
	public MemberDTO selectMember(String email) {
		return sqlSession.selectOne("com.config.miniroomMapper.selectMember",email);

	}

	public int updatePoint(HashMap<String, Object> pointMap) {
		return sqlSession.update("com.config.miniroomMapper.updatePoint",pointMap);
	}

	public ItemDTO selectClickItem(Integer itemId) {
		return sqlSession.selectOne("com.config.miniroomMapper2.selectClickItem",itemId);
	}
}
