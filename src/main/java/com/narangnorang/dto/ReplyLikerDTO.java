package com.narangnorang.dto;

import org.apache.ibatis.type.Alias;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Alias("ReplyLikerDTO")
public class ReplyLikerDTO {

	private int id;
	private int memberId;
	private int ReplyId;

}
