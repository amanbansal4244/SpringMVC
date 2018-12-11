package com.aman;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

	@RequestMapping("/login")
	public ModelAndView checkUser(@RequestParam("uname") String uname, @RequestParam("pass") String pass /* HttpServletRequest req, HttpServletResponse res*/) throws ClassNotFoundException, SQLException{
		
		//String uname = req.getParameter("uname");
		//String pass = req.getParameter("pass");
		ModelAndView mv = new ModelAndView();
		if(new LogInService().checkCredentials(uname, pass)){
			mv.setViewName("success.jsp");
		}
		else{
			mv.setViewName("index.jsp");
		}
		return mv;
	}
	
	/*@RequestMapping("/login")
	public ModelAndView checkUser(HttpServletRequest req, HttpServletResponse res) throws ClassNotFoundException, SQLException{
		
		String uname = req.getParameter("uname");
		String pass = req.getParameter("pass");
		ModelAndView mv = new ModelAndView();
		if(new LogInService().checkCredentials(uname, pass)){
			mv.setViewName("success.jsp");
		}
		else{
			mv.setViewName("index.jsp");
		}
		return mv;
	}*/
}
