package com.example.project_microservice.manager.vacancy;

import com.example.project_microservice.dto.vacancy.CreateVacancyDto;
import com.example.project_microservice.dto.vacancy.UpdateVacancyDto;
import com.example.project_microservice.dto.vacancy.VacancyDto;
import com.example.project_microservice.dto.vacancy.VacancyFilterDto;

import java.util.List;

public interface VacancyManager {

    VacancyDto create(CreateVacancyDto dto);

    VacancyDto get(Long vacancyId);

    void delete(Long vacancyId);

    VacancyDto update(Long vacancyId, UpdateVacancyDto dto);

    List<VacancyDto> getList(VacancyFilterDto filterDto);
}
