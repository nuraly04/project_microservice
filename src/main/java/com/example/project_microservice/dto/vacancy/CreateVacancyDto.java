package com.example.project_microservice.dto.vacancy;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateVacancyDto {

    @NotBlank
    private String title;

    @NotNull
    private Long projectId;

    @NotBlank
    private String description;

    @NotNull
    private Long mainReferenceId;

    private List<Long> referenceIds;
}
