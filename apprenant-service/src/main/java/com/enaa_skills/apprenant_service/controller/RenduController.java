package com.enaa_skills.apprenant_service.controller;

import com.enaa_skills.apprenant_service.entity.Rendu;
import com.enaa_skills.apprenant_service.service.RenduService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rendus")
@Tag(name = "Rendu Management", description = "APIs for managing apprentice submissions")
public class RenduController {

    @Autowired
    private RenduService renduService;

    @PostMapping
    @Operation(summary = "Create a new submission", description = "Creates a new submission (rendu) for an apprentice")
    public ResponseEntity<Rendu> createRendu(@RequestBody Rendu rendu) {
        Rendu savedRendu = renduService.saveRendu(rendu);
        return ResponseEntity.ok(savedRendu);
    }

    @GetMapping("/apprenant/{apprenantId}")
    @Operation(summary = "Get submissions by apprentice", description = "Retrieves all submissions for a specific apprentice")
    public ResponseEntity<List<Rendu>> getRendusByApprenant(@PathVariable Long apprenantId) {
        List<Rendu> rendus = renduService.getRendusByApprenant(apprenantId);
        return ResponseEntity.ok(rendus);
    }
}

