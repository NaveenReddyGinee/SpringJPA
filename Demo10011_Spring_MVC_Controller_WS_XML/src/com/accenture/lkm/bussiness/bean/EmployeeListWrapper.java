package com.accenture.lkm.bussiness.bean;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class EmployeeListWrapper {
	private List<Employee> listEmp;

	@XmlElement(name="employee") // rename the child elements in the list
	public List<Employee> getListEmp() {
		return listEmp;
	}

	public void setListEmp(List<Employee> listEmp) {
		this.listEmp = listEmp;
	}
	

}
