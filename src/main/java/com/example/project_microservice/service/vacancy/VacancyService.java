package com.example.project_microservice.service.vacancy;

import com.example.project_microservice.model.vacancy.Vacancy;

public interface VacancyService {

    Vacancy saveOrUpdate(Vacancy vacancy);
}
