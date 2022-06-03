package com.narangnorang.service;

import java.util.List;

import com.narangnorang.dto.DailyLogDTO;

public interface DailyLogService {

	// 일일 데이터 조회(한달)
	public List<DailyLogDTO> selectList(DailyLogDTO dailyLogDTO) throws Exception;

	// 일일 데이터 조회(하루)
	public DailyLogDTO selectOne(DailyLogDTO dailyLogDTO);

	// 일일 데이터 저장
	public int insert(DailyLogDTO dailyLogDTO) throws Exception;

	// 일일 데이터 수정
	public int update(DailyLogDTO dailyLogDTO) throws Exception;

	// 일일 데이터 삭제
	public int delete(DailyLogDTO dailyLogDTO) throws Exception;

}
