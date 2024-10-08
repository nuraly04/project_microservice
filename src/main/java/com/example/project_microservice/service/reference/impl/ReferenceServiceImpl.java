package com.example.project_microservice.service.reference.impl;

import com.example.project_microservice.exception.DataNotFoundException;
import com.example.project_microservice.model.reference.RefCommonReference;
import com.example.project_microservice.repository.reference.ReferenceRepository;
import com.example.project_microservice.service.reference.ReferenceService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ReferenceServiceImpl implements ReferenceService {

    ReferenceRepository referenceRepository;

    @Override
    @Transactional
    public RefCommonReference get(Long referenceId) {
        return referenceRepository.findById(referenceId)
                .orElseThrow(
                        () -> new DataNotFoundException("Reference not found")
                );
    }

    @Override
    @Transactional
    public Optional<RefCommonReference> findById(Long referenceId) {
        return referenceRepository.findById(referenceId);
    }

    @Override
    @Transactional
    public Collection<RefCommonReference> findByIds(List<Long> referenceIds) {
        return referenceRepository.findAllByIdIn(referenceIds);
    }
}
