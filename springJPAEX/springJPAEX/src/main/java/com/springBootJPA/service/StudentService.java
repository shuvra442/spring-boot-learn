package com.springBootJPA.service;

import com.springBootJPA.models.Student;
import com.springBootJPA.repository.StudentRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepo studentRepo;

    public StudentService(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }

    //    creating student details
    public Student createStudent(Student student){
        Student student1=new Student();
        System.out.println(student.getClgName());
        student1.setName(student.getName());
        student1.setClgName(student.getClgName());
        return this.studentRepo.save(student1);
    }

// get student
    public Student findStudentById(int sId){
        return studentRepo.findById(sId).orElse(null);
    }
//    get all student
    public List<Student> findAllStudent(){
        return studentRepo.findAll();
    }

//    update student
    public Student updateStudent(Student student){
        Student students=studentRepo.findById(student.getId()).get();
        students.setName(student.getName());
        students.setClgName(student.getClgName());
        return studentRepo.save(students);
    }

//    Delete Student
    public void deleteStudent(int sId){
        studentRepo.deleteById(sId);
    }

}
