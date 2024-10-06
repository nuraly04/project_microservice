package com.example.project_microservice.controller;

import com.example.project_microservice.dto.project.ProjectDto;
import com.example.project_microservice.dto.subproject.CreateSubProjectDto;
import com.example.project_microservice.manager.subproject.SubProjectManager;
import com.example.project_microservice.utils.Paths;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(Paths.SUB_PROJECT)
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class SubProjectController {

    SubProjectManager subProjectManager;

    @PostMapping
    public ProjectDto createSubProject(
            @PathVariable("userId") Long userId,
            @Valid @RequestBody CreateSubProjectDto dto
    ) {
        return subProjectManager.create(userId, dto);
    }
}
