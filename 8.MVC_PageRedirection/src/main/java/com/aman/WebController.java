package com.aman;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WebController {

	@RequestMapping("/form")  
	public ModelAndView showform(){  
		return new ModelAndView("form");  
	}  

	
	@RequestMapping(value = "/redirect", method = RequestMethod.GET)
	public String redirect() {
		return "redirect:finalPage";
	}
	@RequestMapping(value = "/finalPage", method = RequestMethod.GET)
	public String finalPage() {
		return "final";
	}
}