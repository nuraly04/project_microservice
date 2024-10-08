package com.example.project_microservice.dto.moment;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateMomentDto {

    @NotBlank
    private String title;

    @NotBlank
    private String description;
}
