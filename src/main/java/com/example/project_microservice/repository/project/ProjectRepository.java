package com.example.project_microservice.repository.project;

import com.example.project_microservice.model.project.Project;
import com.example.project_microservice.utils.enums.ProjectStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long>, QuerydslPredicateExecutor<Project> {

    boolean existsByTitleAndOwnerId(String title, Long ownerId);

    Collection<Project> findAllByOwnerId(Long ownerId);

    boolean existsByParentAndStatusNotIn(Project parentProject, Collection<ProjectStatus> status);
}
