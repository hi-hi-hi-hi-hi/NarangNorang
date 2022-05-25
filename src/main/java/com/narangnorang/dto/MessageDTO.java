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
	private int senderId; // id
	private int recieverId; // id
	private String content;
	private String datetime;
	// Member
	private String senderName;
	private int senderPrivilege;
	private String recieverName;
	private int recieverPrivilege;

}
