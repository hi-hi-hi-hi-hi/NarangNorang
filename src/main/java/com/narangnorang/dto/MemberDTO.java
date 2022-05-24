package com.narangnorang.dto;

import org.apache.ibatis.type.Alias;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Alias("MemberDTO")
public class MemberDTO {
	
	// 공통
	private int id;
	private String email;
	private String password;
	private int privilege;
	private String name;
	private String phone;
	private String datetime;

	// 일반
	private String region;
	private Integer point;

	// 상담사
	private String zipcode;
	private String address1;
	private String address2;
	private String address3;
	private String job;
	private String introduction;
	
}
