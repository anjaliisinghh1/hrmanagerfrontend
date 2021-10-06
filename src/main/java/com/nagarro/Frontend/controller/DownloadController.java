package com.nagarro.Frontend.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;

import com.nagarro.Frontend.model.EmployeeModel;
import com.nagarro.Frontend.service.OperationService;

@Controller
public class DownloadController {
	
	@Autowired
	private OperationService operation;
	
	 @RequestMapping(value = "/downloadCSV")
	 public void downloadCSV(HttpServletResponse response) throws IOException {
		 
		 String data =	this.operation.getAllEmployees();
		 JSONArray jsonArr = new JSONArray(data);
		 List<EmployeeModel> dataList = new ArrayList<EmployeeModel>();
		 for (int i = 0; i < jsonArr.length(); i++) {
		        JSONObject jsonObj = jsonArr.getJSONObject(i);
		        EmployeeModel emp = new EmployeeModel();
		        emp.setEmployeeCode(jsonObj.getLong("employeeCode"));
		        emp.setEmployeeName(jsonObj.getString("employeeName"));
		        emp.setLocation(jsonObj.getString("location"));
		        emp.setEmail(jsonObj.getString("email"));
		        emp.setDateOfBirth(jsonObj.getString("dateOfBirth"));
		        dataList.add(emp);
		        }	 
		 
		 
	        String csvFileName = "employee.csv";
	        response.setContentType("text/csv");
	        String headerKey = "Content-Disposition";
	        String headerValue = String.format("attachment; filename=\"%s\"",
	                csvFileName);
	        response.setHeader(headerKey, headerValue);
	        ICsvBeanWriter csvWriter = new CsvBeanWriter(response.getWriter(),
	                CsvPreference.STANDARD_PREFERENCE);
	        String[] header = { "employeeCode", "employeeName", "location", "email",
	                "dateOfBirth"};
	        csvWriter.writeHeader(header);

	        for (EmployeeModel empl : dataList) {
	            csvWriter.write(empl, header);
	        }
	        csvWriter.close();
	    }

	 }

