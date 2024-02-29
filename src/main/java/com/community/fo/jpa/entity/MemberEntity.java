package com.community.fo.jpa.entity;

import org.hibernate.annotations.DynamicUpdate;

import com.community.fo.jpa.dto.MemberResponseDto;

import groovy.transform.builder.Builder;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor( access = AccessLevel.PROTECTED)
@Builder
@DynamicUpdate 
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
	
	@Column(name="SMS_CERTIFI_YN")
	private String smsCertifiYn;
	
	@Column(name="SMS_CERTIFI_DATETIME")
	private String smsCertifiDatetime;
	
	@Column(name="PROFILE_IMAGE_URL")
	private String profileImageUrl;
	
	@Column(name="SECESS_YN")
	private String secessYn;
	
	@Column(name="SOCIAL_LINK_YN")
	private String socialLinkYn;
	
	@Column(name="SOCIAL_JOIN_DIV_CD")
	private String socialJoinDivCd;
	
	@Column(name="USE_YN")
	private String useYn;
	
	@Column(name="DEL_YN")
	private String delYn;
	
	@Column(name="REGIST_MBR_SQ")
	private String registMbrSq;
	
	@Column(name="REGIST_DATETIME")
	private String registDatetime;
	
	@Column(name="MODIFY_MBR_SQ")
	private String modifyMbrSq;
	
	@Column(name="MODIFY_DATETIME")
	private String modifyDatetime;	 
	
	
    public void update(String id, String pw, String email , String nicknm, String name, String phone, String address ) {
        this.id = id;
        this.pw = pw;
        this.email = email;
        this.nicknm = nicknm;
        this.name = name;
        this.phone = phone;
        this.address = address;
        
    }
	
	
}
