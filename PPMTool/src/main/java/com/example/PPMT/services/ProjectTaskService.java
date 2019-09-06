package com.example.PPMT.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.PPMT.domain.Backlog;
import com.example.PPMT.domain.Project;
import com.example.PPMT.domain.ProjectTask;
import com.example.PPMT.exceptions.ProjectNotFoundException;
import com.example.PPMT.repositories.BacklogRepository;
import com.example.PPMT.repositories.ProjectRepository;
import com.example.PPMT.repositories.ProjectTaskRepository;

@Service
public class ProjectTaskService {
	
	@Autowired     
	private BacklogRepository backlogRepository;
	
	@Autowired
	private ProjectTaskRepository projectTaskRepository;

	@Autowired 
	private ProjectRepository projectRepository;
	
	
	public ProjectTask addprojectTask(String projectIdentifier, ProjectTask projectTask) {
		
		try {
			
			
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
			
		}catch(Exception ex){
			throw new ProjectNotFoundException("Project not found");
		}
		
		
	}


	public Iterable<ProjectTask> findBacklogById(String backlog_id) {
		
		Project project = projectRepository.findByProjectIdentifier(backlog_id);
		
		if(project == null) {
			throw new ProjectNotFoundException("Project with id "+backlog_id+" does not exist");
		}
		
		return projectTaskRepository.findByProjectIdentifierOrderByPriority(backlog_id);
	}
	
	
	public ProjectTask findPTBySequence(String backlog_id, String pt_id) {
		
		
		Backlog backlog = backlogRepository.findByProjectIdentifier(backlog_id);
		
		if(backlog==null) {
			throw new ProjectNotFoundException("Project with id "+backlog+" does not exist");
		}
		
		ProjectTask projectTask = projectTaskRepository.findByProjectSequence(pt_id);
		if(projectTask==null) {
			throw new ProjectNotFoundException("Project Task with id "+pt_id+" does not exist");
		}
		
		if(!projectTask.getProjectIdentifier().equals(backlog_id)) {
			throw new ProjectNotFoundException("Project Task "+pt_id+" does not exist in project"+backlog_id);
		}
		
		
		return projectTask;
	}
	
}
