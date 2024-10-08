package com.example.project_microservice.model.internship;

import com.example.project_microservice.model.base.BaseEntity;
import com.example.project_microservice.model.project.Project;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "internship")
public class Internship extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "project_id", nullable = false)
    private Project project;

    @Column(name = "mentor_id", nullable = false)
    private Long mentorId;

    @Column(name = "start_date")
    private LocalDateTime startDate;

    @Column(name = "end_date")
    private LocalDateTime endDate;
}
