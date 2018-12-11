package com.aman;

import org.springframework.stereotype.Controller;  
import org.springframework.web.bind.annotation.RequestMapping;  
import org.springframework.web.servlet.ModelAndView;  
  
@Controller  
public class HelloWorldController {  
  
    @RequestMapping("/hello")  
    public ModelAndView helloWorld() {  
  
        String message = "HELLO SPRING MVC";  
        ModelAndView mv = new ModelAndView();
        mv.setViewName("hellopage.jsp");
        mv.addObject("message", message);
        return mv;
    }     
} 
