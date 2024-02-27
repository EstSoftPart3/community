package com.community.fo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	   
	   @GetMapping("/page-full-width-layout-testpage")
	    public String testpage(Model model) {
	      
	      logger.info("testPage 화면 실행 {}");
	        model.addAttribute("model", model);
	        return "pages/test/page-full-width-layout-testpage";
	   }    
	    
	   @GetMapping("/rightSidebar-layout-testpage")
	    public String rightSidebarpage(Model model) {
	      
	      logger.info("testPage 화면 실행 {}");
	        model.addAttribute("model", model);
	        return "pages/test/page-right-sidebar-layout-testpage";
	   }
	   
	   @GetMapping("/leftSidebar-layout-testpage")
	    public String leftSidebarpage(Model model) {
	      
	      logger.info("testPage 화면 실행 {}");
	        model.addAttribute("model", model);
	        return "pages/test/page-left-sidebar-layout-testpage";
	   }
	   
	   @GetMapping("/stickySidebar-layout-testpage")
	    public String stickySidebarpage(Model model) {
	      
	      logger.info("testPage 화면 실행 {}");
	        model.addAttribute("model", model);
	        return "pages/test/page-sticky-sidebar-layout-testpage";
	   }
	   
	   @GetMapping("/left-right-layout-testpage")
	    public String leftRightSideBarPage(Model model) {
	      
	        logger.info("testPage 화면 실행 {}");
	        model.addAttribute("model", model);
	        return "pages/test/page-left-right-sidebar-layout-testpage";
	   }

}
