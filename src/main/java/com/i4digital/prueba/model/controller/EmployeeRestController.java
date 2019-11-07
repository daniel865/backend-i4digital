package com.i4digital.prueba.model.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.i4digital.prueba.model.Employee;
import com.i4digital.prueba.negocio.EmployeeService;


@RestController
@RequestMapping("/prueba")
public class EmployeeRestController {

	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/employees")
	public List<Employee> getEmployees(){
		return employeeService.findAll();
	}
}
