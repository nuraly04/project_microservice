package com.example.project_microservice.manager.project.impl;

import com.example.project_microservice.dto.project.ProjectCreateDto;
import com.example.project_microservice.dto.project.ProjectDto;
import com.example.project_microservice.dto.project.ProjectFilterDto;
import com.example.project_microservice.dto.project.ProjectUpdateDto;
import com.example.project_microservice.manager.project.ProjectManager;
import com.example.project_microservice.mapper.project.ProjectMapper;
import com.example.project_microservice.model.project.Project;
import com.example.project_microservice.service.project.ProjectService;
import com.example.project_microservice.validator.project.ProjectValidator;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ProjectManagerImpl implements ProjectManager {

    ProjectValidator projectValidator;
    ProjectService projectService;
    ProjectMapper projectMapper;

    @Override
    @Transactional
    public ProjectDto create(Long userId, ProjectCreateDto dto) {
        projectValidator.validateTitle(userId, dto.getTitle());
        Project project = projectMapper.toCreate(dto);
        projectService.create(userId, project);
        return projectMapper.toDto(project);
    }

    @Override
    @Transactional
    public ProjectDto update(Long userId, Long projectId, ProjectUpdateDto dto) {
        projectValidator.validateTitleToUpdate(userId, projectId, dto.getTitle());
        Project project = projectService.findById(projectId);
        projectMapper.toUpdate(dto, project);
        return projectMapper.toDto(project);
    }

    @Override
    @Transactional(readOnly = true)
    public ProjectDto get(Long projectId) {
        return projectMapper.toDto(projectService.findById(projectId));
    }

    @Override
    @Transactional(readOnly = true)
    public List<ProjectDto> getAll(Long userId) {
        Collection<Project> projects = projectService.findAllByOwnerId(userId);
        return projects.stream()
                .map(projectMapper::toDto)
                .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public List<ProjectDto> getList(Long userId, ProjectFilterDto filterDto) {
        List<Project> projects = projectService.search(filterDto);
        return projects.stream()
                .map(projectMapper::toDto)
                .toList();
    }
}
