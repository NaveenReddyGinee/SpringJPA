package com.accenture.lkm.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.accenture.lkm.bussiness.bean.Employee;

@Repository
public class EmployeeDAO {

	static List<Employee> listEmployee = new ArrayList<Employee>();
	static {
		listEmployee.add(new Employee("Jack", 10001, 12345.6, 1001));
		listEmployee.add(new Employee("Justin", 10002, 12345.6, 1002));
		listEmployee.add(new Employee("Eric", 10002, 12345.6, 1003));
	}

	public List<Employee> getAllEmployees() {

		return listEmployee;
	}
}
