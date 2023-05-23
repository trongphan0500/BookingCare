package com.example.doctorcareserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.jms.JMSException;
import javax.naming.NamingException;

@SpringBootApplication
public class DoctorcareServerApplication {

    com.example.doctorcareserver.MyQSender sender = new com.example.doctorcareserver.MyQSender();

    public DoctorcareServerApplication() throws NamingException, JMSException {
//        sender.sendMessage("alo");
    }


    public static void main(String[] args) {

        SpringApplication.run(DoctorcareServerApplication.class, args);
    }

}
