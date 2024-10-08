package com.example.project_microservice.controller;

import com.example.project_microservice.dto.moment.CreateMomentDto;
import com.example.project_microservice.dto.moment.MomentDto;
import com.example.project_microservice.manager.moment.MomentManager;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class MomentController {

    MomentManager momentManager;

    @PostMapping
    public MomentDto create(
            @RequestParam Long projectId,
            @Valid @RequestBody CreateMomentDto dto) {
        return momentManager.create(projectId, dto);
    }


}
