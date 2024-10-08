package com.example.project_microservice.service.internship.impl;

import com.example.project_microservice.dto.internship.InternshipFilterDto;
import com.example.project_microservice.exception.DataNotFoundException;
import com.example.project_microservice.model.internship.Internship;
import com.example.project_microservice.model.internship.QInternship;
import com.example.project_microservice.repository.intership.InternshipRepository;
import com.example.project_microservice.service.internship.InternshipService;
import com.querydsl.core.BooleanBuilder;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import static com.example.project_microservice.model.internship.QInternship.internship;
import static java.util.Objects.nonNull;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class InternshipServiceImpl implements InternshipService {

    InternshipRepository internshipRepository;

    @Override
    @Transactional
    public Internship get(Long internshipId) {
        return internshipRepository.findById(internshipId)
                .orElseThrow(
                        () -> new DataNotFoundException("Стажировка не найдена")
                );
    }

    @Override
    @Transactional
    public Optional<Internship> findById(Long internshipId) {
        return internshipRepository.findById(internshipId);
    }

    @Override
    @Transactional
    public List<Internship> search(InternshipFilterDto filterDto) {
        BooleanBuilder predicate = new BooleanBuilder();
        search(predicate, filterDto);
        return (List<Internship>) internshipRepository.findAll(predicate);
    }

    @Override
    @Transactional
    public Internship saveOrUpdate(Internship internship) {
        return internshipRepository.save(internship);
    }

    private void search(BooleanBuilder predicate, InternshipFilterDto filterDto) {
        if (nonNull(filterDto.getProjectId())) {
            predicate.and(internship.project.id.eq(filterDto.getProjectId()));
        }
        if (nonNull(filterDto.getMentorId())) {
            predicate.and(internship.mentor.id.eq(filterDto.getMentorId()));
        }
        if (nonNull(filterDto.getInternIds())) {
            predicate.and(internship.interns.any().id.in(filterDto.getInternIds()));
        }
        if (nonNull(filterDto.getStatus())) {
            predicate.and(internship.status.eq(filterDto.getStatus()));
        }
        if (nonNull(filterDto.getStartDate())) {
            if (nonNull(filterDto.getEndDate())) {
                predicate.and(internship.startDate.between(filterDto.getStartDate(), filterDto.getEndDate()));
            } else predicate.and(internship.startDate.between(filterDto.getStartDate(), LocalDateTime.now()));
        }
    }
}
