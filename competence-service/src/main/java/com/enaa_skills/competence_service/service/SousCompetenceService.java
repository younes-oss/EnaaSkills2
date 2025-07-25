package com.enaa_skills.competence_service.service;


import com.enaa_skills.competence_service.dto.SousCompetenceDto;
import com.enaa_skills.competence_service.mapper.SousCompetenceMapper;
import com.enaa_skills.competence_service.model.Competence;
import com.enaa_skills.competence_service.model.SousCompetence;
import com.enaa_skills.competence_service.repository.CompetenceRepository;
import com.enaa_skills.competence_service.repository.SousCompetenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SousCompetenceService {
    private final SousCompetenceRepository sousCompetenceRepository;
    private final CompetenceRepository competenceRepository;
    private final SousCompetenceMapper sousCompetenceMapper;

    @Autowired
    public SousCompetenceService(SousCompetenceRepository sousCompetenceRepository, CompetenceRepository competenceRepository, SousCompetenceMapper sousCompetenceMapper) {
        this.sousCompetenceRepository = sousCompetenceRepository;
        this.competenceRepository = competenceRepository;
        this.sousCompetenceMapper = sousCompetenceMapper;
    }

    public SousCompetenceDto creerSousCompetence(SousCompetenceDto dto) {
        Competence competence = competenceRepository.findById(dto.getCompetenceId())
                .orElseThrow(() -> new RuntimeException("Compétence non trouvée pour l'id: " + dto.getCompetenceId()));
        SousCompetence sousCompetence = sousCompetenceMapper.toEntity(dto, competence);
        SousCompetence saved = sousCompetenceRepository.save(sousCompetence);
        return sousCompetenceMapper.toDto(saved);
    }

    public SousCompetenceDto getSousCompetenceById(Long id) {
        SousCompetence sc = sousCompetenceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Sous-compétence non trouvée"));
        return sousCompetenceMapper.toDto(sc);
    }

    public List<SousCompetenceDto> getAllSousCompetences() {
        List<SousCompetence> list = sousCompetenceRepository.findAll();
        return list.stream().map(sousCompetenceMapper::toDto).collect(java.util.stream.Collectors.toList());
    }

    public SousCompetenceDto updateSousCompetence(Long id, SousCompetenceDto dto) {
        SousCompetence sc = sousCompetenceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Sous-compétence non trouvée"));
        sc.setNom(dto.getNom());
        sc.setValidee(dto.isValidee());
        if (dto.getCompetenceId() != null) {
            Competence competence = competenceRepository.findById(dto.getCompetenceId())
                    .orElseThrow(() -> new RuntimeException("Compétence non trouvée pour l'id: " + dto.getCompetenceId()));
            sc.setCompetence(competence);
        }
        SousCompetence saved = sousCompetenceRepository.save(sc);
        return sousCompetenceMapper.toDto(saved);
    }

    public void deleteSousCompetence(Long id) {
        sousCompetenceRepository.deleteById(id);
    }
} 