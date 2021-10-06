package com.nagarro.Frontend.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.nagarro.Frontend.service.OperationService;

@Controller
public class EditController {
	
	@Autowired
	private OperationService operation;
	
	@RequestMapping(value ="/editEmployee/{id}",method = RequestMethod.GET)
	public ModelAndView test(@PathVariable(value="id") Long id,HttpServletResponse response) throws IOException {

		ModelAndView mv = new ModelAndView();
		String data = this.operation.getSingleEmployee(id);
		System.out.println("id - "+ id);
		System.out.println("data - "+ data);
		mv.addObject("employee",data);
		mv.setViewName("editEmployee");
		return mv;
	}	
	
	@RequestMapping(value = "/editEmployee/editEmployeeDetails", method = RequestMethod.GET)
	public ModelAndView home(@RequestParam("employeeCode") String employeeCode,
							@RequestParam("employeeName") String employeeName,
							@RequestParam("location") String location,
							@RequestParam("email") String email,
							@RequestParam("dateOfBirth") String dateOfBirth,
							HttpServletResponse response) {
		
		this.operation.editUser(employeeCode,employeeName,location,email,dateOfBirth);
		String data =	this.operation.getAllEmployees();
		ModelAndView mv = new ModelAndView();
		mv.addObject("employee",data);
		mv.setViewName("redirect:/uploademployee");
		return mv;	
	}

}
