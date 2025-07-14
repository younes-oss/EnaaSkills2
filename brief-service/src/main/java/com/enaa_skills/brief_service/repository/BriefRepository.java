package com.enaa_skills.brief_service.repository;

import com.enaa_skills.brief_service.Model.Brief;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BriefRepository extends CrudRepository<Brief,Long> {
}
