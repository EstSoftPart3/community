package com.community.fo.controller;
 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.community.fo.mybatis.vo.SampleVo;
import com.community.fo.service.SampleService;

@Controller
public class SampleMybatisController {

	@Autowired
	private SampleService sampleService;

	// 테스트 페이지
	@GetMapping("/test")
	public String test() {
		return "pages/fo/addEmpPage";
	}

	@GetMapping("/showAllEmp")
	public String getEmployeesList(Model model) {

		model.addAttribute("employees", sampleService.empListAll());
		return "pages/fo/SampleFoPage";
	}

	
    @GetMapping("/showEmp/{name}") 
    public String searchEmpListByName(Model model,@PathVariable String name){
  
    model.addAttribute("employees",sampleService.empSearchByName(name)); 
    return "pages/fo/SampleFoPage"; }
	 
	
	/*
	 * @GetMapping("/showEmp/{name}") public List<SampleVo>
	 * searchEmpListByName(@PathVariable String name) {
	 * 
	 * return sampleService.empSearchByName(name); }
	 */

	@GetMapping("/addPage")
	public String addPage(Integer id) {
		return "pages/fo/addEmpPage";
	}

	@PostMapping("/addFrom")
	public String addNewEmp(SampleVo sampleVo) {
		sampleService.empInsert(sampleVo);
		return "redirect:/showAllEmp"; 
	}
	

	
	  // 글삭제
	  @GetMapping("/delete") 
	    public String empDelete(String st_num) {
	        sampleService.empDelete(st_num); 
	        return "redirect:/showAllEmp"; 
	     }
	 
	
	// 글 상세 
	@GetMapping("/view") 
    public String viewDetail(Model model, Integer id){
		
        model.addAttribute("empList",sampleService.viewDetail(id));
        return "pages/fo/detail";
    }
	

	
   @PostMapping("/update")
    public String update(SampleVo sampleVo,Model model){
	 
	   model.addAttribute("empList", sampleService.empUpdate(sampleVo));
	  return "redirect:/showAllEmp"; 
    }

}
 