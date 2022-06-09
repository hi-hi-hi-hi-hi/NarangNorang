package com.narangnorang.dto;

import org.apache.ibatis.type.Alias;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Alias("PostDTO")
public class PostDTO {

	private int id;
	private String category;
	private String title;
	private String content;
	private String datetime;
	private int replies;
	private int likes;
	private int views;
	// Member
	private String memberName;
	private int memberId;
	private int memberPrivilege;

}
