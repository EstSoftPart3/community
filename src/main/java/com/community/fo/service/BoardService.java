package com.community.fo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.community.fo.mybatis.vo.BoardVo;

@Service
public interface BoardService {

    List<BoardVo> ListBoards();
    BoardVo selectBoard(int boardSq);
    int insertBoard(BoardVo board);
    int updateBoard(BoardVo board);
    int deleteBoard(int boardSq);
}
