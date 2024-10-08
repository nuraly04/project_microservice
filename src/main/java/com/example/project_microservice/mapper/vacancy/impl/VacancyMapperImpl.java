package com.example.project_microservice.mapper.vacancy.impl;

import com.example.project_microservice.dto.vacancy.CreateVacancyDto;
import com.example.project_microservice.dto.vacancy.VacancyDto;
import com.example.project_microservice.mapper.vacancy.VacancyMapper;
import com.example.project_microservice.model.reference.RefCommonReference;
import com.example.project_microservice.model.vacancy.Vacancy;
import com.example.project_microservice.service.project.ProjectService;
import com.example.project_microservice.service.reference.ReferenceService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Component
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class VacancyMapperImpl implements VacancyMapper {

    ProjectService projectService;
    ReferenceService referenceService;

    @Override
    public Vacancy toEntity(CreateVacancyDto dto) {
        List<RefCommonReference> referenceList = new ArrayList<>(referenceService.findByIds(dto.getReferenceIds());

        Vacancy vacancy = new Vacancy();
        vacancy.setTitle(dto.getTitle());
        vacancy.setDescription(dto.getDescription());
        vacancy.setProject(projectService.get(dto.getProjectId()));
        vacancy.setMainReference(referenceService.get(dto.getMainReferenceId()));
        vacancy.setReferences(referenceList);
        return vacancy;
    }

    @Override
    public Vacancy toEntity(VacancyDto dto) {


    }
}
