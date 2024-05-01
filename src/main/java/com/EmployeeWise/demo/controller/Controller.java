package com.EmployeeWise.demo.controller;

import com.EmployeeWise.demo.Exception.InvalidBodyException;
import com.EmployeeWise.demo.entity.Employee;
import com.EmployeeWise.demo.service.EmployeeService;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class Controller {

    @Autowired
    EmployeeService  employeeService  ;
    @GetMapping("/employee")
    public List<Employee> getAllEmployees(Pageable pageable) {

        return employeeService.getAllEmployees(pageable);
    }


    @PostMapping("/employee")
    String createEmployee(@Validated @RequestBody Employee employee , BindingResult  error) throws MessagingException {
        if(error.hasErrors())
        {
            StringBuilder errors = new StringBuilder();
            error.getAllErrors().forEach(e -> {
                errors.append(e.getDefaultMessage()).append(" ,");
            });
            throw new InvalidBodyException(errors.toString());
        }
        return  employeeService.createEmployee(employee);
    }


    @PutMapping("/employee")
    Employee updateEmployee(@RequestBody Employee employee)
    {
        return employeeService.updateEmployee(employee);
    }


    @DeleteMapping("/employee/{employeeId}")
    Employee deleteEmployee(@PathVariable String employeeId)
    {
        return employeeService.deleteEmployee(employeeId);
    }

    @GetMapping("/employee/{employeeId}/{n}")
    Employee getNthLevelManager(@PathVariable String employeeId , @PathVariable int  n)
    {
        return employeeService.getNthLevelEmployee(employeeId , n);
    }
}
