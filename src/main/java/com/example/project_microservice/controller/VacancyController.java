package com.example.project_microservice.controller;

import com.example.project_microservice.dto.vacancy.CreateVacancyDto;
import com.example.project_microservice.dto.vacancy.UpdateVacancyDto;
import com.example.project_microservice.dto.vacancy.VacancyDto;
import com.example.project_microservice.dto.vacancy.VacancyFilterDto;
import com.example.project_microservice.manager.vacancy.VacancyManager;
import com.example.project_microservice.utils.Paths;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.hibernate.sql.Update;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(Paths.VACANCY)
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class VacancyController {

    VacancyManager vacancyManager;

    @PostMapping
    public VacancyDto create(@Valid @RequestBody CreateVacancyDto dto) {
        return vacancyManager.create(dto);
    }

    @GetMapping("/{vacancyId}")
    public VacancyDto get(@PathVariable Long vacancyId) {
        return vacancyManager.get(vacancyId);
    }

    @DeleteMapping("/{vacancyId}")
    public void delete(@PathVariable Long vacancyId) {
        vacancyManager.delete(vacancyId);
    }

    @PutMapping("/{vacancyId}")
    public VacancyDto update(@PathVariable Long vacancyId, @RequestBody UpdateVacancyDto dto) {
        return vacancyManager.update(vacancyId, dto);
    }

    @PostMapping("/list")
    public List<VacancyDto> getList(@RequestBody VacancyFilterDto filterDto) {
        return vacancyManager.getList(filterDto);
    }
}
