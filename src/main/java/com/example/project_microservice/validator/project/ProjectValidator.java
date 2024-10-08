package com.example.project_microservice.validator.project;

import com.example.project_microservice.exception.DataValidationException;
import com.example.project_microservice.model.project.Project;
import com.example.project_microservice.service.project.ProjectService;
import com.example.project_microservice.utils.enums.ProjectStatus;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ProjectValidator {

    ProjectService projectService;

    public void validateTitle(Long userId, String title) {
        if (projectService.existsByTitleAndOwnerId(title, userId)) {
            throw new DataValidationException("У пользователя уже есть проект с таким названием");
        }
    }

    public void validateProjectToClose(Project project) {
        if (projectService.existsByParentAndStatusNotIn(project, List.of(ProjectStatus.COMPLETED, ProjectStatus.CLOSED))) {
            throw new DataValidationException("У проекта есть не завершенные подпроекты");
        }
    }

    public void validateTitleToUpdate(Long userId, Project project, String title) {
        if (!project.getTitle().equals(title)) {
            validateTitle(userId, title);
        }
    }
}
