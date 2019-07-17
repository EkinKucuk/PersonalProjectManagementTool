package com.example.PPMT.exceptions;

public class ProjectIdExceptionResponse {

	public String getProjectIdentifier() {
		return projectIdentifier;
	}

	public void setProjectIdentifier(String projectIdentifier) {
		this.projectIdentifier = projectIdentifier;
	}

	private String projectIdentifier;

	public ProjectIdExceptionResponse(String projectIdentifier) {
	
		this.projectIdentifier = projectIdentifier;
	}
	
	
	
	
}
