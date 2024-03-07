package com.community.fo.jpa.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import com.community.fo.jpa.Role;

import groovy.transform.builder.Builder;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@DynamicUpdate 
@DynamicInsert
@Table(name = "TBL_MBR_M")
@Entity
public class MemberEntity {
	

	@Id
	@GeneratedValue(generator = "sequence")
	@SequenceGenerator(name = "sequence", sequenceName = "MBR_SQ", allocationSize = 1)
	@Column(name="MBR_SQ")
	private Integer mbrSq;
	
	@Column(name="ID")
	private String id;
	
	@Column(name="NICKNM")
	private String nicknm;
	
	@Column(name="PW")
	private String pw;
	
	@Column(name="PW_ENCRYP")
	private String pwEncryp;
	
	@Column(name="NAME")
	private String name;
	
	@Column(name="DIV_CD")
	private String divCd;
	
	@Column(name="EMAIL")
	private String email;
	
	@Column(name="ADDRESS")
	private String address;
	
	@Column(name="PHONE")
	private String phone;
	
	@ColumnDefault("N")
	@Column(name="SMS_CERTIFI_YN")
	private String smsCertifiYn;
	
	
	@Column(name="SMS_CERTIFI_DATETIME")
	private String smsCertifiDatetime;
	
	@Column(name="PROFILE_IMAGE_URL")
	private String profileImageUrl;
	
	@ColumnDefault("N")
	@Column(name="SECESS_YN")
	private String secessYn;
	
	@ColumnDefault("N")
	@Column(name="SOCIAL_LINK_YN")
	private String socialLinkYn;
	
	@Column(name="SOCIAL_JOIN_DIV_CD")
	private String socialJoinDivCd;
	
	@ColumnDefault("Y")
	@Column(name="USE_YN")
	private String useYn;
	
	@ColumnDefault("N")
	@Column(name="DEL_YN")
	private String delYn;
	
	@Column(name="REGIST_MBR_SQ")
	private String registMbrSq;
	
	@CreationTimestamp
	@Column(name="REGIST_DATETIME")
	private LocalDateTime registDatetime  = LocalDateTime.now();;
	
	@Column(name="MODIFY_MBR_SQ")
	private String modifyMbrSq;
	
	@Column(name="MODIFY_DATETIME")
	private String modifyDatetime;	 
	
	@Column(name="POST_CODE")
	private String postCode;	 
	
	@Column(name="ADDRESS_DETAIL")
	private String addressDetail;	
	
	@Enumerated(EnumType.STRING)
	private Role role;	
	
	
	@Builder
	public MemberEntity(String id, String name,String nicknm,String phone,String pw, String pwEncryp, String address, String addressDetail, String postCode, String adressDetail) {
		
		this.id = id;
		this.name = name;
		this.nicknm = nicknm;
		this.phone = phone;
		this.pw = pw;
		this.pwEncryp = pwEncryp;
		this.address = address;
		this.addressDetail = addressDetail;		
		this.postCode = postCode;
		
	}
	

	@Builder
	public  MemberEntity(String id, String name, String pw) {
		this.id = id;
		this.name = name;
		this.pw = pw;
		
	}




	

	

	
	
}
