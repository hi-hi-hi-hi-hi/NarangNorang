package com.narangnorang.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.narangnorang.dao.MoodStateDAO;
import com.narangnorang.dto.MoodStateDTO;

@Service("moodStateService")
public class MoodStateServiceImpl implements MoodStateService {

	@Autowired
	MoodStateDAO moodStateDAO;

	// 기분 상태 조회
	@Override
	public List<MoodStateDTO> selectList(MoodStateDTO moodStateDTO) throws Exception {
		return moodStateDAO.selectList(moodStateDTO);
	}

	// 기분 상태 저장
	@Override
	public int insert(MoodStateDTO moodStateDTO) throws Exception {
		return moodStateDAO.insert(moodStateDTO);
	}

}
