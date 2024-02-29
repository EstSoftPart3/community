package com.community.fo.service;

import java.util.List;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.community.fo.jpa.entity.BoardJpaEntity;
import com.community.fo.jpa.repository.BoardJpaRepository;
import com.community.fo.mybatis.mapper.BoardMapper;
import com.community.fo.mybatis.vo.BoardVo;

import lombok.RequiredArgsConstructor;

@MapperScan("com.community.fo.mybatis.mapper")
@Service
@RequiredArgsConstructor
public class BoardServiceImpl {

	@Autowired 
	private final BoardMapper boardMapper;
	@Autowired 
	private final BoardJpaRepository boardJpaRepository;
	//JPA ServiceImpl Start
	public List<BoardJpaEntity> BoardList(){
		
		return boardJpaRepository.findAll(Sort.by(Sort.Direction.DESC, "boardSq"));
	}
	
	public BoardJpaEntity BoardDetail(int boardSq) {
		
		return boardJpaRepository.findById(boardSq).orElse(null);
	}
	
	public void BoardInsert(BoardJpaEntity boardJpaEntity) {
		
		boardJpaRepository.save(boardJpaEntity);
		
	}
	
	public void BoardUpdate(BoardJpaEntity boardJpaEntity) {
		
		boardJpaRepository.save(boardJpaEntity);
	}
	
	public void BoardDelete(int boardSq) {
		boardJpaRepository.deleteById(boardSq);
		
	}
	
	
//	Mybatis ServiceImpl Start
	
}
