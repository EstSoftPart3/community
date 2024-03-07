package com.community.fo.mybatis.vo;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BoardVo {

	private int boardSq;
	
	private String mbrId;
	
	private String title;
	
	private String delCd;

	private String contents;
	
	private int recmmndCnt;
	
	private int viewCnt;
	
	private String keyword1;
	
	private String keyword2;

	private String keyword3;

	private String keyword4;
	
	private String keyword5;
	
	private String selectionYn;

	private String selecttionDivCd;
	
	private String noticeDivCd;
	
	private String useYn;

	private String delYn;
	
	private int registMbrSq;
	
	private Date registDatetime;
	
	private int modifyMbrSq;
	
	private Date modifyDateTime;
	
	
}
