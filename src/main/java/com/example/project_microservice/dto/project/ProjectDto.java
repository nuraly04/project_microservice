package com.example.project_microservice.dto.project;

import com.example.project_microservice.utils.enums.ProjectStatusEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProjectDto {

    private Long id;
    private String title;
    private String description;
    private ProjectStatusEnum status;
    private boolean privacy;
}
