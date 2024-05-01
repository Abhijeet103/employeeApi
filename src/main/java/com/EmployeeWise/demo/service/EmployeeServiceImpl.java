package com.EmployeeWise.demo.service;


import com.EmployeeWise.demo.entity.Employee;
import com.EmployeeWise.demo.repository.Repository;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {


    @Autowired
    Repository  repository ;

    @Autowired
    EmailService emailService ;
    @Override
    public List<Employee> getAllEmployees(Pageable pageable) {
        return repository.findAll(pageable).getContent();
    }

    @Override
    public List<Employee> getAllEmployees() {
        return repository.findAll();
    }


    @Override
    public String createEmployee(Employee employee) throws MessagingException {
        repository.save(employee);
        emailService.mailer(employee);
        return employee.getId();
    }



    @Override
    public Employee deleteEmployee(String employeeId) {

        Employee employee  = repository.findById(employeeId).orElseThrow();
        repository.delete(employee);
        return  employee;
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        repository.save(employee);

        return employee;
    }

    @Override
    public Employee getNthLevelEmployee(String employeeId , int n ) {
        Employee employee =  repository.findById(employeeId).orElseThrow();
        for(int  i =0 ;i<n ;i++)
        {
            employee  = repository.findById(employee.getReportsTo()).orElseThrow();
        }
        return employee ;

    }
}
