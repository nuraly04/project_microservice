package com.example.project_microservice.model.reference;

import com.example.project_microservice.model.base.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table
public class RefCommonReference extends BaseEntity {

    @Column(name = "code", unique = true, nullable = false)
    private String code;

    @Column(name = "name", nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "type_id")
    private RefCommonReferenceType type;

    @ManyToOne
    private RefCommonReference parent;

    @OneToMany(mappedBy = "parent")
    private List<RefCommonReference> referencesChilds;
}
