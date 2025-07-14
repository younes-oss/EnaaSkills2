package com.enaa_skills.brief_service.controller;

import com.enaa_skills.brief_service.Model.Brief;
import com.enaa_skills.brief_service.Model.BriefCompetence;
import com.enaa_skills.brief_service.dto.BriefDto;
import com.enaa_skills.brief_service.dto.BriefResponseDTO;
import com.enaa_skills.brief_service.mapper.BriefMapper;
import com.enaa_skills.brief_service.service.BriefService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/Briefs")
public class BriefController {

    private final BriefService briefService;

    public BriefController(BriefService briefService){
        this.briefService=briefService;
    }

    @PostMapping("/add")
    public ResponseEntity<BriefResponseDTO> createBrief(@RequestBody BriefDto briefDto){
        return ResponseEntity.ok(briefService.createBrief(briefDto));
    }

    @GetMapping
    public ResponseEntity<List<BriefResponseDTO>> getAllBriefs(){
        return ResponseEntity.ok(briefService.getAllBriefs());
    }

    @GetMapping("/{id}")
    public ResponseEntity<BriefResponseDTO> getBriefById(@PathVariable Long id){
        return ResponseEntity.ok(briefService.getBrief(id));
    }

    //getAllBriefs
    @GetMapping("/dto")
    public ResponseEntity<List<BriefResponseDTO>> getAllBriefsDTO(){
        List<BriefResponseDTO> briefs=briefService.getAllBriefs();

        return ResponseEntity.ok(briefs);
    }


    @PostMapping("/{id}/add-competence")
    public ResponseEntity<BriefCompetence> addCompetence(@PathVariable Long id, @RequestBody Map<String, Long> body){
        Long competenceId = body.get("competenceId");
        return ResponseEntity.ok(briefService.associeCompetence(id, competenceId));
    }
}
