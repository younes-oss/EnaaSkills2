package com.enaa_skills.brief_service.service;

import com.enaa_skills.brief_service.Model.Brief;
import com.enaa_skills.brief_service.Model.BriefCompetence;
import com.enaa_skills.brief_service.dto.BriefDto;
import com.enaa_skills.brief_service.dto.BriefResponseDTO;
import com.enaa_skills.brief_service.mapper.BriefMapper;
import com.enaa_skills.brief_service.repository.BriefCompetenceRepository;
import com.enaa_skills.brief_service.repository.BriefRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BriefService {

    private final BriefRepository briefRepository;
    private final BriefCompetenceRepository briefCompetenceRepository;

    public BriefService(BriefRepository briefRepository, BriefCompetenceRepository briefCompetenceRepository) {
        this.briefRepository = briefRepository;
        this.briefCompetenceRepository = briefCompetenceRepository;
    }

    // Créer un brief à partir d'un DTO
    public BriefResponseDTO createBrief(BriefDto briefDto) {
        Brief brief = BriefMapper.toEntity(briefDto);
        Brief saved = briefRepository.save(brief);
        return BriefMapper.toResponseDTO(saved);
    }

    // Récupérer tous les briefs sous forme de DTO de réponse
    public List<BriefResponseDTO> getAllBriefs() {
        return ((List<Brief>) briefRepository.findAll())
                .stream()
                .map(BriefMapper::toResponseDTO)
                .collect(java.util.stream.Collectors.toList());
    }

    // Associer une compétence à un brief (retourne l'entité ou tu peux créer un DTO spécifique)
    public BriefCompetence associeCompetence(Long briefId, Long competenceId) {
        Brief brief = briefRepository.findById(briefId)
                .orElseThrow(() -> new RuntimeException("Brief not trouvé"));

        BriefCompetence briefCompetence = new BriefCompetence();
        briefCompetence.setBrief(brief);
        briefCompetence.setCompetenceId(competenceId);

        return briefCompetenceRepository.save(briefCompetence);
    }

    // Récupérer un brief par son id sous forme de DTO de réponse
    public BriefResponseDTO getBrief(Long id) {
        Brief brief = briefRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Brief not found"));
        return BriefMapper.toResponseDTO(brief);
    }

}