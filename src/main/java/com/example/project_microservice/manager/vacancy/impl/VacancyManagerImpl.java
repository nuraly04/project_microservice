package com.example.project_microservice.manager.vacancy.impl;

import com.example.project_microservice.dto.vacancy.CreateVacancyDto;
import com.example.project_microservice.dto.vacancy.UpdateVacancyDto;
import com.example.project_microservice.dto.vacancy.VacancyDto;
import com.example.project_microservice.dto.vacancy.VacancyFilterDto;
import com.example.project_microservice.manager.vacancy.VacancyManager;
import com.example.project_microservice.mapper.vacancy.VacancyMapper;
import com.example.project_microservice.model.vacancy.Vacancy;
import com.example.project_microservice.service.vacancy.VacancyService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;

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
        vacancyService.saveOrUpdate(vacancy);
        return vacancyMapper.toDto(vacancy);
    }

    @Override
    @Transactional(readOnly = true)
    public VacancyDto get(Long vacancyId) {
        Vacancy vacancy = vacancyService.get(vacancyId);
        return vacancyMapper.toDto(vacancy);
    }

    @Override
    @Transactional
    public VacancyDto update(Long vacancyId, UpdateVacancyDto dto) {
        Vacancy vacancy = vacancyService.get(vacancyId);
        vacancyMapper.toUpdate(vacancy, dto);
        return vacancyMapper.toDto(vacancy);
    }

    @Override
    @Transactional
    public void delete(Long vacancyId) {
        Vacancy vacancy = vacancyService.get(vacancyId);
        vacancyService.delete(vacancy);
    }

    @Override
    @Transactional
    public List<VacancyDto> getList(VacancyFilterDto filterDto) {
        Collection<Vacancy> vacancies = vacancyService.search(filterDto);
        return vacancies.stream()
                .map(vacancyMapper::toDto)
                .toList();
    }
}
