package com.narangnorang.dto;

import org.apache.ibatis.type.Alias;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Alias("MessageDTO")
public class MessageDTO {

	private int id;
	private String sender; // id
	private String reciever; // id
	private String content;
	private String datetime;
	// Member
	private String senderNickname;
	private String senderName;
	private String recieverNickname;
	private String recieverName;

}
