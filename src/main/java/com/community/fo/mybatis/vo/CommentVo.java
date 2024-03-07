package com.community.fo.mybatis.vo;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CommentVo {


	private int commentSq;
	private int contents;
	private int selectionYn;
	private String useYn;
	private String delYn;
	private Date registDatetime;
	private int modifyMbrSq;
	private Date modifyDateTime;
	

//	조인해야댐
//	private int boardSq;	
//	private String mbrSq;
//	private String nickname;
//	
	
	
}
