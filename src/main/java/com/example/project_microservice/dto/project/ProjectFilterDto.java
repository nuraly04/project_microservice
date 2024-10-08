package com.example.project_microservice.dto.project;

import com.example.project_microservice.utils.enums.ProjectStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProjectFilterDto {

    private Long id;
    private String title;
    private String description;
    private ProjectStatus status;
    private LocalDateTime dateFrom;
    private LocalDateTime dateTo;
}
