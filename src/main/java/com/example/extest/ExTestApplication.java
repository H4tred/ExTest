package com.example.extest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import javax.annotation.PostConstruct;

@SpringBootApplication
@EntityScan(value = "com.example.extest.entity")
public class ExTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExTestApplication.class, args);
        System.out.println("[...Application started!]");

    }

    @PostConstruct
    public void welcome() {
        System.out.println("[Initialization...]");
    }
}
