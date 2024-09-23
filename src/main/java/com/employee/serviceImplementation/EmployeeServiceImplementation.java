package com.employee.serviceImplementation;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.employee.DTO.EmployeeDto;
import com.employee.Entity.Employee;
import com.employee.Exception.ResourceNotFoundException;
import com.employee.Mapper.EmployeeMapper;
import com.employee.Repository.EmployeeRepository;
import com.employee.service.EmployeeService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EmployeeServiceImplementation implements EmployeeService{

	private EmployeeRepository employeeRepo;
	
	@Override
	public EmployeeDto createEmployee(EmployeeDto employeeDto) {
    Employee employee=EmployeeMapper.mapToEmployee(employeeDto);
    Employee savedEmployee=employeeRepo.save(employee);
		return EmployeeMapper.mapToEmployeeDto(savedEmployee);
	}


	@Override
	public EmployeeDto getById(long id) {
	    Employee employee=employeeRepo.findById(id).orElseThrow(()->new ResourceNotFoundException ("Employee not exsists with given id :" + id));
		return EmployeeMapper.mapToEmployeeDto(employee);
	}

	@Override
	public List<EmployeeDto> getAllEmployee() {
	List<Employee> getAllEmployees=employeeRepo.findAll();
		return getAllEmployees.stream().map((employee)->EmployeeMapper.mapToEmployeeDto(employee)).collect(Collectors.toList());
	}

	@Override
	public EmployeeDto updateEmployee(Long id, EmployeeDto employeeDto) {
    Employee updateEmployee=employeeRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Employee id does not exsists with given id : "+ id));
	updateEmployee.setFirstName(updateEmployee.getFirstName());
	updateEmployee.setLastName(updateEmployee.getLastName());
	updateEmployee.setEmail(updateEmployee.getEmail());
    return EmployeeMapper.mapToEmployeeDto(updateEmployee);
	}

	@Override
	public void deleteEmployee(Long id) {
		Employee deleteEmployee=employeeRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Employee does not exsists with this id : "+ id));
		employeeRepo.deleteById(id);
	}


	
}
