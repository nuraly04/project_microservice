package com.example.project_microservice.service.subproject.impl;

import com.example.project_microservice.dto.project.ProjectDto;
import com.example.project_microservice.model.project.Project;
import com.example.project_microservice.repository.subproject.SubProjectRepository;
import com.example.project_microservice.service.subproject.SubProjectService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class SubProjectServiceImpl implements SubProjectService {

    SubProjectRepository subProjectRepository;

    @Override
    @Transactional
    public ProjectDto createSubProject(Project parentProject, Project subProject) {
        subProject.setParentProject(parentProject);
    }
}
