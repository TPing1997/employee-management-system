package com.employee.management.service;

import java.util.ArrayList;
import java.util.List;

import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.employee.management.model.Employee;
import org.springframework.util.CollectionUtils;

// employee service class
@Service
public class EmployeeService {
	List<Employee> employees = new ArrayList<Employee>();
	@Autowired
	public EmployeeService(){
		if(CollectionUtils.isEmpty(employees)) {
			employees.add(new Employee("Greyson", "Software Engineer"));
			employees.add(new Employee("Felicia", "QA Engineer"));
			employees.add(new Employee("Frey", "UI Developer"));
		}
	}

	// fetching all employees
	public List<Employee> getAllEmployees(){
		return employees;
	}
	// fetching employee by name
	public Employee getEmployee(String name){
		Employee employee = new Employee();
		for(var emp: employees) {
			if(emp.getName().equals(name)) {
				employee = emp;
			}
		}
		return employee;
	}
	
	// inserting employee
	public void addEmployee(Employee e) {
		employees.add(e);
	}
	
	// updating employee by name
	public void updateEmployeeJob(String name, String job){
		for(var emp: employees) {
			if(name.equals(emp.getName())) {
				employees.remove(emp);
				employees.add(new Employee(name, job));
			}
		}
	}
	
	// deleting all employees
	public void deleteAllEmployees(){
		employees = new ArrayList<Employee>();
	}
	
	// deleting employee by name
	public void deleteEmployeeByName(String name){
		for(var emp: employees) {
			if(name.equals(emp.getName())) {
				employees.remove(emp);
			}
		}
	}
}
