package com.example.project_microservice.service.moment;

import com.example.project_microservice.model.moment.Moment;

public interface MomentService {

    Moment saveOrUpdate(Moment moment);
}
