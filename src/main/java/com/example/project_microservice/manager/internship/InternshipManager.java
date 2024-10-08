package com.example.project_microservice.manager.internship;

import com.example.project_microservice.dto.internship.CreateInternshipDto;
import com.example.project_microservice.dto.internship.InternshipDto;
import com.example.project_microservice.dto.internship.InternshipFilterDto;
import com.example.project_microservice.dto.internship.UpdateInternshipDto;

import java.util.List;

public interface InternshipManager {

    InternshipDto create(CreateInternshipDto dto);

    InternshipDto get(Long internshipId);

    List<InternshipDto> getAll(InternshipFilterDto filterDto);

    List<InternshipDto> getByMentor(Long mentorId);

    List<InternshipDto> getByIntern(Long internId);
    InternshipDto update(Long internshipId, UpdateInternshipDto dto);
}
