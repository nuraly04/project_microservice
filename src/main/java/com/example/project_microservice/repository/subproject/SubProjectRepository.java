package com.example.project_microservice.repository.subproject;

import com.example.project_microservice.model.project.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubProjectRepository extends JpaRepository<Project, Long> {
}
