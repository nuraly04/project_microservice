package com.example.project_microservice.service.reference;

import com.example.project_microservice.model.reference.RefCommonReference;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface ReferenceService {

    RefCommonReference get(Long referenceId);

    Optional<RefCommonReference> findById(Long referenceId);

    Collection<RefCommonReference> findByIds(List<Long> referenceIds);
}
