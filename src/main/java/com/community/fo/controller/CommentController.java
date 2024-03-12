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
import org.springframework.web.bind.annotation.RestController;

import com.community.fo.jpa.entity.BoardEntity;
import com.community.fo.jpa.entity.CommentEntity;
import com.community.fo.service.CommentServiceImpl;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping
public class CommentController {
	@Autowired
	private final CommentServiceImpl csi;
	
	@GetMapping("/comments")
	@ResponseBody
	public List<CommentEntity> comments () {
		
		 List<CommentEntity> comments = csi.commentList();
		return comments;
	}
	
	
	@DeleteMapping("/{commentSq}")
	@ResponseBody
	public void deleteComment(@RequestParam("commentSq") int commentSq) {
		
		csi.CommentDelete(commentSq);

	
	}
	@GetMapping("/comment/{commentSq}")
	public String updateGetcomment(@PathVariable int commentSq , Model model) {
		CommentEntity comment = csi.commentDetail(commentSq);
		
		model.addAttribute("comment", comment);
		return "pages/fo/boardQnA/updateForm";
	}
	
	@PostMapping("/comment/{commentSq}")
	public String updateComment(CommentEntity commentEntity) {
		
		csi.CommentUptate(commentEntity);
		return "redirect:{commentSq}";
		
	}
	
	
	
	
	@PostMapping("/comments")
	@ResponseBody
	public void insertComment(@RequestBody CommentEntity commentEntity) {
		
		
		csi.CommentInsert(commentEntity);
	
	
	}
}
