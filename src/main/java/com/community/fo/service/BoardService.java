package com.community.fo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.community.fo.mybatis.vo.BoardVo;

@Service

public interface BoardService {


	public List<BoardVo> BoardListAllSQL();

	
	
}
