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
public class UpdateVacancyDto {

    private String title;
    private String description;
    private Long mainReferenceId;
    private List<Long> referencesIds;
}
