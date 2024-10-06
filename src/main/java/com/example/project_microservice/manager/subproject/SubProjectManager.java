package com.example.project_microservice.manager.subproject;

import com.example.project_microservice.dto.project.ProjectDto;
import com.example.project_microservice.dto.subproject.CreateSubProjectDto;

public interface SubProjectManager {

    ProjectDto create(Long userId, CreateSubProjectDto dto);
}
