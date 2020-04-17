package com.i4digital.prueba.negocio;

import java.util.List;
import java.util.Optional;

import com.i4digital.prueba.model.Employee;

public interface EmployeeService {
	List<Employee> findAll();

	Optional<Employee> findEmployee(Integer employeeId);

	Employee updateEmployee(Employee employee);

	Employee createEmployee(Employee employee);
}
