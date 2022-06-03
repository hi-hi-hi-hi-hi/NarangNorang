package com.narangnorang.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.narangnorang.dao.DailyLogDAO;
import com.narangnorang.dto.DailyLogDTO;

@Service("dailyLogService")
public class DailyLogServiceImpl implements DailyLogService {

	@Autowired
	DailyLogDAO dailyLogDAO;

	// 일일 데이터 조회(한달)
	@Override
	public List<DailyLogDTO> selectList(DailyLogDTO dailyLogDTO) throws Exception {
		return dailyLogDAO.selectList(dailyLogDTO);
	}

	// 일일 데이터 조회(하루)
	@Override
	public DailyLogDTO selectOne(DailyLogDTO dailyLogDTO) {
		return dailyLogDAO.selectOne(dailyLogDTO);
	}

	// 일일 데이터 저장
	@Override
	public int insert(DailyLogDTO dailyLogDTO) throws Exception {
		return dailyLogDAO.insert(dailyLogDTO);
	}

	// 일일 데이터 수정
	@Override
	public int update(DailyLogDTO dailyLogDTO) throws Exception {
		return dailyLogDAO.update(dailyLogDTO);
	}

	// 일일 데이터 삭제
	@Override
	public int delete(DailyLogDTO dailyLogDTO) throws Exception {
		return dailyLogDAO.delete(dailyLogDTO);
	}

}
