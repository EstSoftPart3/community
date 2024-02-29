package com.community.fo.jpa.dto;

import groovy.transform.builder.Builder;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class MemberUpdateDto {
	private String id;
	private String nicknm;
	private String pw;
	private String pwEncryp;
	private String name;
	private String email;
	private String address;
	private String phone;


}
