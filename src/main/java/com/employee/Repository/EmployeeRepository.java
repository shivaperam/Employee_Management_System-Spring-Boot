package com.employee.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.employee.Entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}
