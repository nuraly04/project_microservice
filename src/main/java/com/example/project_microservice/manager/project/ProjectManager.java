package com.example.project_microservice.manager.project;

import com.example.project_microservice.dto.project.ProjectCreateDto;
import com.example.project_microservice.dto.project.ProjectDto;
import com.example.project_microservice.dto.project.ProjectFilterDto;
import com.example.project_microservice.dto.project.ProjectUpdateDto;

import java.util.List;

public interface ProjectManager {

    ProjectDto create(Long userId, ProjectCreateDto dto);

    ProjectDto update(Long userId, Long projectId, ProjectUpdateDto updateDto);

    ProjectDto get(Long projectId);

    List<ProjectDto> getAll(Long userId);

    List<ProjectDto> getList(Long userId, ProjectFilterDto filterDto);
}
