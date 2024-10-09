package com.example.project_microservice.model.stage;

import com.example.project_microservice.model.base.BaseEntity;
import com.example.project_microservice.utils.enums.StageStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "stage")
public class Stage extends BaseEntity {

    private String title;

    private StageStatus status;
}
