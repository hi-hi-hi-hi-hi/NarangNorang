package com.narangnorang.dto;

import org.apache.ibatis.type.Alias;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Alias("MyRoomDTO")
public class MyRoomDTO {

	private int id;
	private String memberId;
	private int floor;
	private int wallpaper;
	private int bed;
	private int closet;
	private int desk;
	private int walldeco;
	// Member
	private String memberNickname;

}
