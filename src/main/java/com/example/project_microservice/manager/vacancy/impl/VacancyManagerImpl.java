package com.example.project_microservice.manager.vacancy.impl;

import com.example.project_microservice.dto.vacancy.CreateVacancyDto;
import com.example.project_microservice.dto.vacancy.VacancyDto;
import com.example.project_microservice.manager.vacancy.VacancyManager;
import com.example.project_microservice.mapper.vacancy.VacancyMapper;
import com.example.project_microservice.model.vacancy.Vacancy;
import com.example.project_microservice.service.vacancy.VacancyService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class VacancyManagerImpl implements VacancyManager {

    VacancyService vacancyService;
    VacancyMapper vacancyMapper;

    @Override
    @Transactional
    public VacancyDto create(CreateVacancyDto dto) {
        Vacancy vacancy = vacancyMapper.toEntity(dto);
    }
}
