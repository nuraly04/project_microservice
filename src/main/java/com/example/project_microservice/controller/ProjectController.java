package com.example.project_microservice.controller;

import com.example.project_microservice.dto.project.ProjectCreateDto;
import com.example.project_microservice.dto.project.ProjectDto;
import com.example.project_microservice.dto.project.ProjectFilterDto;
import com.example.project_microservice.dto.project.ProjectUpdateDto;
import com.example.project_microservice.manager.project.ProjectManager;
import com.example.project_microservice.utils.Paths;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(Paths.USER_PROJECT)
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ProjectController {

    ProjectManager projectManager;

    @PostMapping
    public ProjectDto create(
            @PathVariable Long userId,
            @Valid @RequestBody ProjectCreateDto dto) {
        return projectManager.create(userId, dto);
    }

    @PutMapping("/{projectId}")
    public ProjectDto update(
            @PathVariable Long userId,
            @PathVariable("projectId") Long projectId,
            @Valid @RequestBody ProjectUpdateDto dto
    ) {
        return projectManager.update(userId, projectId, dto);
    }

    @GetMapping("/{projectId}")
    public ProjectDto get(
            @PathVariable("userId") Long userId,
            @PathVariable("projectId") Long projectId
    ) {
        return projectManager.get(projectId);
    }

    @GetMapping()
    public List<ProjectDto> getAll(
            @PathVariable("userId") Long userId
    ) {
        return projectManager.getAll(userId);
    }

    @GetMapping("/list")
    public List<ProjectDto> getList(
            @PathVariable("userId") Long userId,
            @RequestBody ProjectFilterDto filterDto
    ) {
        return projectManager.getList(userId, filterDto);
    }

}
