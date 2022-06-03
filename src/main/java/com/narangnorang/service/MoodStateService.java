package com.narangnorang.service;

import java.util.List;

import com.narangnorang.dto.MoodStateDTO;

public interface MoodStateService {

	// 기분 상태 조회
	public List<MoodStateDTO> selectList(MoodStateDTO moodStateDTO) throws Exception;

	// 기분 상태 저장
	public int insert(MoodStateDTO moodStateDTO) throws Exception;

}
