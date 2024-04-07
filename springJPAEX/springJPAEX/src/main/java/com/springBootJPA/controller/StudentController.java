package com.springBootJPA.controller;

import com.springBootJPA.models.Student;
import com.springBootJPA.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Author: shuvra
 * DATE:- 07.04.2024
 */

@RestController
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }
    //    create student controller

    @PostMapping("/student")
    public Student createStudent(@RequestBody Student student){
        return this.studentService.createStudent(student);
    }

//    get single student
    @GetMapping("/student/{id}")
    public Student findById(@PathVariable("id") int sId){
        return studentService.findStudentById(sId);
    }

//    get all student
    @GetMapping("/students")
    public List<Student> gelAll(){
        return studentService.findAllStudent();
    }

//    update student
    @PutMapping("/student/{Id}")
    public Student updateStudent(@PathVariable("Id") int sId, @RequestBody Student student){
        student.setId(sId);
         return studentService.updateStudent(student);
    }

//    delete student
    @DeleteMapping("/student/{id}")
    public void deleteStd(@PathVariable("id") int sId){
        studentService.deleteStudent(sId);
    }

}
