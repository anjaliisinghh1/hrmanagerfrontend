package com.nagarro.Frontend.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.nagarro.Frontend.model.LoginModel;
import com.nagarro.Frontend.service.OperationService;

@Controller
public class HomeController {
	
	@Autowired
	private OperationService operation;
	
	@RequestMapping(value = "/")
	public ModelAndView login(LoginModel login) {
	    ModelAndView mv = new ModelAndView();
	    mv.setViewName("home");
	    return mv;
	}
	
	
	@RequestMapping("/login")
	public ModelAndView loginProcess(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		  String userName=request.getParameter("userName");  
	      String password=request.getParameter("password");
	      ModelAndView mv = new ModelAndView();
	      LoginModel login = new LoginModel();
	      login.setUserName(userName);
	      login.setPassword(password);
	      session.setAttribute("username",userName);
	      mv.addObject("name", userName);
		  mv.setViewName("employeeList");
		  return mv;
	}
	
	 @RequestMapping(value="/logout",method = RequestMethod.GET)
     public String logout(HttpServletRequest request){
         HttpSession httpSession = request.getSession();
         httpSession.invalidate();
         return "redirect:/";
     }
	


	@RequestMapping(value ="/uploadEmployeeDetails")
	public ModelAndView test(HttpServletResponse response) throws IOException {

		ModelAndView mv = new ModelAndView();
		mv.setViewName("uploadEmployeeDetails");
		return mv;
	}
	
	@RequestMapping(value = "/uploademployee", method = RequestMethod.GET)
	public ModelAndView home(HttpServletRequest request, HttpServletResponse response) {
		
		String employeeCode = request.getParameter("employeeCode");
		String employeeName = request.getParameter("employeeName");
		String location = request.getParameter("location");
		String email = request.getParameter("email");
		String dateOfBirth = request.getParameter("dateOfBirth");
		
		if((employeeName != null) && (location != null) && (email != null) && (dateOfBirth != null))
		{
			this.operation.setAllEmployees(employeeCode,employeeName,location,email,dateOfBirth);
		}
		String data =	this.operation.getAllEmployees();
		ModelAndView mv = new ModelAndView();
		mv.addObject("employee",data);
		//System.out.println("employee- " + data);
		mv.setViewName("employeeList");
		return mv;	
	}
}
