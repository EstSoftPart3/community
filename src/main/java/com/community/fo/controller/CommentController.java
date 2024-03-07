package com.community.fo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.community.fo.service.CommentServiceImpl;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class CommentController {
	@Autowired
	private final CommentServiceImpl csii;
	
	@PostMapping("/deleteComment/{commentSq}")
	@ResponseBody
	public void deleteComment(@RequestParam("commentSq") int commentSq) {
		
		csii.CommentDelete(commentSq);

	
	}
}
