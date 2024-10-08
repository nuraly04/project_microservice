package com.example.project_microservice.validator.internship;

import com.example.project_microservice.exception.DataValidationException;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class InternshipValidator {

    private final static int MAX_AVAILABLE_MONTH = 3;

    public void validateEndDate(LocalDateTime startDate, LocalDateTime endDate) {
        if (startDate.isBefore(LocalDateTime.now()) || endDate.isBefore(LocalDateTime.now())) {
            throw new DataValidationException("Не валиддные время начало или окончания стажировки");
        }
        if (endDate.isBefore(startDate)) {
            throw new DataValidationException("Дата окончания не может быть раньше даты начала");
        }
        LocalDateTime maxEndDate = startDate.plusMonths(MAX_AVAILABLE_MONTH);
        if (endDate.isAfter(maxEndDate)) {
            throw new DataValidationException("Стажировка должна длиться не меннее 3 месяца");
        }
    }
}
