package com.enaa_skills.competence_service.repository;


import com.enaa_skills.competence_service.model.Competence;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompetenceRepository extends JpaRepository<Competence, Long> {
} 