package com.springBootJDBC.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JdbcController {

    @Autowired
    JdbcTemplate jdbcTemplate;
    @GetMapping("/test")
    public String JdbcExm(){
        jdbcTemplate.update("insert into user(name,email) values('shuvra','shuvrapatra5@gmail.com')");
        return "Data Inserted Successfully";
    }
}
