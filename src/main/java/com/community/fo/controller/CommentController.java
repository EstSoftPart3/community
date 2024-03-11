package com.community.fo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.community.fo.jpa.entity.CommentEntity;
import com.community.fo.service.CommentServiceImpl;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping
public class CommentController {
	@Autowired
	private final CommentServiceImpl csi;
	
	@GetMapping("/comments")
	public List<CommentEntity> comments () {
		
		 List<CommentEntity> comments = csi.commentList();
		return comments;
	}
	
	
	@DeleteMapping("/{commentSq}")
	public void deleteComment(@RequestParam("commentSq") int commentSq) {
		
		csi.CommentDelete(commentSq);

	
	}
	
	@PostMapping("/comments")
	public void insertComment(@RequestBody CommentEntity commentEntity) {
		
		
		csi.CommentInsert(commentEntity);
	
	
	}
}
