package com.narangnorang.dto;

import org.apache.ibatis.type.Alias;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Alias("LikerDTO")
public class LikerDTO {

	private int id;
	private String memberId;
	private String postId;
	private String replyId;

}
