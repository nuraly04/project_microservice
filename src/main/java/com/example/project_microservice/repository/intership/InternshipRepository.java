package com.example.project_microservice.repository.intership;

import com.example.project_microservice.model.internship.Internship;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface InternshipRepository extends JpaRepository<Internship, Long>, QuerydslPredicateExecutor<Internship> {
}
