package com.community.fo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.community.fo.jpa.entity.BoardJpaEntity;
import com.community.fo.service.BoardServiceImpl;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;


@Controller
@RequiredArgsConstructor
@Log4j2
public class BoardController {

	@Autowired
//	private final BoardService boardService;
	private final BoardServiceImpl boardServiceImpl;
//	JPA Controller Start
	@GetMapping("/showAllBoard")
	public String BoardList(Model model) {
		
		model.addAttribute("board", boardServiceImpl.BoardList());
		
		return "pages/fo/BoardFoList";
	}
	@GetMapping("/boardDetail/{boradSq}")
	public String detailJpa(@PathVariable int boradSq, Model model) {
		
		model.addAttribute("board", boardServiceImpl.BoardDetail(boradSq));
		return "pages/fo/DetailBoardJpa";
		
	}
	
	@GetMapping("/boardInsert")
	public String insertGetBoard() {
		
		return "pages/fo/BoardInsertFormJpa";
	}
	
	@PostMapping("/boardInsert")
	public String insertBoardPost(BoardJpaEntity boardJpaEntity) {
		
		boardServiceImpl.BoardInsert(boardJpaEntity);
		return "redirect:showAllBoard";
		
	}
	
	@GetMapping("/boardUpdate/{boardSq}")
	public String updateGetBoard(@PathVariable int boardSq , Model model) {
		
		
		model.addAttribute("board", boardServiceImpl.BoardDetail(boardSq));
		return "pages/fo/BoardUpdateFormJpa";
	}
	
	@PostMapping("/boardUpdate")
	public String updateBoardPost(BoardJpaEntity boardJpaEntity) {
		
		boardServiceImpl.BoardUpdate(boardJpaEntity);
		return "redirect:/showAllBoard";
		
	}
	
	@GetMapping("/deleteBoard/{boardSq}")
	public String deleteBoard(@PathVariable int boardSq) {
		
		boardServiceImpl.BoardDelete(boardSq);
		
		return "redirect:/showAllBoard";
		
	}
	
	
	
	
	
	
	
	
	
// Mybatis Controller Start	
//	@GetMapping("/ShowAllBoardSQL")
//	public String BoardListSQL(Model model) {
//
//		List<BoardVo> BoardList = boardService.BoardListAllSQL();
//		
//		model.addAttribute("board", BoardList);
//		return "page/fo/BoardFoList"; 
//
//	}
	
}
