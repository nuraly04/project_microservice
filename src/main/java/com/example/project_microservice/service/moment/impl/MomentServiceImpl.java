package com.example.project_microservice.service.moment.impl;

import com.example.project_microservice.model.moment.Moment;
import com.example.project_microservice.repository.moment.MomentRepository;
import com.example.project_microservice.service.moment.MomentService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class MomentServiceImpl implements MomentService {

    MomentRepository momentRepository;

    @Override
    @Transactional
    public Moment saveOrUpdate(Moment moment) {
        return momentRepository.save(moment);
    }
}
