package com.app.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.main.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{

} 
