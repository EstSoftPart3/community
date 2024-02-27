package com.community.fo.controller;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.community.fo.service.SampleJpaService;

import lombok.RequiredArgsConstructor;
  
 @Controller 
 @RequiredArgsConstructor
 public class SampleController {
	 
	 @Autowired
	 private final SampleJpaService sampleJpaService;
	 
	 @GetMapping("/page-full-width-layout")
	 public String hi(Model model) {
		 
		 model.addAttribute("list", sampleJpaService.SampleEntitylist());
		 
		 //레이아웃을 부르는게 아니라 페이지를 부르는것 pages = views (jsp)
		 return "pages/fo/samJpa";
	 }
	 
	 
	 
	 
  }
 