package com.learnspring.employeecrud.service;

import com.learnspring.employeecrud.dao.EmployeeDAO;
import com.learnspring.employeecrud.entity.Employee;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeDAO employeeDAO;
    public EmployeeServiceImpl(EmployeeDAO employeeDAO)
    {
        this.employeeDAO=employeeDAO;
    }

    @Override
    public List<Employee> findAll() {
        return employeeDAO.findAllByOrderByFirstNameAsc();
    }

    @Override
    public Employee findById(int id) {
        Optional<Employee> tempEmployee=employeeDAO.findById(id);
        if(tempEmployee.isEmpty())
            throw new RuntimeException("No employee found with the id- "+id);
        return employeeDAO.save(tempEmployee.get());
    }

    @Override
    public Employee save(Employee theEmployee) {
        return employeeDAO.save(theEmployee);
    }

    @Override
    public void deleteById(int id) {
        employeeDAO.deleteById(id);
    }
}
