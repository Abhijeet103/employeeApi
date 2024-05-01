package com.EmployeeWise.demo.repository;


import com.EmployeeWise.demo.entity.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface Repository extends MongoRepository<Employee, String> {
}
