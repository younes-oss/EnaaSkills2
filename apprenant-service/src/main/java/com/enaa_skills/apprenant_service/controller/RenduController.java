package com.enaa_skills.apprenant_service.controller;

import com.enaa_skills.apprenant_service.entity.Rendu;
import com.enaa_skills.apprenant_service.service.RenduService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rendus")
public class RenduController {

    @Autowired
    private RenduService renduService;

    @PostMapping
    public ResponseEntity<Rendu> createRendu(@RequestBody Rendu rendu) {
        Rendu savedRendu = renduService.saveRendu(rendu);
        return ResponseEntity.ok(savedRendu);
    }

    @GetMapping("/apprenant/{apprenantId}")
    public ResponseEntity<List<Rendu>> getRendusByApprenant(@PathVariable Long apprenantId) {
        List<Rendu> rendus = renduService.getRendusByApprenant(apprenantId);
        return ResponseEntity.ok(rendus);
    }
}

