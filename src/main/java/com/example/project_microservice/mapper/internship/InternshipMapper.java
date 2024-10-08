package com.example.project_microservice.mapper.internship;

import com.example.project_microservice.dto.internship.CreateInternshipDto;
import com.example.project_microservice.dto.internship.InternshipDto;
import com.example.project_microservice.dto.internship.UpdateInternshipDto;
import com.example.project_microservice.model.internship.Internship;

public interface InternshipMapper {

    Internship toCreate(CreateInternshipDto dto);

    Internship toUpdate(Internship internship, UpdateInternshipDto dto);

    InternshipDto toDto(Internship internship);
}
