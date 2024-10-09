package com.example.project_microservice.dto.vacancy;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VacancyFilterDto {

    private Long vacancyId;
    private Long projectId;
    private String title;
    private String description;
    private Long mainReference;
    private List<Long> referenceIds;
}
