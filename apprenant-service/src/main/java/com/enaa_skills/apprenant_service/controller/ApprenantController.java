package com.enaa_skills.apprenant_service.controller;

import com.enaa_skills.apprenant_service.entity.Apprenant;
import com.enaa_skills.apprenant_service.service.ApprenantService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/apprenants")
@com.enaa_skills.apprenant_service.controller.Tag(name = "Apprenant Management", description = "APIs for managing apprentices")
public class ApprenantController {

    @Autowired
    private ApprenantService apprenantService;

    @PostMapping("/inscription")
    @Operation(summary = "Register a new apprentice", description = "Creates a new apprentice record")
    public ResponseEntity<Apprenant> inscrire(@RequestBody Apprenant apprenant) {
        Apprenant saved = apprenantService.inscrire(apprenant);
        return ResponseEntity.ok(saved);
    }

    @GetMapping
    @Operation(summary = "Get all apprentices", description = "Retrieves a list of all registered apprentices")
    public ResponseEntity<List<Apprenant>> getAll() {
        return ResponseEntity.ok(apprenantService.getAll());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get apprentice by ID", description = "Retrieves a specific apprentice by their ID")
    public ResponseEntity<Apprenant> getById(@PathVariable Long id) {
        return apprenantService.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}

