package com.community.fo.jpa.entity;

import java.sql.Date;

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
@Table(name = "TBL_BOARD_M")
@Entity
public class BoardJpaEntity {

	@Id
	@GeneratedValue(generator = "sequence")
	@SequenceGenerator(name = "sequence", sequenceName = "SEQ_FILE_LI", allocationSize = 1)
	@Column(name = "BOARD_SQ")
	private int boardSq;
	
	@Column(name = "MBR_ID")
	private String mbrId;
	
	@Column(name = "TITLE")
	private String title;
	
	@Column(name = "DEL_CD")
	private String delCd;

	@Column(name = "CONTENTS")
	private String contents;
	
	@Column(name = "RECMMND_CNT")
	private int recmmndCnt;
	
	@Column(name = "VIEW_CNT")
	private int viewCnt;
	
	@Column(name = "KEYWORD1")
	private String keyword1;
	
	@Column(name = "KEYWORD2")
	private String keyword2;

	@Column(name = "KEYWORD3")
	private String keyword3;

	@Column(name = "KEYWORD4")
	private String keyword4;
	
	@Column(name = "KEYWORD5")
	private String keyword5;
	
	@Column(name = "SELECTION_YN")
	private String selectionYn;
	
	@Column(name = "SELECTION_DIV_CD")
	private String selecttionDivCd;
	
	@Column(name = "NOTICE_DIV_CD")
	private String noticeDivCd;
	
	@Column(name = "USE_YN")
	private String useYn;
	
	@Column(name = "DEL_YN")
	private String delYn;
	
	@Column(name = "REGIST_MBR_SQ")
	private int registMbrSq;
	
	
	@Column(name = "REGIST_DATETIME")
	private Date registDatetime;
	
	
	@Column(name = "MODIFY_MBR_SQ")
	private int modifyMbrSq;
	
	@Column(name = "MODIFY_DATETIME")
	private Date modifyDateTime;
	
	
}
