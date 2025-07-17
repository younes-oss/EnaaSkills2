package com.enaa_skills.brief_service.client;

import com.enaa_skills.brief_service.dto.CompetenceDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "competence-service", url = "${competence-service.url}")
public interface CompetenceClient {
    @GetMapping("/competences/{id}")
    CompetenceDto getCompetenceById(@PathVariable("id") Long id);
    // Ajoute d'autres méthodes si besoin
} 