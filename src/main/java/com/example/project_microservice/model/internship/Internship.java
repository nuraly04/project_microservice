package com.example.project_microservice.model.internship;

import com.example.project_microservice.model.base.BaseEntity;
import com.example.project_microservice.model.member.Member;
import com.example.project_microservice.model.project.Project;
import com.example.project_microservice.utils.enums.InternshipStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "internship")
public class Internship extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "project_id", nullable = false)
    private Project project;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "status", nullable = false)
    private InternshipStatus status;

    @ManyToOne
    @JoinColumn(name = "mentor_id", nullable = false)
    private Member mentor;

    @ManyToMany
    @JoinTable(name = "m2m_internship_member",
    joinColumns = @JoinColumn(name = "internship_id"),
    inverseJoinColumns = @JoinColumn(name = "member_id"))
    private List<Member> interns;

    @Column(name = "start_date")
    private LocalDateTime startDate;

    @Column(name = "end_date")
    private LocalDateTime endDate;
}
