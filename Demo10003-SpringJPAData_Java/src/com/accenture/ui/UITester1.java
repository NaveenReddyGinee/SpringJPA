package com.accenture.ui;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.accenture.dao.EmployeeDAO;
import com.accenture.entity.EmployeeEntityBean;
import com.accenture.resource.JavaConfig;

public class UITester1 {

	public static void main(String[] args) {

		EmployeeDAO employeeDAOIMPL = null;
		ApplicationContext applicationContext = null;
		try {

			applicationContext = new AnnotationConfigApplicationContext(JavaConfig.class);
			employeeDAOIMPL = (EmployeeDAO) applicationContext.getBean("employeeDAO");

			// 1 Add Employee
			// addEmployee(employeeDAOIMPL);

			// 2 Get Employee Employee
			// getEmployeeDetails(employeeDAOIMPL);

			// 3 Update Employee
			// updateEmployeeDetails(employeeDAOIMPL);

			// 4 Delete Employee
			// deleteEmployee(employeeDAOIMPL);

			// 5 Select All Employees
			List<EmployeeEntityBean> employees = getAll(employeeDAOIMPL);
			for (EmployeeEntityBean bean : employees) {
				System.out.println(bean);
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			((AnnotationConfigApplicationContext) applicationContext).close();
		}
	}

	public static void addEmployee(EmployeeDAO daoimpl) {

		EmployeeEntityBean bean = new EmployeeEntityBean();
		bean.setInsertTime(new Date());
		bean.setName("New Employee");
		bean.setRole("Sr.Analyst");
		bean.setSalary(10.0);

		try {
			int id = daoimpl.save(bean).getId();
			System.out.println("Employee Registered Successfully: " + id);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}

	}

	public static void getEmployeeDetails(EmployeeDAO daoimpl) {

		try {

			EmployeeEntityBean employeeEntityBean = daoimpl.findOne(1002);

			if (employeeEntityBean == null) {
				System.out.println("Invalid Employee Id");
			} else {
				System.out.println("Employee Details");
				System.out.println("================");
				System.out.println("Name: " + employeeEntityBean.getName());
				System.out.println("Salary: " + employeeEntityBean.getSalary());
				System.out.println("Role: " + employeeEntityBean.getRole());
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}

	}

	public static void updateEmployeeDetails(EmployeeDAO daoimpl) {

		try {

			EmployeeEntityBean foundEmployeeEntityBean = daoimpl.findOne(1002);

			if (foundEmployeeEntityBean == null) {
				System.out.println("Invalid Employee Id");
			} else {
				foundEmployeeEntityBean.setSalary(1235.4);
				daoimpl.save(foundEmployeeEntityBean); // save the updates back
				System.out.println("Updated Employee Details");
				System.out.println("========================");
				System.out.println("Name: " + foundEmployeeEntityBean.getName());
				System.out.println("Salary: " + foundEmployeeEntityBean.getSalary());
				System.out.println("Role: " + foundEmployeeEntityBean.getRole());
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}

	}

	public static void deleteEmployee(EmployeeDAO daoimpl) {

		try {

			EmployeeEntityBean employeeEntityBean = daoimpl.findOne(1001);

			if (employeeEntityBean == null) {
				System.out.println("Invalid Employee Id");
			} else {
				daoimpl.delete(employeeEntityBean);

				System.out.println("Employee Deleted successfully sith employeeId: " + employeeEntityBean.getId());
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}

	public static List<EmployeeEntityBean> getAll(EmployeeDAO daoimpl) {
		List<EmployeeEntityBean> employees = new ArrayList<>();
		daoimpl.findAll().forEach(e -> employees.add(e));
		return employees;
	}
}