package com.example.project_microservice.model.role;

import com.example.project_microservice.model.base.BaseEntity;
import com.example.project_microservice.model.member.Member;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

import java.util.List;

@Entity
@Table(name = "security_role")
public class SecurityRole extends BaseEntity {

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "code", unique = true, nullable = false)
    private String code;

    @ManyToMany(mappedBy = "roles")
    private List<Member> members;
}
