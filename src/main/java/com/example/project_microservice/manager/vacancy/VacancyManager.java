package com.example.project_microservice.manager.vacancy;

import com.example.project_microservice.dto.vacancy.CreateVacancyDto;
import com.example.project_microservice.dto.vacancy.VacancyDto;

public interface VacancyManager {

    VacancyDto create(CreateVacancyDto dto);
}
