package com.example.project_microservice.dto.project;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProjectCreateDto {

    @NotBlank(message = "Заголовок не может быть пустым")
    @Size(max = 64, message = "Заголовк не должен быть длинее 64 символов")
    private String title;

    @NotBlank(message = "Описание не может быть пустым")
    private String description;

    private boolean privacy;
}
