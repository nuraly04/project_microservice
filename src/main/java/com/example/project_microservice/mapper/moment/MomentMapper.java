package com.example.project_microservice.mapper.moment;

import com.example.project_microservice.dto.moment.CreateMomentDto;
import com.example.project_microservice.dto.moment.MomentDto;
import com.example.project_microservice.model.moment.Moment;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface MomentMapper {

    Moment toEntity(CreateMomentDto dto);

    Moment toEntity(MomentDto momentDto);

    MomentDto toDto(Moment moment);
}
