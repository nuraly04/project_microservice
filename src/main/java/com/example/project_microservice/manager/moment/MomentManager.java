package com.example.project_microservice.manager.moment;

import com.example.project_microservice.dto.moment.CreateMomentDto;
import com.example.project_microservice.dto.moment.MomentDto;

public interface MomentManager {

    MomentDto create(Long projectId, CreateMomentDto dto);
}
