package com.employee.management.model;

import com.google.gson.Gson;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

@Data

public class Employee {

	private String name;

	private String job;

	
	public Employee(){
		
	}
	
	public Employee(String name, String job) {
		this.name = name;
		this.job = job;
	}


	
}
