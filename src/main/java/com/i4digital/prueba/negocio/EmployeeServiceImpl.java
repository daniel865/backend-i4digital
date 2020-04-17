package com.i4digital.prueba.negocio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.i4digital.prueba.model.Employee;
import com.i4digital.prueba.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public List<Employee> findAll() {
		return employeeRepository.findAll();
	}

	@Override
	public Optional<Employee> findEmployee(Integer employeeId) {
		return employeeRepository.findById(employeeId);
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		return employeeRepository.saveAndFlush(employee);
	}

	@Override
	public Employee createEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}


}
