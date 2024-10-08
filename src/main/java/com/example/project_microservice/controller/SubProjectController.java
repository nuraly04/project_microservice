package com.example.project_microservice.controller;

import com.example.project_microservice.dto.project.ProjectDto;
import com.example.project_microservice.dto.project.ProjectUpdateDto;
import com.example.project_microservice.dto.subproject.CreateSubProjectDto;
import com.example.project_microservice.manager.subproject.SubProjectManager;
import com.example.project_microservice.utils.Paths;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

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

    @PutMapping("/close/{subProjectId}")
    public void closeSubProject(
            @PathVariable("userId") Long userId,
            @PathVariable("subProjectId") Long subProjectId
    ){
        subProjectManager.closeSubProject(subProjectId);
    }

    @PutMapping("/update/{subProjectId}")
    public ProjectDto updateSubProject(
            @PathVariable("userId") Long userId,
            @PathVariable("subProjectId") Long subProjectId,
            @RequestBody ProjectUpdateDto dto
            ) {
        return subProjectManager.updateSubProject(subProjectId, userId, dto);
    }
}
