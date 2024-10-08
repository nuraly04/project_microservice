package com.example.project_microservice.model.project;

import com.example.project_microservice.model.base.BaseEntity;
import com.example.project_microservice.model.internship.Internship;
import com.example.project_microservice.utils.enums.ProjectMovement;
import com.example.project_microservice.utils.enums.ProjectStatus;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "project")
public class Project extends BaseEntity {

    @Column(name = "owner_id", nullable = false)
    private Long ownerId;

    @Column(name = "title", nullable = false, length = 64)
    private String title;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "status", nullable = false)
    @Enumerated(value = EnumType.STRING)
    private ProjectStatus status;

    @Column(name = "movement")
    @Enumerated(value = EnumType.STRING)
    private ProjectMovement movement;

    @Column(name = "privacy", nullable = false)
    private boolean privacy;

    @ManyToOne
    @JoinColumn(name = "parent_id")
    private Project parentProject;

    @OneToMany(mappedBy = "parentProject")
    private List<Project> subProjects;

    @OneToMany(mappedBy = "project")
    private List<Internship> internships;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "created_by")
    private LocalDateTime createdBy;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "updated_by")
    private LocalDateTime updatedBy;
}
