package com.i4digital.prueba.model.controller;

import java.util.List;

import com.i4digital.prueba.exceptions.NotFoundEmployeeException;
import com.i4digital.prueba.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

	@PostMapping("/employees")
	public Employee createEmployee(@RequestBody Employee employee) {
		return employeeService.createEmployee(employee);
	}

	@GetMapping("/employees/{id}")
	public Employee getEmployee(@PathVariable("id") Integer employeeId) {
		return employeeService.findEmployee(employeeId)
				.orElseThrow(() -> new NotFoundEmployeeException("Employee wasn't found"));
	}

	@PutMapping("/employees/{id}")
	public Employee updateEmployee(@PathVariable("id") Integer employeeId, @RequestBody Employee employee) {
		return employeeService.findEmployee(employeeId)
				.map(foundEmployee -> {
					Employee employeeToUpdate = Employee.from(employee, User.from(employee.getUser(), foundEmployee.getUser().getPassword()));
					return employeeService.updateEmployee(employeeToUpdate);
				})
				.orElseThrow(() -> new NotFoundEmployeeException("Employee wasn't found"));
	}



}
