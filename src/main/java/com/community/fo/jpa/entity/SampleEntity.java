package com.community.fo.jpa.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "tb_est_visitor")
@Entity
public class SampleEntity {
//@NoArgsConstructor(access = AccessLevel.PROTECTED) 무분별한 객체 생성 방지 
//@Table(name = "tb_est_visitor") 테이블 네임 매핑 
// pk 선언 변수선언시 구분자 _ 삭제 colum 명시 
	@Id
	@GeneratedValue(generator = "sequence")
	@SequenceGenerator(name = "sequence", sequenceName = "SEQ_FILE_L", allocationSize = 1)
	@Column(name = "visitor_sq")
	private int visitorSq;

	@Column(name = "visitor_nm")
	private String visitorNm;

	@Column(name = "visitor_in_dt")
	private String visitorInDt;

	@Column(name = "visitor_out_dt")
	private String visitorOutDt;

	@Column(name = "visitor_in_time")
	private String visitorInTime;

	@Column(name = "visitor_out_time")
	private String visitorOutTime;

	@Column(name = "visitor_resn")
	private String visitorResn;

	@Column(name = "visitor_tel")
	private String visitorTel;

	@Column(name = "wri_nm")
	private String wriNm;

	@Column(name = "wri_dt")
	private String wriDt;

	@Column(name = "search_option")
	private String searchOption;

}
