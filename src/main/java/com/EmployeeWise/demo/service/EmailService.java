package com.EmployeeWise.demo.service;

import com.EmployeeWise.demo.entity.Employee;
import com.EmployeeWise.demo.repository.Repository;
import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Component;

import java.util.*;


@Component
public class EmailService {

    @Autowired
    Repository repository;

    boolean sendMail(String reciver  , String subject  ,  String text) throws MessagingException {
        boolean flag  = false ;
        Properties properties = new Properties();
        properties.put("mail.smtp.auth", true);
        properties.put("mail.smtp.starttls.enable", true);
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        String userName  = "devtestapi209";
        String password = "ichxgmhygwgeafsp";
        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(userName, password);
            }
        });

        try {
            Message message  =  new MimeMessage(session) ;

            message.setRecipient(Message.RecipientType.TO  , new InternetAddress(reciver));
            message.setSubject(subject);
            message.setText(text);
            Transport.send(message);
            flag =  true ;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }


        return flag ;

    }
    void mailer(Employee employee) throws MessagingException {
        String managerEmail ="";
        try {
            managerEmail = repository.findById(employee.getReportsTo()).orElseThrow().getEmail();
        } catch (Exception e) {
            e.printStackTrace();
        }
        String subject = "Welcome our  new member" ;
        String message =  employee.toString();
        System.out.println(this.sendMail(managerEmail ,subject , message));

    }


}
