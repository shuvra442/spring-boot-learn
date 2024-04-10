package com.springBootCache.controller;

import com.springBootCache.model.Student;
import com.springBootCache.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentController {
    @Autowired
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/student/getAll")
    public List<Student> getAllStudent(){
        return this.studentService.getAll();
    }

    @GetMapping("/student/{id}")
    public Student getStudentById(@PathVariable("id") int id){
        return this.studentService.getById(id);
    }

    @GetMapping("/student/clearCache")
    public String getStudentById(){
        studentService.clearAllCache();
        return "all data is cleared";
    }
}
