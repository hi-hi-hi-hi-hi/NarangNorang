package com.narangnorang.dto;

import org.apache.ibatis.type.Alias;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Alias("MoodStateDTO")
public class MoodStateDTO {

	private int id;
	private int memberId;
	private String datetime;
	private int state;

}
