package com.example.project_microservice.controller;

import com.example.project_microservice.dto.internship.CreateInternshipDto;
import com.example.project_microservice.dto.internship.InternshipDto;
import com.example.project_microservice.dto.internship.InternshipFilterDto;
import com.example.project_microservice.dto.internship.UpdateInternshipDto;
import com.example.project_microservice.manager.internship.InternshipManager;
import com.example.project_microservice.utils.Paths;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(Paths.INTERNSHIP)
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class InternshipController {

    InternshipManager internshipManager;

    @PostMapping
    public InternshipDto create(
            @Valid @RequestBody CreateInternshipDto dto
    ) {
        return internshipManager.create(dto);
    }

    @GetMapping("/{internshipId}")
    public InternshipDto get(
            @PathVariable Long internshipId
    ) {
        return internshipManager.get(internshipId);
    }

    @PutMapping("{internshipId}")
    public InternshipDto update(
            @PathVariable Long internshipId,
            @RequestBody UpdateInternshipDto dto
    ) {
        return internshipManager.update(internshipId, dto);
    }

    @PostMapping("/list")
    private List<InternshipDto> getList(
        @RequestBody InternshipFilterDto filterDto
    ) {
        return internshipManager.getAll(filterDto);
    }

    @GetMapping("/mentor")
    public List<InternshipDto> getByMentor(@RequestParam Long mentorId) {
        return internshipManager.getByMentor(mentorId);
    }

    @GetMapping("/intern")
    public List<InternshipDto> getByIntern(@RequestParam Long internId) {
        return internshipManager.getByMentor(internId);
    }
}
