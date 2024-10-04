package com.example.project_microservice.service.project;

import com.example.project_microservice.dto.project.ProjectFilterDto;
import com.example.project_microservice.model.project.Project;

import java.util.Collection;
import java.util.List;

public interface ProjectService {

    Project create(Long userId, Project project);

    Project findById(Long projectId);

    Collection<Project> findAllByOwnerId(Long ownerId);

    List<Project> search(ProjectFilterDto filterDto);

    boolean existsByTitleAndOwnerId(String title, Long ownerId);
}
