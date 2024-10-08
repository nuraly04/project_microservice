package com.example.project_microservice.service.subproject.impl;

import com.example.project_microservice.dto.project.ProjectDto;
import com.example.project_microservice.exception.DataNotFoundException;
import com.example.project_microservice.model.project.Project;
import com.example.project_microservice.repository.subproject.SubProjectRepository;
import com.example.project_microservice.service.subproject.SubProjectService;
import com.example.project_microservice.utils.enums.ProjectStatus;
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
    public Project findById(Long subProjectId) {
        return subProjectRepository.findById(subProjectId)
                .orElseThrow(
                        () -> new DataNotFoundException("SubProject not found by id: " + subProjectId)
                );
    }

    @Override
    @Transactional
    public Project saveOrUpdate(Project project) {
        return subProjectRepository.save(project);
    }

    @Override
    @Transactional
    public void closeSubProject(Project subProject) {
        subProject.setStatus(ProjectStatus.COMPLETED);
        subProjectRepository.save(subProject);
    }
}
