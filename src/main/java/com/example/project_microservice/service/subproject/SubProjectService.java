package com.example.project_microservice.service.subproject;

import com.example.project_microservice.dto.project.ProjectDto;
import com.example.project_microservice.model.project.Project;

public interface SubProjectService {

    ProjectDto createSubProject(Project parentProject, Project subProject);
}
