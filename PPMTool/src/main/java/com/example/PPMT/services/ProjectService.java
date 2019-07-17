package com.example.PPMT.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.PPMT.domain.Project;
import com.example.PPMT.exceptions.ProjectIdException;
import com.example.PPMT.repositories.ProjectRepository;

@Service
public class ProjectService {
	
	@Autowired
	private ProjectRepository projectRepository;

	public Project saveOrUpdateProject(Project project) {
	try {
		project.setProjectIdentifier(project.getProjectIdentifier().toUpperCase());
		return projectRepository.save(project);
		
	}catch (Exception e) {
		throw new ProjectIdException("Project ID: '"+project.getProjectIdentifier().toUpperCase()+"' is already exist");
	}
	
		
	}
	
	public Project findProjectByidentifier(String projectId) {
		Project project = projectRepository.findByProjectIdentifier(projectId.toUpperCase());
		if(project == null)
			throw new ProjectIdException("Project ID"+projectId.toUpperCase()+" does not exist");
		return project;
	}
	
	
	public Iterable<Project> findAllProjects(){
		
		return projectRepository.findAll();
	}
	
	
	public void deleteProjectByIdentifier(String projectId) {
		Project project = projectRepository.findByProjectIdentifier(projectId.toUpperCase());
		if(project==null) {
			throw new ProjectIdException("Cannot delete the project with ID: '"+projectId.toUpperCase()+"'. Project does not exist");
		}
		projectRepository.delete(project);
		
	}
	
}
