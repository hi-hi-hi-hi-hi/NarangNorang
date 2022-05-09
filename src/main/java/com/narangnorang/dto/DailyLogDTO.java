package com.narangnorang.dto;

import org.apache.ibatis.type.Alias;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Alias("DailyLogDTO")
public class DailyLogDTO {

	private int id;
	private String memberId;
	private String datetime;
	private Integer sleep;
	private Integer medicine;

}
