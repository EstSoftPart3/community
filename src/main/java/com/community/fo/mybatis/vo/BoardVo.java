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

	private int BOARD_SQ;
	
	private String MBR_ID;
	
	private String TITLE;
	
	private String DEL_CD;

	private String CONTENTS;
	
	private int RECMMND_CNT;
	
	private int VIEW_CNT;
	
	private String KEYWORD1;
	
	private String KEYWORD2;

	private String KEYWORD3;

	private String KEYWORD4;
	
	private String KEYWORD5;
	
	private String SELECTION_YN;

	private String SELECTION_DIV_CD;
	
	private String NOTICE_DIV_CD;
	
	private String USE_YN;

	private String DEL_YN;
	
	private int REGIST_MBR_SQ;
	
	private Date REGIST_DATETIME;
	
	private int MODIFY_MBR_SQ;
	
	private Date MODIFY_DATETIME;
	
	
}
