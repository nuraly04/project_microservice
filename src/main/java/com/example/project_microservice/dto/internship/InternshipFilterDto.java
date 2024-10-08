package com.example.project_microservice.dto.internship;

import com.example.project_microservice.utils.enums.InternshipStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InternshipFilterDto {

    private List<Long> internIds;
    private Long mentorId;
    private InternshipStatus status;
    private Long projectId;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
}
