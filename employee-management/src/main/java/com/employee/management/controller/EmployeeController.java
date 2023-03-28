package com.employee.management.controller;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import lombok.var;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.employee.management.model.Employee;
import com.employee.management.service.EmployeeService;

@RestController
public class EmployeeController {
	
	static final Logger logger  = LogManager.getLogger(EmployeeController.class.getName());

	@Autowired
	private EmployeeService employeeService;
	
	// displaying list of all employees
	@GetMapping("/employees")
	public List<Employee> getAllEmployee(){
		return employeeService.getAllEmployees();
	}

	// displaying employee by id
	@GetMapping("/employees/{name}")
	public Employee getEmployee(@PathVariable String name){
		return employeeService.getEmployee(name);
	}

	// inserting employee
	@PostMapping("/employees")
	public void addEmployees(@RequestBody Employee employee){
		employeeService.addEmployee(employee);
	}

	//updating employee by id
	@PutMapping("/employees/{name}/{job}")
	public void updateEmployeeJob(@PathVariable String name, @PathVariable String job){
		employeeService.updateEmployeeJob(name, job);
	}
	
	// deleting all employees
	@DeleteMapping("/employees")
	public void deleteAllEmployees(){
		employeeService.deleteAllEmployees();
	}

	// deleting employee by id
	@DeleteMapping("employees/{name}")
	public void deleteEmployeeByName(@PathVariable String name){
		employeeService.deleteEmployeeByName(name);
	}

	@GetMapping("writeEmployeesIntoFile")
	public void writeEmployeesIntoFile(){
		try {
			Date currentDate = new Date();
			List<Employee> emps = employeeService.getAllEmployees();
			FileWriter writer = new FileWriter("D:\\TestFolder\\test.txt");
			writer.write("name,job");
			writer.write("\n");
			for(var emp: emps) {
				writer.write(emp.getName());
				writer.write(",");
				writer.write(emp.getJob());
				writer.write("\n");
			}
			writer.close();
			System.out.println("Successfully wrote to the file.");
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}

}
