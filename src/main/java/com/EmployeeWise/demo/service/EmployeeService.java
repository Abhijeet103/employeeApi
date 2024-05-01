package com.EmployeeWise.demo.service;

import com.EmployeeWise.demo.entity.Employee;
import jakarta.mail.MessagingException;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface EmployeeService {


    // basic Crud API

    //level1 :  simple get all
    //level2 :  get all with option of sorting on any crieteria like emial phone number and pagination
    List<Employee> getAllEmployees(Pageable pageable) ;
    List<Employee> getAllEmployees() ;



    //level1 is simple create api
    // level3 is to send an email to level 1 manager on create
    String createEmployee(Employee employee) throws MessagingException;

    Employee deleteEmployee(String employeeId);

    Employee updateEmployee(Employee employee);


    //Level 2

    Employee getNthLevelEmployee(String employeeId , int n);


}
