package com.narangnorang.service;

import java.util.List;

import com.narangnorang.dto.DailyLogDTO;

public interface DailyLogService {

	// 일일 데이터 저장
	public int insert(DailyLogDTO dailyLogDTO) throws Exception;

	// 일일 데이터 조회
	public List<DailyLogDTO> selectList(int memberId) throws Exception;

}
