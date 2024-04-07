package com.springBootJPA.models;

import jakarta.persistence.*;

@Entity
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int pId;
    private String pName;

    @ManyToOne
    private Student student;



    public Project() {
    }

    public Project(int pId, String pName, Student student) {
        this.pId = pId;
        this.pName = pName;
        this.student = student;
    }

    public int getpId() {
        return pId;
    }

    public void setpId(int pId) {
        this.pId = pId;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }
    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "Project{" +
                "pId=" + pId +
                ", pName='" + pName + '\'' +
                ", student=" + student +
                '}';
    }
}
