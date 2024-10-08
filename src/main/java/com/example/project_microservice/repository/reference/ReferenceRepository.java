package com.example.project_microservice.repository.reference;

import com.example.project_microservice.model.reference.RefCommonReference;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface ReferenceRepository extends JpaRepository<RefCommonReference, Long> {

    Collection<RefCommonReference> findAllByIdIn(List<Long> referenceIds);
}
