package com.example.project_microservice.service.project;

import com.example.project_microservice.dto.project.ProjectFilterDto;
import com.example.project_microservice.model.project.Project;
import com.example.project_microservice.utils.enums.ProjectStatus;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface ProjectService {

    Project create(Long userId, Project project);

    Optional<Project> findById(Long projectId);

    Project get(Long projectId);

    Collection<Project> findAllByOwnerId(Long ownerId);

    List<Project> search(ProjectFilterDto filterDto);

    boolean existsByTitleAndOwnerId(String title, Long ownerId);

    boolean existsByParentAndStatusNotIn(Project parentProject, Collection<ProjectStatus> status);
}
