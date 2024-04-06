package com.springAOP.service;

import com.springAOP.controller.StudentController;
import com.springAOP.model.Student;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    public Student addService(String fname, String lname){
        System.out.println("Hi Alien What's up");
        Student student=new Student();
        student.setFirstName(fname);
        student.setLastName(lname);
        return student;
    }
}
