package com.example.project_microservice.service.vacancy.impl;

import com.example.project_microservice.model.vacancy.Vacancy;
import com.example.project_microservice.repository.vacancy.VacancyRepository;
import com.example.project_microservice.service.vacancy.VacancyService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class VacancyServiceImpl implements VacancyService {

    VacancyRepository vacancyRepository;

    @Override
    @Transactional
    public Vacancy saveOrUpdate(Vacancy vacancy) {
        return vacancyRepository.save(vacancy);
    }
}
