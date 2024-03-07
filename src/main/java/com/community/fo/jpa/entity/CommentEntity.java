package com.community.fo.jpa.entity;

import java.sql.Date;

import org.hibernate.annotations.DynamicInsert;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name = "TBL_BOARD_COMMENT_S")
@Entity
@DynamicInsert
public class CommentEntity {

	@Id
	@GeneratedValue(generator = "sequence")
	@SequenceGenerator(name = "sequence", sequenceName = "SEQ_FILE_Comm", allocationSize = 1)
	@Column(name = "COMMENT_SQ")
	private int commentSq;
	
	@Column(name = "CONTENTS")
	private String contents;
	
	@Column(name = "SELECTION_YN")
	private String selectionYn;

	@Column(name = "MAJOR_KEYWORD")
	private String majorKeyword;
	
	@Column(name = "USE_YN")
	private String useYn;
	
	@Column(name = "NICKNAME")
	private String nickname;
	
	@Column(name = "DEL_YN")
	private String delYn;
	
	@Column(name = "REGIST_DATE")
	private Date registDate;
	
	
	@Column(name = "MODIFY_MBR_SQ")
	private int modifyMbrSq;
	
	@Column(name = "MODIFY_DATE")
	private Date modifyDate;
	
	@Column(name = "BOARD_SQ")
	private int boardSq;
	
	@Column(name = "MBR_SQ")
	private int mbrSq;

//	@ManyToOne
//	@JoinColumn(name = "BOARD_SQ")
//	private BoardEntity boardEntity;	
//	
//	@ManyToOne
//	@JoinColumn(name = "MBR_SQ")
//	private MemberEntity memberEntity;	

	
	
}
