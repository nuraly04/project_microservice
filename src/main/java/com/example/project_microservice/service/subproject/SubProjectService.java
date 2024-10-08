package com.example.project_microservice.service.subproject;

import com.example.project_microservice.model.project.Project;

public interface SubProjectService {

    Project findById(Long subProjectId);

    Project saveOrUpdate(Project project);

    void closeSubProject(Project subProject);
}
