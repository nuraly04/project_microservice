package com.example.project_microservice.dto.subproject;

import com.example.project_microservice.dto.project.ProjectCreateDto;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class CreateSubProjectDto extends ProjectCreateDto {

    @NotNull
    Long parentId;
}
