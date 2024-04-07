package com.springBootJPA.repository;

import com.springBootJPA.models.Project;
import org.springframework.data.repository.CrudRepository;

public interface ProjectRepo extends CrudRepository<Project, Integer> {
}
