package com.example.PPMT.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.PPMT.domain.Project;

@Repository
public interface ProjectRepository extends CrudRepository<Project, Long>{

@Override 
Iterable<Project> findAll();

Project findByProjectIdentifier(String projectId);
	
	

}
