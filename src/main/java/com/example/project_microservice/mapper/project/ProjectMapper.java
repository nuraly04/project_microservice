package com.example.project_microservice.mapper.project;

import com.example.project_microservice.dto.project.ProjectCreateDto;
import com.example.project_microservice.dto.project.ProjectDto;
import com.example.project_microservice.dto.project.ProjectUpdateDto;
import com.example.project_microservice.model.project.Project;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ProjectMapper {

    Project toCreate(ProjectCreateDto createDto);

    @Mapping(source = "parentProject", target = "parent")
    Project toCreateSubProject(ProjectCreateDto createDto, Project parentProject);

    void toUpdate(ProjectUpdateDto dto, @MappingTarget Project project);

    ProjectDto toDto(Project project);
}
