package com.example.demo.repositories.abstracts;

import com.example.demo.entities.concretes.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {

}
