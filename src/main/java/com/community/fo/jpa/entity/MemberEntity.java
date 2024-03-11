package com.community.fo.jpa.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import com.community.common.security.Role;

import groovy.transform.builder.Builder;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
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
	
	@ColumnDefault("1")
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
	
	
	@Column(name="SECESS_YN")
	private String secessYn;
	
	@ColumnDefault("N")
	@Column(name="SOCIAL_LINK_YN")
	private String socialLinkYn;
	
	@ColumnDefault("N")
	@Column(name="SOCIAL_JOIN_DIV_CD")
	private String socialJoinDivCd;
	
	@ColumnDefault("Y")
	@Column(name="USE_YN")
	private String useYn;
	
	@ColumnDefault("N")
	@Column(name="DEL_YN")
	private String delYn;
	
	@ColumnDefault("1")
	@Column(name="REGIST_MBR_SQ")
	private String registMbrSq;
	
	@CreationTimestamp
	@Column(name="REGIST_DATETIME")
	private LocalDateTime registDatetime  = LocalDateTime.now();;
	
	@Column(name="MODIFY_MBR_SQ")
	private String modifyMbrSq;
	
	@CreationTimestamp
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
	public  MemberEntity(String id, String name, String pwEncryp) {
		this.id = id;
		this.name = name;
		this.pw = pwEncryp;
		
	}
	
	
}
