package com.community.fo.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.community.fo.mybatis.vo.BoardVo;

@Mapper
public interface BoardMapper {

    List<BoardVo> ListBoards();
    BoardVo selectBoard(int boardSq);
    int insertBoard(BoardVo board);
    int updateBoard(BoardVo board);
    int deleteBoard(int boardSq);
	
	
}
