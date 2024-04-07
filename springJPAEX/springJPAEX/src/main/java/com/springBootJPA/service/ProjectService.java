package com.springBootJPA.service;

import com.springBootJPA.models.Project;
import com.springBootJPA.models.Student;
import com.springBootJPA.repository.ProjectRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {

    private final ProjectRepo projectRepo;
    private final StudentService studentService;

    public ProjectService(ProjectRepo projectRepo, StudentService studentService) {
        this.projectRepo = projectRepo;
        this.studentService = studentService;
    }

    //    create project
    public Project createProject(Project project){
        return this.projectRepo.save(project);
    }

//    getAll project
    public List<Project> getALlProj(){
        return (List<Project>) projectRepo.findAll();
    }

//    get single project
    public Project getProj(int pId){
        return projectRepo.findById(pId).orElse(null);
    }

//   update project
    public Project updateProj(Project project){
        Project project1=projectRepo.findById(project.getpId()).get();
        project1.setpName(project.getpName());
        project1.setStudent(project.getStudent());
        return  projectRepo.save(project1);
    }

//    delete project
    public void deleteProj(int pId){
        projectRepo.deleteById(pId);
    }

}
