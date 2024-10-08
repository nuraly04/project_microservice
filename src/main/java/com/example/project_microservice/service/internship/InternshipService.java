package com.example.project_microservice.service.internship;

import com.example.project_microservice.dto.internship.InternshipFilterDto;
import com.example.project_microservice.model.internship.Internship;

import java.util.List;
import java.util.Optional;

public interface InternshipService {

    Internship get(Long internshipId);

    Optional<Internship> findById(Long internshipId);

    List<Internship> search(InternshipFilterDto filterDto);

    Internship saveOrUpdate(Internship internship);
}
