package com.accenture.lkm.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.lkm.business.bean.Employee;
import com.accenture.lkm.dao.EmployeeDAO;
import com.accenture.lkm.entity.EmployeeEntity;
@Service
public class EmployeeServiceImpl {

	@Autowired
	private EmployeeDAO employeeDAO;

	public int addEmployee(Employee employee) {

		EmployeeEntity employeeEntity = new EmployeeEntity();
		BeanUtils.copyProperties(employee, employeeEntity);
		EmployeeEntity emp= (EmployeeEntity)employeeDAO.save(employeeEntity);
		System.out.println(emp);
		return emp.getEmployeeId();
	}

	public Collection<Employee> getEmployeeDetails(){
		Collection<EmployeeEntity> collec =employeeDAO.findAll();
		List<Employee> listEmployee = new ArrayList<Employee> ();
		for (EmployeeEntity employeeEntity : collec) {
			Employee employee=new Employee();
			BeanUtils.copyProperties(employeeEntity, employee);
			listEmployee.add(employee);
		}
		return listEmployee;
	}
	
	public Employee getEmployeeDetailByEmployeeId(int employeeId){
		Employee employee =null;
		EmployeeEntity employeeEntity= employeeDAO.findOne(employeeId);
		if(employeeEntity!=null){
			employee= new Employee();
			BeanUtils.copyProperties(employeeEntity, employee);
		}
		return employee;
	}
	public Employee deleteEmployee(int employeeId){
		Employee employee =null;
		EmployeeEntity employeeEntity= employeeDAO.findOne(employeeId);
		if(employeeEntity!=null){
			employeeDAO.delete(employeeEntity);
			employee= new Employee();
			BeanUtils.copyProperties(employeeEntity, employee);
		}
		return employee;
	}
	
	public Employee updateEmployee(Employee employee){
		Employee employee2 =null;
		EmployeeEntity employeeEntity= employeeDAO.findOne(employee.getEmployeeId());
		if(employeeEntity!=null){
			//update operation
			BeanUtils.copyProperties(employee, employeeEntity);	
			employeeDAO.save(employeeEntity);
			
			//copying the properties back to Employee DTO Object 
			employee2= new Employee();
			BeanUtils.copyProperties(employeeEntity, employee2);
		}
		return employee2;
	}
	
	// Query Methods:
	public List<Employee> getAllEmployeeFromDepartmentGTSalary(Integer department,double salary){
		List<EmployeeEntity> listEmployee= employeeDAO.findByDepartmentCodeAndSalaryGreaterThanEqual(department, salary);
		List<Employee> listEmployeeDTO = new ArrayList<Employee>();
		
		for (EmployeeEntity employeeEntity : listEmployee) {
			 Employee employee2 = new Employee();
			 BeanUtils.copyProperties(employeeEntity, employee2);
			 listEmployeeDTO.add(employee2);
		}
		return listEmployeeDTO;
	}
	
	public List<Employee> getEmployeeDetailsOrderByDepartmentcodedesc(){
		List<EmployeeEntity> listEmployee= employeeDAO.findAllByOrderByDepartmentCodeDesc();
		List<Employee> listEmployeeDTO = new ArrayList<Employee>();
		
		for (EmployeeEntity employeeEntity : listEmployee) {
			 Employee employee2 = new Employee();
			 BeanUtils.copyProperties(employeeEntity, employee2);
			 listEmployeeDTO.add(employee2);
		}
		return listEmployeeDTO;
	}
	public List<Employee> findByEmployeeNameContainingOrderByDepartmentCodeDesc(String pattern){
		List<EmployeeEntity> listEmployee= employeeDAO.findByEmployeeNameContainingOrderByDepartmentCodeDesc(pattern);
		List<Employee> listEmployeeDTO = new ArrayList<Employee>();
		
		for (EmployeeEntity employeeEntity : listEmployee) {
			 Employee employee2 = new Employee();
			 BeanUtils.copyProperties(employeeEntity, employee2);
			 listEmployeeDTO.add(employee2);
		}
		return listEmployeeDTO;
	}
	
	public List<Employee> findByDepartmentCodeGreaterThanEqualAndLessThanEqual(Integer param1, Integer param2){
		List<EmployeeEntity> listEmployee= employeeDAO.findByDepartmentCodeGreaterThanEqualAndDepartmentCodeLessThanEqual(param1,param2);
		List<Employee> listEmployeeDTO = new ArrayList<Employee>();
		
		for (EmployeeEntity employeeEntity : listEmployee) {
			 Employee employee2 = new Employee();
			 BeanUtils.copyProperties(employeeEntity, employee2);
			 listEmployeeDTO.add(employee2);
		}
		return listEmployeeDTO;
	}
	public List<Employee> findByDepartmentBetween(Integer param1, Integer param2){
		List<EmployeeEntity> listEmployee= employeeDAO.findByDepartmentCodeBetween(param1, param2);
		List<Employee> listEmployeeDTO = new ArrayList<Employee>();
		
		for (EmployeeEntity employeeEntity : listEmployee) {
			 Employee employee2 = new Employee();
			 BeanUtils.copyProperties(employeeEntity, employee2);
			 listEmployeeDTO.add(employee2);
		}
		return listEmployeeDTO;
	}
	
	public List<Employee> getAllEmployeesBySalary(Double salary){
		List<EmployeeEntity> listEmployee= employeeDAO.getAllEmployeesBySalary(salary);
		List<Employee> listEmployeeDTO = new ArrayList<Employee>();
		
		for (EmployeeEntity employeeEntity : listEmployee) {
			 Employee employee2 = new Employee();
			 BeanUtils.copyProperties(employeeEntity, employee2);
			 listEmployeeDTO.add(employee2);
		}
		return listEmployeeDTO;
	}
	
	public List getDeptCodesAndCountOfEmployee(){
		List<EmployeeEntity> listEmployee= employeeDAO.getDeptCodesAndCountOfEmployee();
		
		return listEmployee;
	}
	
	
}
