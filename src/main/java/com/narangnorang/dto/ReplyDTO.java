package com.narangnorang.dto;

import org.apache.ibatis.type.Alias;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Alias("ReplyDTO")
public class ReplyDTO {

	private int id;
	private String memberId;
	private String postId;
	private String content;
	private String datetime;
	private int likes;
	// Member
	private String memberNickname;
	private String memberName;

}
