package com.EmployeeWise.demo.entity;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Data
@Document
@NoArgsConstructor
public class Employee {
    @Id
    private String id ;
    private String employeeName;
    @Pattern(regexp = "^\\d{10}$" , message = "Invalid Phone number")
    private String phoneNumber ;
    @Email(message = "Invalid emailId")
    private String email ;
    private String  reportsTo ;
    private String  profileImage ;
}
