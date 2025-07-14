package com.enaa_skills.brief_service.repository;

import com.enaa_skills.brief_service.Model.BriefCompetence;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BriefCompetenceRepository extends CrudRepository<BriefCompetence, Long> {
}
