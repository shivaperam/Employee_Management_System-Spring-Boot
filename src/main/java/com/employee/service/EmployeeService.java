package com.employee.service;

import java.util.List;

import com.employee.DTO.EmployeeDto;

public interface EmployeeService {
 
	public EmployeeDto createEmployee(EmployeeDto employeeDto);
	public EmployeeDto getById(long id);
	public List<EmployeeDto> getAllEmployee();
	public EmployeeDto updateEmployee(Long id,EmployeeDto employeeDto);
	void deleteEmployee(Long id);
}
