package com.example.project_microservice.manager.moment.impl;

import com.example.project_microservice.dto.moment.CreateMomentDto;
import com.example.project_microservice.dto.moment.MomentDto;
import com.example.project_microservice.manager.moment.MomentManager;
import com.example.project_microservice.mapper.moment.MomentMapper;
import com.example.project_microservice.model.moment.Moment;
import com.example.project_microservice.model.project.Project;
import com.example.project_microservice.service.moment.MomentService;
import com.example.project_microservice.service.project.ProjectService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class MomentManagerImpl implements MomentManager {

    MomentMapper mapper;
    MomentService momentService;
    ProjectService projectService;

    @Override
    @Transactional
    public MomentDto create(Long projectId, CreateMomentDto dto) {
        Project project = projectService.get(projectId);
        Moment moment = mapper.toEntity(dto);
        momentService.saveOrUpdate(moment);
        return mapper.toDto(moment);
    }
}
