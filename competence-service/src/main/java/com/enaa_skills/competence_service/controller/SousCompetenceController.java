package org.example.enaaskills.controller;

import org.example.enaaskills.dto.SousCompetenceDto;
import org.example.enaaskills.service.SousCompetenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sous-competences")
public class SousCompetenceController {
    private final SousCompetenceService sousCompetenceService;

    @Autowired
    public SousCompetenceController(SousCompetenceService sousCompetenceService) {
        this.sousCompetenceService = sousCompetenceService;
    }

    @PostMapping
    public ResponseEntity<SousCompetenceDto> createSousCompetence(@RequestBody SousCompetenceDto dto) {
        SousCompetenceDto created = sousCompetenceService.creerSousCompetence(dto);
        return ResponseEntity.ok(created);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SousCompetenceDto> getSousCompetenceById(@PathVariable Long id) {
        try {
            SousCompetenceDto dto = sousCompetenceService.getSousCompetenceById(id);
            return ResponseEntity.ok(dto);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public List<SousCompetenceDto> getAllSousCompetences() {
        return sousCompetenceService.getAllSousCompetences();
    }

    @PutMapping("/{id}")
    public ResponseEntity<SousCompetenceDto> updateSousCompetence(@PathVariable Long id, @RequestBody SousCompetenceDto dto) {
        SousCompetenceDto updated = sousCompetenceService.updateSousCompetence(id, dto);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSousCompetence(@PathVariable Long id) {
        sousCompetenceService.deleteSousCompetence(id);
        return ResponseEntity.noContent().build();
    }
} 