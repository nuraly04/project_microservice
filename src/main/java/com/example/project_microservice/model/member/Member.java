package com.example.project_microservice.model.member;

import com.example.project_microservice.model.base.BaseEntity;
import com.example.project_microservice.model.internship.Internship;
import com.example.project_microservice.model.project.Project;
import com.example.project_microservice.model.role.SecurityRole;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "member")
public class Member extends BaseEntity {

    @Column(name = "user_id", nullable = false)
    private Long userId;

    @ManyToMany
    @JoinTable(name = "m2m_member_role",
            joinColumns = @JoinColumn(name = "member_id"),
            inverseJoinColumns = @JoinColumn(name = "security_role"))
    private List<SecurityRole> roles;

    @OneToMany(mappedBy = "mentor")
    private List<Internship> mentorInternships;

    @ManyToMany(mappedBy = "interns")
    private List<Internship> internInternships;

    @ManyToMany(mappedBy = "members")
    private List<Project> projects;
}
