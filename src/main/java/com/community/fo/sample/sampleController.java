package com.community.fo.sample;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class sampleController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@GetMapping("/page-full-width-layout-testpage")
    public String testpage(Model model) {
		
		logger.info("testPage 화면 실행 {}");
        model.addAttribute("model", model);
        return "pages/test/page-full-width-layout-testpage";
    }
}
