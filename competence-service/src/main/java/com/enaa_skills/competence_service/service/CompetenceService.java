package com.enaa_skills.competence_service.service;


import com.enaa_skills.competence_service.dto.CompetenceDto;
import com.enaa_skills.competence_service.mapper.CompetenceMapper;
import com.enaa_skills.competence_service.model.Competence;
import com.enaa_skills.competence_service.repository.CompetenceRepository;
import org.hibernate.sql.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CompetenceService {
    private final CompetenceRepository competenceRepository;
    private final CompetenceMapper competenceMapper;

    @Autowired
    public CompetenceService(CompetenceRepository competenceRepository, CompetenceMapper competenceMapper) {
        this.competenceRepository = competenceRepository;
        this.competenceMapper = competenceMapper;
    }

    public CompetenceDto creerCompetence(CompetenceDto dto) {
        Competence competence = competenceMapper.toEntity(dto);
        Competence saved = competenceRepository.save(competence);
        return competenceMapper.toDto(saved);
    }

    public CompetenceDto getCompetenceById(Long id) {
        Competence competence = competenceRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Compétence non trouvée"));
        return competenceMapper.toDto(competence);
    }

    public List<CompetenceDto> getAllCompetences() {
        List<Competence> competences = competenceRepository.findAll();
         return competences.stream().map(competenceMapper::toDto).collect(Collectors.toList());
    }

    public CompetenceDto updateCompetence(Long id, CompetenceDto dto) {
        Competence existing = competenceRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Compétence non trouvée"));

        // Mettre à jour les champs de la compétence
        existing.setNom(dto.getNom());
        existing.setDescription(dto.getDescription());

        Competence saved = competenceRepository.save(existing);
        return competenceMapper.toDto(saved);
    }

    public void deleteCompetence(Long id) {
        if (!competenceRepository.existsById(id)) {
            throw new RuntimeException("Compétence non trouvée");
        }
        competenceRepository.deleteById(id);
    }
}