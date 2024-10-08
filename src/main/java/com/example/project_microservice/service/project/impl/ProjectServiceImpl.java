package com.example.project_microservice.service.project.impl;

import com.example.project_microservice.dto.project.ProjectFilterDto;
import com.example.project_microservice.exception.DataNotFoundException;
import com.example.project_microservice.model.project.Project;
import com.example.project_microservice.repository.project.ProjectRepository;
import com.example.project_microservice.service.project.ProjectService;
import com.example.project_microservice.utils.enums.ProjectStatus;
import com.querydsl.core.BooleanBuilder;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

import static com.example.project_microservice.model.project.QProject.project;
import static java.util.Objects.nonNull;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ProjectServiceImpl implements ProjectService {

    ProjectRepository projectRepository;

    @Override
    @Transactional
    public Project create(Long userId, Project project) {
        project.setOwnerId(userId);
        project.setStatus(ProjectStatus.CREATED);
        return projectRepository.save(project);
    }

    @Override
    @Transactional
    public Project findById(Long projectId) {
        return projectRepository.findById(projectId).orElseThrow(
                () -> new DataNotFoundException("Не найден проект по id:" + projectId)
        );
    }

    @Override
    @Transactional(readOnly = true)
    public Collection<Project> findAllByOwnerId(Long ownerId) {
        return projectRepository.findAllByOwnerId(ownerId);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Project> search(ProjectFilterDto filterDto) {
        BooleanBuilder predicate = new BooleanBuilder();
        search(predicate, filterDto);
        return  (List<Project>) projectRepository.findAll(predicate);
    }

    @Override
    @Transactional(readOnly = true)
    public boolean existsByTitleAndOwnerId(String title, Long ownerId) {
        return projectRepository.existsByTitleAndOwnerId(title, ownerId);
    }

    private void search(BooleanBuilder predicate, ProjectFilterDto filterDto) {
        if (nonNull(filterDto.getId())) {
            predicate.and(project.id.eq(filterDto.getId()));
        }
        if (nonNull(filterDto.getTitle()) && !filterDto.getTitle().isEmpty()) {
            predicate.and(project.title.containsIgnoreCase(filterDto.getTitle()));
        }
        if (nonNull(filterDto.getDescription()) && !filterDto.getDescription().isEmpty()) {
            predicate.and(project.description.containsIgnoreCase(filterDto.getDescription()));
        }
        if (nonNull(filterDto.getStatus())) {
            predicate.and(project.status.eq(filterDto.getStatus()));
        }
        if (nonNull(filterDto.getDateFrom())) {
            if (nonNull(filterDto.getDateTo())) {
                predicate.and(project.createdAt.between(filterDto.getDateFrom(), filterDto.getDateTo()));
            } else predicate.and(project.createdAt.between(filterDto.getDateFrom(), LocalDateTime.now()));
        }
    }
}
