package com.enaa_skills.competence_service.controller;


import com.enaa_skills.competence_service.dto.CompetenceDto;
import com.enaa_skills.competence_service.service.CompetenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/competences")
public class CompetenceController {
    private final CompetenceService competenceService;

    @Autowired
    public CompetenceController(CompetenceService competenceService) {
        this.competenceService = competenceService;
    }

    @GetMapping("/{id}")
    public CompetenceDto getCompetenceById(@PathVariable Long id) {
        return competenceService.getCompetenceById(id);
    }
    @GetMapping
    public List<CompetenceDto> getAllCompetences() {
        return  competenceService.getAllCompetences();
    }

    @PostMapping
    public CompetenceDto creerCompetence(@RequestBody CompetenceDto dto) {
        return competenceService.creerCompetence(dto);
    }

    @PutMapping("/{id}")
    public CompetenceDto updateCompetence(@PathVariable Long id, @RequestBody CompetenceDto dto) {
        return competenceService.updateCompetence(id, dto);
    }

    @DeleteMapping("/{id}")
    public void deleteCompetence(@PathVariable Long id) {
        competenceService.deleteCompetence(id);
    }
} 