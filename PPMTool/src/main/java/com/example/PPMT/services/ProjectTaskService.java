package com.example.PPMT.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.PPMT.domain.Backlog;
import com.example.PPMT.domain.ProjectTask;
import com.example.PPMT.repositories.BacklogRepository;
import com.example.PPMT.repositories.ProjectTaskRepository;

@Service
public class ProjectTaskService {
	
	@Autowired     
	private BacklogRepository backlogRepository;
	
	@Autowired
	private ProjectTaskRepository projectTaskRepository;

	
	public ProjectTask addprojectTask(String projectIdentifier, ProjectTask projectTask) {
		
		Backlog backlog = backlogRepository.findByProjectIdentifier(projectIdentifier);
		
		projectTask.setBacklog(backlog);
		
		Integer backlogSequence = backlog.getPTSequence();
		backlogSequence++;
		
		backlog.setPTSequence(backlogSequence);
		
		projectTask.setProjectSequence(backlog.getProjectIdentifier()+"-"+backlogSequence);
		projectTask.setProjectIdentifier(projectIdentifier);
		
		
		if(projectTask.getPriority()==null) {
			
			projectTask.setPriority(3);
		}
		if(projectTask.getStatus()==""||projectTask.getStatus()==null) {
			projectTask.setStatus("TO_DO");
		}
		
		
		
		return projectTaskRepository.save(projectTask);
		
	}


	public Iterable<ProjectTask> findBacklogById(String backlog_id) {
		
		return projectTaskRepository.findByProjectIdentifierOrderByPriority(backlog_id);
	}
}
