package com.learnspring.employeecrud.dao;

import com.learnspring.employeecrud.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeDAO extends JpaRepository<Employee,Integer> {
    List<Employee> findAllByOrderByFirstNameAsc();
}
