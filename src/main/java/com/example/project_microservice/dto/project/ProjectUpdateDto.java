package com.example.project_microservice.dto.project;

import com.example.project_microservice.utils.enums.ProjectStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class ProjectUpdateDto {

    @NotBlank(message = "Поле названия не может быть пустым")
    @Size(message = "Длина названия не должна превышать 64 символов")
    private String title;

    @NotBlank(message = "Поле описания не может быть пустым")
    private String description;

    private ProjectStatus status;

    private boolean privacy;
}
