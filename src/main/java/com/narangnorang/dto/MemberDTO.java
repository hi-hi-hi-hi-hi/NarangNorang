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
	private String id; // 이메일
	private String password;
	private String phone;
	private int privileage;
	// 일반
	private String nickname;
	private String region;
	private String datetime;
	private Integer point;
	// 상담사
	private String name;
	private String zipcode;
	private String address1;
	private String address2;
	private String address3;
	private String job;
	private String introduction;

}
