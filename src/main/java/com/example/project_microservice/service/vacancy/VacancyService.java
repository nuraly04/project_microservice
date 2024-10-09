package com.example.project_microservice.service.vacancy;

import com.example.project_microservice.dto.vacancy.VacancyFilterDto;
import com.example.project_microservice.model.vacancy.Vacancy;

import java.util.Collection;
import java.util.Optional;

public interface VacancyService {

    Vacancy saveOrUpdate(Vacancy vacancy);

    Vacancy get(Long vacancyId);

    Optional<Vacancy> findById(Long vacancyId);

    void delete(Vacancy vacancy);

    Collection<Vacancy> search(VacancyFilterDto filterDto);
}
