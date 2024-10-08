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
public class InternshipDto {

    private Long projectId;
    private Long mentorId;
    private List<Long> interns;
    private InternshipStatus status;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
}
