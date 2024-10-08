package com.example.project_microservice.mapper.vacancy;

import com.example.project_microservice.dto.vacancy.CreateVacancyDto;
import com.example.project_microservice.dto.vacancy.VacancyDto;
import com.example.project_microservice.model.vacancy.Vacancy;

public interface VacancyMapper {

    Vacancy toEntity(CreateVacancyDto dto);

    VacancyDto toDto(Vacancy vacancy);
}
