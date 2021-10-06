package com.nagarro.Frontend.service;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Service;

@Service
public class OperationService {

	public String getAllEmployees() {
		String query_url = "http://localhost:8082/employeedetails/employee";
		try {
		URL url = new URL(query_url);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Content-Type", "application/json; utf-8");
		conn.setRequestProperty("Accept", "application/json");
		conn.setDoOutput(true);
		conn.setDoInput(true);
		 InputStream in = new BufferedInputStream(conn.getInputStream());
         String result = IOUtils.toString(in, "UTF-8");
         System.out.println("output - "+result);
         return result;
		} catch (Exception e) {
			System.out.println("Error");
		}
		return "";
	}
	
	public String getSingleEmployee(Long employeeCode) {
		String query_url = "http://localhost:8082/employeedetails/employee/" + employeeCode;
		try {
		URL url = new URL(query_url);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Content-Type", "application/json; utf-8");
		conn.setRequestProperty("Accept", "application/json");
		conn.setDoOutput(true);
		conn.setDoInput(true);
		 InputStream in = new BufferedInputStream(conn.getInputStream());
         String result = IOUtils.toString(in, "UTF-8");
         return result;
		} catch (Exception e) {
			System.out.println("Error");
		}
		return "";
	}
	
	
	public String setAllEmployees(String employeeCode, String employeeName, String location, String email, String dateOfBirth) {
		 String query_url = "http://localhost:8082/employeedetails/employee";
         String json = "{" + "\"employeeCode\":\"" + employeeCode + "\",\"employeeName\":\"" + employeeName + 
					"\",\"location\":\""+ location + "\",\"email\":\""+email+"\",\"dateOfBirth\":\""+dateOfBirth+"\"" + "}";
         try {
         URL url = new URL(query_url);
         HttpURLConnection conn = (HttpURLConnection) url.openConnection();
         conn.setRequestMethod("POST");
         conn.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
         conn.setRequestProperty("Accept", "application/json");
         conn.setDoOutput(true);
         conn.setDoInput(true);
         OutputStream os = conn.getOutputStream();
         os.write(json.getBytes("UTF-8"));
         os.close(); 
         InputStream in = new BufferedInputStream(conn.getInputStream());
         String result = IOUtils.toString(in, "UTF-8");
         return result;
         } catch (Exception e) {
 			System.out.println(e);
 		}
         return "";
	}
	
	public void editUser(String employeeCode, String employeeName, String location, String email, String dateOfBirth) {
		String query_url = "http://localhost:8082/employeedetails/employee/" + employeeCode;
        String json = "{" + "\"employeeCode\":\"" + employeeCode + "\",\"employeeName\":\"" + employeeName + 
					"\",\"location\":\""+ location + "\",\"email\":\""+email+"\",\"dateOfBirth\":\""+dateOfBirth+"\"" + "}";
        
        try {
            URL url = new URL(query_url);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("PUT");
            conn.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
            conn.setRequestProperty("Accept", "application/json");
            conn.setDoOutput(true);
            conn.setDoInput(true);
            OutputStream os = conn.getOutputStream();
            os.write(json.getBytes("UTF-8"));
            os.close(); 
            InputStream in = new BufferedInputStream(conn.getInputStream());
            String result = IOUtils.toString(in, "UTF-8");
            System.out.print("edit - "+ result);
            } catch (Exception e) {
    			System.out.println(e);
    		}
	}
	
	
	}


