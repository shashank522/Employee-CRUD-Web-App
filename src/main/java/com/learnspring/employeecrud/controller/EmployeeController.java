package com.learnspring.employeecrud.controller;

import com.learnspring.employeecrud.entity.Employee;
import com.learnspring.employeecrud.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
    private EmployeeService employeeService;
    @Autowired
    public EmployeeController(EmployeeService employeeService)
    {
        this.employeeService=employeeService;
    }
    @GetMapping("/list")
    public String findAll(Model model)
    {
        List<Employee> tempEmployees=employeeService.findAll();
        model.addAttribute("employees",tempEmployees);
        return "list-employees";
    }
    @GetMapping("/showFormForAdd")
    public String showAddForm(Model model)
    {
        model.addAttribute("employee",new Employee());
        return "add-employee-form";
    }
    @GetMapping("/showFormForUpdate")
    public String update(@RequestParam("employeeId") int id,Model model)
    {
        Employee tempEmployee=employeeService.findById(id);
        model.addAttribute("employee",tempEmployee);
        return "add-employee-form";
    }
    @PostMapping("/save")
    public String save(@Validated @ModelAttribute ("employee") Employee theEmployee
    , BindingResult bindingResult)
    {
        if(bindingResult.hasErrors())
            return "add-employee-form";
        Employee tempEmployee=employeeService.save(theEmployee);
        return "redirect:/employees/list";
    }
    @GetMapping("/delete")
    public String delete(@RequestParam("employeeId") int id)
    {
        employeeService.deleteById(id);
        return "redirect:/employees/list";
    }
}
