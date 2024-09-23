package com.employee.Controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.DTO.EmployeeDto;
import com.employee.service.EmployeeService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/employee")
@AllArgsConstructor
public class EmployeeController {

	private EmployeeService employeeService;
	
	@PostMapping("/create")
	public ResponseEntity<EmployeeDto> createEmploye(@RequestBody EmployeeDto employeeDto){
		EmployeeDto savedEmployee=employeeService.createEmployee(employeeDto);
		return new ResponseEntity<EmployeeDto>(savedEmployee,HttpStatus.CREATED);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<EmployeeDto> getById(@PathVariable Long id){
		EmployeeDto employeeDto=employeeService.getById(id);
		return new ResponseEntity<EmployeeDto>(employeeDto,HttpStatus.OK);
	}
	
	@GetMapping("/getallemployees")
	public ResponseEntity<List<EmployeeDto>> getAllEmployees(){
		List<EmployeeDto> getAllEmployees=employeeService.getAllEmployee();
		return new ResponseEntity<List<EmployeeDto>>(getAllEmployees,HttpStatus.OK);
	}
	
	@PutMapping("/updateEmployee/{id}")
	public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable Long id, @RequestBody EmployeeDto employeeDto){
		EmployeeDto upadateEmployee=employeeService.updateEmployee(id, employeeDto);
		return new ResponseEntity<EmployeeDto>(upadateEmployee,HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteEmployee/{id}")
	public ResponseEntity<String> deleteById(@PathVariable long id){
		employeeService.deleteEmployee(id);
		return new ResponseEntity<String>("Employee deleted successfully",HttpStatus.OK);
	}
}
