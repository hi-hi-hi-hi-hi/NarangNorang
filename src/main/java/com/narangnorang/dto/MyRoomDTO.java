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
	//member 고유번호
	private int memberId;
	private int floor;
	private int wallpaper;
	private int bed;
	private int closet;
	private int desk;
	private int walldecoRight;
	private int walldecoLeft;
	private int chair;
	private String memberName;

}
