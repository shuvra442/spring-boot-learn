package com.springBootJPA.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String clgName;

    @OneToMany(mappedBy ="student")
    private List<Project> project;

    public Student() {
    }


    public Student(int id, String name, String clgName, List<Project> project) {
        this.id = id;
        this.name = name;
        this.clgName = clgName;
        this.project = project;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClgName() {
        return clgName;
    }

    public void setClgName(String clgName) {
        this.clgName = clgName;
    }

    public List<Project> getProject() {
        return project;
    }

    public void setProject(List<Project> project) {
        this.project = project;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", clgName='" + clgName + '\'' +
                ", project=" + project +
                '}';
    }
}
