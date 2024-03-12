package com.community.fo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.community.fo.jpa.entity.SampleEntity;
import com.community.fo.service.SampleJpaService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Controller
@RequiredArgsConstructor
@Log4j2
public class SampleJpaController {

	private final SampleJpaService sampleJpaService;

	
	@GetMapping("/showAllJpa")
	public String SampleEntitylist(Model model) {

		model.addAttribute("visitor", sampleJpaService.SampleEntitylist());
		// html파일 만들어야함 //레이아웃을 부르는게 아니라 페이지를 부르는것 pages = views (jsp)
		return "pages/fo/jpa/sampleJpa";
	}

	@GetMapping("/visitorDetail/{visitorSq}")
	public String detail(@PathVariable int visitorSq, Model model) {

		model.addAttribute("visitor", sampleJpaService.Detail(visitorSq));

		return "pages/fo/jpa/detailJpa";

	}

	@GetMapping("/visitorInsert")
	public String insertGet() {

		return "pages/fo/jpa/visitorInsertForm";
	}

	@PostMapping("/visitorInsert")
	public String insertPost(SampleEntity sampleJpaEntity) {

		sampleJpaService.SampleEntityInsert(sampleJpaEntity);
		return "redirect:showAllJpa";
	}

	@GetMapping("/visitorUpdate/{visitorSq}")
	public String updateGet(@PathVariable int visitorSq, Model model) {

		model.addAttribute("visitor", sampleJpaService.Detail(visitorSq));
		return "pages/fo/jpa/visitorUpdateForm";

	}

	@PostMapping("/visitorUpdate")
	public String updatePost(SampleEntity sampleJpaEntity) {


		
		sampleJpaService.Update(sampleJpaEntity);
		return "redirect:showAllJpa";
	}

	@GetMapping("/deleteJpa/{visitorSq}")
	public String delete(@PathVariable int visitorSq) {

		sampleJpaService.delete(visitorSq);

		return "redirect:/showAllJpa";
	}

}
