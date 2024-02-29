package com.community.fo.mybatis.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MemberVo {
	

	private int mbrSq;
	private String id;
	private String nicknm;
	private String pw;
	private String pwEncryp;
	private String name;
	private String divCd;
	private String email;
	private String address;
	private String phone;
	private String smsCertifiYn;
	private String smsCertifiDatetime;
	private String profileImageUrl;
	private String secessYn;
	private String socialLinkYn;
	private String socialJoinDivCd;
	private String useYn;
	private String delYn;
	private String registMbrSq;
	private String registDatetime;
	private String modifyMbrSq;
	private String modifyDatetime;	        

}
