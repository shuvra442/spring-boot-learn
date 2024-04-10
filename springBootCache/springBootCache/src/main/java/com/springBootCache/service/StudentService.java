package com.springBootCache.service;

import com.springBootCache.model.Student;
import com.springBootCache.repository.StudentRepo;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepo studentRepo;


    public StudentService(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }

    public List<Student> getAll(){
        return this.studentRepo.findAll();
    }

    /**
     * @Cacheable annotation is used to store data in a cache..
     * @param id
     * @return get student by id
     */

    /**
    @Cacheable(value = "stdCache", key = "#id")
    public Student getById(int id){
        System.out.println("hi alien");
        return this.studentRepo.findById(id).get();
    }
    */
    /**
     * Now the question is when the new request comming the api direct go to the database and fetch it,
     * but I don't want this .I want once the application start its automatically fetch data from database
     * and load on cache........... yes its possible look on cacheConfig package.
     */
    @Cacheable(value = "applicationCache", key = "#id")
    public Student getById(int id){
        System.out.println("hi alien");
        return this.studentRepo.findById(id).get();
    }

    /**
     * Now I want to clear all cache data
     */
    @CacheEvict(cacheNames = "applicationCache", allEntries = true)
    public void clearAllCache(){
        System.out.println("cache clear ");

    }
}
