package com.example.project_microservice.manager.internship.impl;

import com.example.project_microservice.dto.internship.CreateInternshipDto;
import com.example.project_microservice.dto.internship.InternshipDto;
import com.example.project_microservice.dto.internship.InternshipFilterDto;
import com.example.project_microservice.dto.internship.UpdateInternshipDto;
import com.example.project_microservice.manager.internship.InternshipManager;
import com.example.project_microservice.mapper.internship.InternshipMapper;
import com.example.project_microservice.model.internship.Internship;
import com.example.project_microservice.service.internship.InternshipService;
import com.example.project_microservice.validator.internship.InternshipValidator;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class InternshipManagerImpl implements InternshipManager {

    InternshipService internshipService;
    InternshipMapper internshipMapper;
    InternshipValidator internshipValidator;

    @Override
    @Transactional
    public InternshipDto create(CreateInternshipDto dto) {
        internshipValidator.validateEndDate(dto.getStartDate(), dto.getEndDate());
        Internship internship = internshipMapper.toCreate(dto);
        internshipService.saveOrUpdate(internship);
        return internshipMapper.toDto(internship);
    }

    @Override
    @Transactional(readOnly = true)
    public InternshipDto get(Long internshipId) {
        Internship internship = internshipService.get(internshipId);
        return internshipMapper.toDto(internship);
    }

    @Override
    @Transactional
    public InternshipDto update(Long internshipId, UpdateInternshipDto dto) {
        Internship internship = internshipService.get(internshipId);
        internshipMapper.toUpdate(internship, dto);
        return internshipMapper.toDto(internship);
    }

    @Override
    @Transactional(readOnly = true)
    public List<InternshipDto> getAll(InternshipFilterDto filterDto) {
        List<Internship> internships = internshipService.search(filterDto);
        return internships.stream()
                .map(internshipMapper::toDto)
                .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public List<InternshipDto> getByMentor(Long mentorId) {
        InternshipFilterDto filterDto = InternshipFilterDto.builder()
                .mentorId(mentorId)
                .build();
        List<Internship> internships = internshipService.search(filterDto);
        return internships.stream()
                .map(internshipMapper::toDto)
                .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public List<InternshipDto> getByIntern(Long internId) {
        InternshipFilterDto filterDto = InternshipFilterDto.builder()
                .internIds(List.of(internId))
                .build();
        List<Internship> internships = internshipService.search(filterDto);
        return internships.stream()
                .map(internshipMapper::toDto)
                .toList();
    }
}
