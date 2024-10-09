package com.example.project_microservice.service.vacancy.impl;

import com.example.project_microservice.dto.vacancy.VacancyFilterDto;
import com.example.project_microservice.exception.DataNotFoundException;
import com.example.project_microservice.model.vacancy.QVacancy;
import com.example.project_microservice.model.vacancy.Vacancy;
import com.example.project_microservice.repository.vacancy.VacancyRepository;
import com.example.project_microservice.service.vacancy.VacancyService;
import com.querydsl.core.BooleanBuilder;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;
import java.util.Optional;

import static com.example.project_microservice.model.vacancy.QVacancy.vacancy;
import static java.util.Objects.nonNull;

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

    @Override
    @Transactional
    public Vacancy get(Long vacancyId) {
        return vacancyRepository.findById(vacancyId)
                .orElseThrow(
                        () -> new DataNotFoundException("Вакансия не найдена")
                );
    }

    @Override
    @Transactional
    public Optional<Vacancy> findById(Long vacancyId) {
        return vacancyRepository.findById(vacancyId);
    }

    @Override
    @Transactional
    public void delete(Vacancy vacancy) {
        vacancyRepository.delete(vacancy);
    }

    @Override
    @Transactional
    public Collection<Vacancy> search(VacancyFilterDto filterDto) {
        BooleanBuilder predicate = new BooleanBuilder();
        search(predicate, filterDto);
        return (Collection<Vacancy>) vacancyRepository.findAll(predicate);
    }

    private void search(BooleanBuilder predicate, VacancyFilterDto filterDto) {
        if (nonNull(filterDto.getTitle())) {
            predicate.and(vacancy.title.containsIgnoreCase(filterDto.getTitle()));
        }
        if (nonNull(filterDto.getDescription())) {
            predicate.and(vacancy.description.containsIgnoreCase(filterDto.getDescription()));
        }
        if (nonNull(filterDto.getVacancyId())) {
            predicate.and(vacancy.id.eq(filterDto.getVacancyId()));
        }
        if (nonNull(filterDto.getProjectId())) {
            predicate.and(vacancy.project.id.eq(filterDto.getProjectId()));
        }
        if (nonNull(filterDto.getMainReference())) {
            predicate.and(vacancy.mainReference.id.eq(filterDto.getMainReference()));
        }
        if (nonNull(filterDto.getReferenceIds()) && !filterDto.getReferenceIds().isEmpty()) {
            predicate.and(vacancy.references.any().id.in(filterDto.getReferenceIds()));
        }
    }
}
