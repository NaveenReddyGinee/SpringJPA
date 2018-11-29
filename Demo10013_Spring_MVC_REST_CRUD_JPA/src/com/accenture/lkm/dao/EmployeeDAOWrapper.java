package com.accenture.lkm.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.accenture.entity.EmployeeEntityBean;
import com.accenture.lkm.bussiness.bean.Employee;

@Repository
public class EmployeeDAOWrapper {
	
	@Autowired
	private EmployeeDAO dao;
	
	public List<Employee>findAll(){
		List<Employee> list = new ArrayList<Employee>(); 
		
		Iterable<EmployeeEntityBean> listEn= dao.findAll();
		listEn.forEach(x->{
			Employee employee = new Employee();
			BeanUtils.copyProperties(x, employee);
			list.add(employee);
		});
		return list;
	}
	
	
	public Employee findOne(Integer id){ 
		    EmployeeEntityBean x= dao.findOne(id);
		    Employee employee =null;
		    if(x!=null){
		    	employee = new Employee();		
				BeanUtils.copyProperties(x, employee);
		    }
		return employee;
	}
	
	public Integer saveEmployee(Employee employee){
		EmployeeEntityBean employeeEntityBean = new EmployeeEntityBean();
		BeanUtils.copyProperties(employee, employeeEntityBean);
		EmployeeEntityBean en=  dao.save(employeeEntityBean);
		return en.getId();	
	}
	
	public Employee updateEmployee(Employee employee){
		EmployeeEntityBean employeeEntityBean = new EmployeeEntityBean();
		BeanUtils.copyProperties(employee, employeeEntityBean);
		EmployeeEntityBean en=  dao.save(employeeEntityBean);
		
		Employee employee2 = new Employee();
		
		BeanUtils.copyProperties(en,employee2);
		return employee2;	
	}
	
	public void delete(int id){
		dao.delete(id);
	}
	

}
