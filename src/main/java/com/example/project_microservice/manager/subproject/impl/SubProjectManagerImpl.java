package com.example.project_microservice.manager.subproject.impl;

import com.example.project_microservice.dto.project.ProjectDto;
import com.example.project_microservice.dto.project.ProjectUpdateDto;
import com.example.project_microservice.dto.subproject.CreateSubProjectDto;
import com.example.project_microservice.manager.subproject.SubProjectManager;
import com.example.project_microservice.mapper.project.ProjectMapper;
import com.example.project_microservice.model.project.Project;
import com.example.project_microservice.service.project.ProjectService;
import com.example.project_microservice.service.subproject.SubProjectService;
import com.example.project_microservice.validator.project.ProjectValidator;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class SubProjectManagerImpl implements SubProjectManager {

    ProjectValidator projectValidator;
    ProjectService projectService;
    SubProjectService subProjectService;
    ProjectMapper projectMapper;

    @Override
    @Transactional
    public ProjectDto create(Long userId, CreateSubProjectDto dto) {
        projectValidator.validateTitle(userId, dto.getTitle());
        Project parentProject = projectService.findById(dto.getParentId());
        Project subProject = projectMapper.toCreateSubProject(dto, parentProject);
        subProjectService.saveOrUpdate(subProject);
        return projectMapper.toDto(subProject);
    }

    @Override
    @Transactional
    public void closeSubProject(Long subProjectId) {
        Project subProject = subProjectService.findById(subProjectId);
        subProjectService.closeSubProject(subProject);
    }

    @Override
    @Transactional
    public ProjectDto updateSubProject(Long subProjectId, Long userId, ProjectUpdateDto dto) {
        Project subProject = subProjectService.findById(subProjectId);
        projectValidator.validateTitleToUpdate(userId, subProject, dto.getTitle());
        projectMapper.toUpdate(dto, subProject);
        return projectMapper.toDto(subProject);
    }
}
