package com.springAOP.controller;

import com.springAOP.model.Student;
import com.springAOP.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/add")
    public Student addStudent(@RequestParam("firstName")
                                 String firstName,
                              @RequestParam("lastName")
                                  String lastName){



        return studentService.addService(firstName,lastName);
    }
}
