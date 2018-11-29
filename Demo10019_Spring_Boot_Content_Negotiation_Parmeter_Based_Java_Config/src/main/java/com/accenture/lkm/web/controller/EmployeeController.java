package com.accenture.lkm.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.accenture.lkm.business.bean.Employee;
import com.accenture.lkm.dao.EmployeeDAO;


@RestController
public class EmployeeController {
	@Autowired
	EmployeeDAO employeeDAO;

	
	
	@RequestMapping(value = "/employee/{id}", 
					produces = { "application/json", "application/xml" }, 
					method = RequestMethod.GET)
	public Employee getEmployeeById(@PathVariable("id") Integer id) {
		return employeeDAO.getEmployeeDetailsById(id);
	}
}
