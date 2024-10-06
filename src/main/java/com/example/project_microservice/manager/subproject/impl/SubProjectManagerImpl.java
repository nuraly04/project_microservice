package com.example.project_microservice.manager.subproject.impl;

import com.example.project_microservice.dto.project.ProjectDto;
import com.example.project_microservice.dto.subproject.CreateSubProjectDto;
import com.example.project_microservice.manager.subproject.SubProjectManager;
import com.example.project_microservice.mapper.project.ProjectMapper;
import com.example.project_microservice.model.project.Project;
import com.example.project_microservice.service.subproject.SubProjectService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class SubProjectManagerImpl implements SubProjectManager {

    SubProjectService subProjectService;
    ProjectMapper projectMapper;

    @Override
    @Transactional
    public ProjectDto create(Long userId, CreateSubProjectDto dto) {
        Project subProject = projectMapper.toCreate(dto);
        subProjectService
    }
}
