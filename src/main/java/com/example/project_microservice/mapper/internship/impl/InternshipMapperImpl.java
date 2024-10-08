package com.example.project_microservice.mapper.internship.impl;

import com.example.project_microservice.dto.internship.CreateInternshipDto;
import com.example.project_microservice.dto.internship.InternshipDto;
import com.example.project_microservice.dto.internship.UpdateInternshipDto;
import com.example.project_microservice.mapper.internship.InternshipMapper;
import com.example.project_microservice.model.internship.Internship;
import com.example.project_microservice.model.member.Member;
import com.example.project_microservice.service.member.MemberService;
import com.example.project_microservice.service.project.ProjectService;
import com.example.project_microservice.utils.enums.InternshipStatus;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class InternshipMapperImpl implements InternshipMapper {

    ProjectService projectService;
    MemberService memberService;

    @Override
    public Internship toCreate(CreateInternshipDto dto) {
        Internship internship = new Internship();
        internship.setMentor(memberService.get(dto.getMentorId()));
        internship.setInterns(memberService.findByIds(dto.getInterns()));
        internship.setProject(projectService.get(dto.getProjectId()));
        internship.setStatus(InternshipStatus.CREATED);
        internship.setStartDate(dto.getStartDate());
        internship.setEndDate(dto.getEndDate());
        return internship;
    }

    @Override
    public Internship toUpdate(Internship internship, UpdateInternshipDto dto) {
        internship.setMentor(memberService.get(dto.getMentorId()));
        internship.setInterns(memberService.findByIds(dto.getInternsIds()));
        internship.setStatus(dto.getStatus());
        return internship;
    }

    @Override
    public InternshipDto toDto(Internship internship) {
        InternshipDto dto = new InternshipDto();
        dto.setProjectId(internship.getProject().getId());
        dto.setMentorId(internship.getMentor().getId());
        dto.setInterns(internship.getInterns().stream().map(Member::getId).toList());
        dto.setStatus(internship.getStatus());
        dto.setStartDate(internship.getStartDate());
        dto.setEndDate(internship.getEndDate());
        return dto;
    }
}
