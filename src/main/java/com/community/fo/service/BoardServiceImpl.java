package com.community.fo.service;

import java.util.List;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.community.fo.jpa.entity.BoardEntity;
import com.community.fo.jpa.repository.BoardRepository;
import com.community.fo.mybatis.mapper.BoardMapper;
import com.community.fo.mybatis.vo.BoardVo;

import lombok.RequiredArgsConstructor;

@MapperScan("com.community.fo.mybatis.mapper")
@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {

	@Autowired 
	private final BoardMapper bm;
	@Autowired 
	private final BoardRepository boardJpaRepository;
	//JPA ServiceImpl Start


	public List<BoardEntity> BoardList(){
		
	 List<BoardEntity> boardList  = boardJpaRepository.findAll(Sort.by(Sort.Direction.DESC, "boardSq"));
		
		return boardList;
	}

	public BoardEntity BoardDetail(int boardSq) {
		
		BoardEntity boardDetail = boardJpaRepository.findById(boardSq).orElse(null);
		
		return boardDetail;
	}

	
	public void BoardInsert(BoardEntity boardEntity) {
		
		boardJpaRepository.save(boardEntity);
		
	}

	
	
	public void BoardUpdate(BoardEntity boardEntity) {
		
		boardJpaRepository.save(boardEntity);
	}

	
	public void BoardDelete(int boardSq) {
		boardJpaRepository.deleteById(boardSq);
		
	}

	
//	Mybatis ServiceImpl Start
	@Override
	public List<BoardVo> ListBoards() {
		return bm.ListBoards();
	}

	@Override
	public BoardVo selectBoard(int boardSq) {
		
		return bm.selectBoard(boardSq);
	}

	@Override
	public int insertBoard(BoardVo board) {
		return bm.insertBoard(board);
		
	}

	@Override
	public int updateBoard(BoardVo board) {
		return bm.updateBoard(board);
		
	}

	@Override
	public int deleteBoard(int boardSq) {
		return bm.deleteBoard(boardSq);
		
	}
	
	

	
}
