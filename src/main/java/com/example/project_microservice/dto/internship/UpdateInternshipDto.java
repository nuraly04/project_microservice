package com.example.project_microservice.dto.internship;

import com.example.project_microservice.utils.enums.InternshipStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UpdateInternshipDto {

    private List<Long> internsIds;
    private Long mentorId;
    private InternshipStatus status;
}
