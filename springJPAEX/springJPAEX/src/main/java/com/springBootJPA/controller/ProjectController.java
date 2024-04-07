package com.springBootJPA.controller;

import com.springBootJPA.models.Project;
import com.springBootJPA.models.Student;
import com.springBootJPA.repository.ProjectRepo;
import com.springBootJPA.service.ProjectService;
import com.springBootJPA.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Author: shuvra
 * DATE:- 07.04.2024
 */

@RestController
public class ProjectController {

    private final ProjectService projectService;
    private final StudentService studentService;
    private final ProjectRepo projectRepo;

    public ProjectController(ProjectService projectService, StudentService studentService,
                             ProjectRepo projectRepo) {
        this.projectService = projectService;
        this.studentService = studentService;
        this.projectRepo = projectRepo;
    }



//    get project
    @GetMapping("/project/{pId}")
    public Project getProj(@PathVariable("pId")int id){
        return projectService.getProj(id);
    }

//    getAll project
    @GetMapping("/projects")
    public List<Project> getALlProj(){
        return projectService.getALlProj();
    }

//    create project
    @PostMapping("/project/{sId}")
    public Project createProject(@PathVariable("sId")int sId, @RequestBody Project project){
        Student student=studentService.findStudentById(sId);
        Project project1 = new Project();
        project1.setpName(project.getpName());
        project1.setStudent(student);
        return this.projectService.createProject(project1);
    }

//    Update project
    @PutMapping("/project/{pId}")
    public Project updateProj(@RequestBody Project project, @PathVariable("pId") int pId){
        project.setpId(pId);
        return projectService.updateProj(project);
    }

//    delete project
    @DeleteMapping("/project/{pId}")
    public void deleteProj(@PathVariable("pId")int pId){
        projectService.deleteProj(pId);
    }
}
