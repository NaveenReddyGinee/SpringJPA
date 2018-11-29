package com.accenture.lkm.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.accenture.lkm.bussiness.bean.Employee;
import com.accenture.lkm.bussiness.bean.EmployeeListWrapper;
import com.accenture.lkm.dao.EmployeeDAO;

@Controller
public class EmployeeController {
	
	
	@Autowired
	private EmployeeDAO employeeDAO;
	
	@RequestMapping(value="emp/controller/json/getDetails",
			method=RequestMethod.GET,
			produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<List<Employee>> getEmployeeDetails(){
		
		return new ResponseEntity<List<Employee>>(employeeDAO.getAllEmployees(), HttpStatus.OK);
		
	}
	@RequestMapping(value="emp/controller/xml/getDetails",method=RequestMethod.GET,produces=MediaType.APPLICATION_XML_VALUE)
	@ResponseBody
	public ResponseEntity<EmployeeListWrapper> getEmployeeDetails2(){
		
		List <Employee> listEmployee =employeeDAO.getAllEmployees();
		// Wrapping the Data and then using the XML
	    // As java.util.List cannot be directly converted to xml
		EmployeeListWrapper employeeListWrapper = new   EmployeeListWrapper();
		employeeListWrapper.setListEmp(listEmployee);
		return new ResponseEntity<EmployeeListWrapper>(employeeListWrapper, HttpStatus.OK);
		
	}
	

}
