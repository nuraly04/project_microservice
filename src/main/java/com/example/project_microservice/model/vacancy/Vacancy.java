package com.example.project_microservice.model.vacancy;

import com.example.project_microservice.model.base.BaseEntity;
import com.example.project_microservice.model.project.Project;
import com.example.project_microservice.model.reference.RefCommonReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "vacancy")
public class Vacancy extends BaseEntity {

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "description", nullable = false)
    private String description;

    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;

    @ManyToOne
    @JoinColumn(name = "main_reference")
    private RefCommonReference mainReference;

    @ManyToMany
    @JoinTable(name = "m2m_vacancy_reference",
    joinColumns = @JoinColumn(name = "vacancy_id"),
    inverseJoinColumns = @JoinColumn(name = "reference_id"))
    private List<RefCommonReference> references;
}
