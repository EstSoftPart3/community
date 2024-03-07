package com.community.fo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.community.fo.jpa.entity.BoardEntity;
import com.community.fo.jpa.entity.CommentEntity;
import com.community.fo.mybatis.vo.BoardVo;
import com.community.fo.service.BoardService;
import com.community.fo.service.BoardServiceImpl;
import com.community.fo.service.CommentServiceImpl;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;


@Controller
@RequestMapping("/board")
@RequiredArgsConstructor
@Log4j2
public class BoardController {

		
	@Autowired
	private final BoardService bs;
	private final BoardServiceImpl bsi;
	private final CommentServiceImpl csi;
//	JPA Controller Start
	@GetMapping
	public String BoardList(Model model) {
		
		List<BoardEntity> boards = bsi.BoardList();
		model.addAttribute("board", boards);
		
		return "pages/fo/BoardFoList";
	}
	@GetMapping("/QnA")
		public String BoardQnA(Model model) {
		
		List<BoardEntity> boards = bsi.BoardList();
		model.addAttribute("board", boards);
		
		return "pages/fo/BoardQnA";
	}
	
	@GetMapping("/{boradSq}")
	public String detailJpa(@PathVariable int boradSq, Model model) {
		
		BoardEntity boardDetail = bsi.BoardDetail(boradSq);
		 
		 model.addAttribute("board", boardDetail);
				 
		return "pages/fo/DetailBoardJpa";
		
	}
	
	@GetMapping("/QnA/{boradSq}")
	public String detailQnA(@PathVariable int boradSq,Model model) {
		
		BoardEntity boardDetail = bsi.BoardDetail(boradSq);
		List<CommentEntity> commentList = csi.commentList(); 
//		CommentEntity commentDetail = bsi.commentDetail(commentSq);
		
		 model.addAttribute("board", boardDetail);
		//바람직하지않다 
		// service 단에서 게시판의 형태(업무) 가 다르지않다면 한컨트롤러 service에서 분기 board 나눌지 합칠지 
		 
		 if(commentList != null && !commentList.isEmpty()) {
		 model.addAttribute("comment", commentList);		
		 }
		return "pages/fo/DetailQnA";
		
	}
	
	@GetMapping("/Insert")
	public String insertGetBoard() {
		
		return "pages/fo/BoardInsertFormJpa";
	}
	@GetMapping("/InsertQnA")
	public String insertGetQnA() {
		
		return "pages/fo/BoradQnAInsert";
	}
	
	@PostMapping("/InsertQnA")
	public String insertBoardPost(BoardEntity boardEntity) {
		
		bsi.BoardInsert(boardEntity);
		return "redirect:/board";
		
	}
	@PostMapping("/insertCommn")
	public String insertComment(CommentEntity commentEntity) {
		
		
		csi.CommentInsert(commentEntity);
	
		
	   return "redirect:/board/QnA/1";
	}
	
	@GetMapping("/Update/{boardSq}")
	public String updateGetBoard(@PathVariable int boardSq , Model model) {
		BoardEntity board = bsi.BoardDetail(boardSq);
		
		model.addAttribute("board", board);
		return "pages/fo/BoardUpdateFormJpa";
	}
	
	@PostMapping("/{boardSq}")
	public String updateBoardPost(BoardEntity boardEntity) {
		
		bsi.BoardUpdate(boardEntity);
		return "redirect:/board";
		
	}
	
	@PostMapping("/QnA/{boardSq}/delete")
	public String deleteBoard(@PathVariable int boardSq) {
		
		bsi.BoardDelete(boardSq);
		
		return "redirect:/board/QnA";
		
	}
	

	
	
// Mybatis Controller Start	
	@GetMapping("/SQL")
	public String BoardListSQL(Model model) {

		List<BoardVo> BoardList = bs.ListBoards();
		
		model.addAttribute("board", BoardList);
		return "pages/fo/BoardFoList"; 

	}
	@GetMapping("/SQL/{boardSq}")
	public String BoardDetailSQL(@PathVariable int boardSq,  Model model) {

		List<BoardVo> BoardList = bs.ListBoards();
		BoardVo boardDetail = bs.selectBoard(boardSq);
		
		model.addAttribute("board", BoardList);
		model.addAttribute("board", boardDetail);
		
		return "pages/fo/BoardFoList"; 

	}
	
//	   @GetMapping
//	   @ResponseBody
//	    public List<BoardEntity> getBoardList() {
//	        List<BoardEntity> list = bsi.BoardList();
//	        return list;
//	    }
//
//	    @GetMapping("/{boardSq}")
//	    @ResponseBody
//	    public BoardEntity getBoardDetail(@PathVariable int boardSq) {
//	        BoardEntity board = bsi.BoardDetail(boardSq);
//	        return board;
//	    }

//	    @PostMapping
//	    @ResponseBody
//	    public BoardEntity createBoard(@RequestBody BoardEntity boardEntity) {
//	        BoardEntity createdBoard = bsi.BoardInsert(boardEntity);
//	        return createdBoard;
//	    }
	//
//	    @PostMapping("/{boardSq}")
//	    @ResponseBody
//	    public BoardEntity updateBoard(@PathVariable int boardSq, @RequestBody BoardEntity boardEntity) {
//	        BoardEntity updatedBoard = bsi.BoardUpdate(boardEntity);
//	        return updatedBoard;
//	    }
	//
//	    @PostMapping("/{boardSq}")
//	    @ResponseBody
//	    public String deleteBoard(@PathVariable int boardSq) {
//	        bsi.BoardDelete(boardSq);
//	        return "Board deleted successfully";
//	    }
	}

