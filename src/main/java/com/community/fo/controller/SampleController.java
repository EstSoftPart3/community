package com.community.fo.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.community.fo.jpa.entity.SampleEntity;
import com.community.fo.mybatis.dto.SampleDTO;
import com.community.fo.mybatis.vo.SampleVo;
import com.community.fo.service.SampleService;
import com.community.fo.service.SampleSeviceImpl;

import lombok.RequiredArgsConstructor;


@RestController
@RequestMapping("/sample")
@RequiredArgsConstructor
public class SampleController {
	@Autowired
	private final SampleService sampleService;
	private final SampleSeviceImpl sampleSeviceImpl;
	
	
//	@GetMapping("/home")
//	public String home() {
//	
//	return "pages/fo/SampleFoPage";
//		
//	}
//	mybatis CRUD
	@PostMapping("/saveMybatis")
	public void saveSample(SampleDTO sampleDTO) {
		
		sampleService.insertSample(sampleDTO);
	}
	@GetMapping("/listMybatis")
	public List<SampleVo> listSample(){
		return sampleService.selectAllSamples();
	}
	
	@PostMapping("/updateMybatis/{id}")
	public void updateSample(SampleDTO sampleDTO) {
		sampleService.updateSample(sampleDTO);
	}
	
	@GetMapping("/deleteMybatis/{id}")
	public void deleteSample(SampleDTO sampleDTO) {
		sampleService.deleteSample(sampleDTO);
		
	}
	// mybatis CRUD end
	// jpa CRUD
	@PostMapping("/saveJpa")
	public void saveProc(@ModelAttribute SampleEntity sampleEntity) {
		sampleSeviceImpl.save(sampleEntity);

	}
	
	@GetMapping("/listJpa")
	public List<SampleEntity> list() {
		
		
		
		return sampleSeviceImpl.list();
	}
	

	
	@PostMapping("/updateJpa/{id}")
	public void updateProc(SampleEntity sampleEntity) {
		sampleSeviceImpl.update(sampleEntity);
		
		
	}
	
	@GetMapping("/deleteJpa/{id}")
	public void delete(@PathVariable Long id){
		
		sampleSeviceImpl.delete(id);
		
		
	}
	//JPA CRUD end
}
