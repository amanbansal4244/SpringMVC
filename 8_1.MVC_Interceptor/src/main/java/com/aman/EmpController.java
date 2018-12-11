package com.aman;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;  
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;  
import org.springframework.web.bind.annotation.PathVariable;  
import org.springframework.web.bind.annotation.RequestMapping;  
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;  
import com.aman.Emp;  


	@Controller  
	public class EmpController {  
			    
	
    @RequestMapping(value="/saveAction")  
    public ModelAndView save(@RequestParam("id") int id, @RequestParam("name") String name){  
    	Emp emp = new Emp();
    	emp.setId(id);
    	emp.setName(name);
    
    	ModelAndView mv = new ModelAndView();
    	mv.setViewName("viewemp");
    	//mv.addObject("headerMessgae", "Welcome");
    	mv.addObject("empObj",emp);
    	return mv;
    } 
     
}