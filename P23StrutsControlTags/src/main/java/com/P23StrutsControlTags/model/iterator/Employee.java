package com.P23StrutsControlTags.model.iterator;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.util.SubsetIteratorFilter.Decider;

import com.opensymphony.xwork2.ActionSupport;

public class Employee extends ActionSupport{
	private String name,dept;
	private List<Employee> employees,contractors;

	public Employee() {}
	public Employee(String name, String dept) {
		this.name = name;
		this.dept = dept;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public List<Employee> getEmployees() {
		return employees;
	}
	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}
	public List<Employee> getContractors() {
		return contractors;
	}
	public void setContractors(List<Employee> contractors) {
		this.contractors = contractors;
	}
	
	public String execute() {
		employees = new ArrayList<Employee>();
		employees.add(new Employee("George","Recruitment"));
	    employees.add(new Employee("Danielle","Accounts"));
	    employees.add(new Employee("Melissa","Recruitment"));
	    employees.add(new Employee("Rose","Accounts"));
	    contractors = new ArrayList<Employee>();
		contractors.add(new Employee("Mindy","Database"));
	    contractors.add(new Employee("Vanessa","Network"));
		return SUCCESS;
	}
	
	public Decider getRecruitmentDecider() {
		return new Decider() {
			
			@Override
			public boolean decide(Object element) throws Exception {
				Employee employee = (Employee) element;
				return employee.getDept().equals("Recruitment");
			}
		};
	}

}
