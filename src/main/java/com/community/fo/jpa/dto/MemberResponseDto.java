package com.community.fo.jpa.dto;

import com.community.fo.jpa.entity.MemberEntity;

import groovy.transform.builder.Builder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor

public class MemberResponseDto {
	
	//변경가능한 데이터만 담는 member객체 
	//update시 사용 setter사용가능한 
	
	private Integer mbrSq;
	private String id;
	private String nicknm;
	private String pw;
	private String pwEncryp;
	private String name;
	private String email;
	private String address;
	private String phone;
	
	
	public MemberResponseDto(MemberEntity memberEntity){
		   
		  this.mbrSq = memberEntity.getMbrSq();
	      this.id=memberEntity.getId();
	      this.nicknm=memberEntity.getNicknm();
	      this.pw=memberEntity.getPw();
	      this.pwEncryp=memberEntity.getPw();
	      this.name=memberEntity.getName();
	      this.email=memberEntity.getEmail();
	      this.address=memberEntity.getAddress();
	      this.phone=memberEntity.getPhone();
	     
	  }
	
	

	
}
