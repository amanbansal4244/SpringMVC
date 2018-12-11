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
	   
		@InitBinder
		public void initBinderMethod(WebDataBinder binder){
			//binder.setDisallowedFields(new String[]{"id","dateDob"});
			/*SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy***mm***dd");
			binder.registerCustomEditor(Date.class, "dateDob", new CustomDateEditor(dateFormat, false));*/
			//binder.registerCustomEditor(String.class, "name", new EmployeeNameEditor());
		}
		
	    @RequestMapping(value="/saveAction", method=RequestMethod.POST)  
	    public ModelAndView save(@Valid @ModelAttribute("empObj") Emp emp, BindingResult result){  
	    	
	    	if(result.hasErrors()){
	    		ModelAndView mv = new ModelAndView();
		    	mv.setViewName("index1");
		        return mv;
	    	}
	    	ModelAndView mv = new ModelAndView();
	    	mv.setViewName("viewemp");
	        return mv;
	    } 
	    
	    
	
   /* @RequestMapping(value="/saveAction")  
    public ModelAndView save(@RequestParam("id") int id, @RequestParam("name") String name){  
    	Emp emp = new Emp();
    	emp.setId(id);
    	emp.setName(name);
    
    	ModelAndView mv = new ModelAndView();
    	mv.setViewName("viewemp");
    	//mv.addObject("headerMessgae", "Welcome");
    	mv.addObject("empObj",emp);
    	return mv;
    } */
     
}