package com.narangnorang.dto;

import org.apache.ibatis.type.Alias;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Alias("MyItemDTO")
public class MyItemDTO {

	private int id;
	private int memberId;
	private int itemId;
	private int wish;

}
