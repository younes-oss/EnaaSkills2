package com.enaa_skills.apprenant_service.controller;

import com.enaa_skills.apprenant_service.entity.Apprenant;
import com.enaa_skills.apprenant_service.service.ApprenantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/apprenants")
public class ApprenantController {

    @Autowired
    private ApprenantService apprenantService;

    @PostMapping("/inscription")
    public ResponseEntity<Apprenant> inscrire(@RequestBody Apprenant apprenant) {
        Apprenant saved = apprenantService.inscrire(apprenant);
        return ResponseEntity.ok(saved);
    }

    @GetMapping
    public ResponseEntity<List<Apprenant>> getAll() {
        return ResponseEntity.ok(apprenantService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Apprenant> getById(@PathVariable Long id) {
        return apprenantService.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}

