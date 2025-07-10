package com.enaa_skills.competence_service.mapper;


import com.enaa_skills.competence_service.dto.SousCompetenceDto;
import com.enaa_skills.competence_service.model.Competence;
import com.enaa_skills.competence_service.model.SousCompetence;
import org.springframework.stereotype.Component;

@Component
public class SousCompetenceMapper {
    public SousCompetenceDto toDto(SousCompetence entity) {
        if (entity == null) return null;
        Long competenceId = entity.getCompetence() != null ? entity.getCompetence().getId() : null;
        return new SousCompetenceDto(entity.getId(), entity.getNom(), entity.isValidee(), competenceId);
    }

    public SousCompetence toEntity(SousCompetenceDto dto, Competence competence) {
        if (dto == null) return null;
        SousCompetence sc = new SousCompetence();
        sc.setId(dto.getId());
        sc.setNom(dto.getNom());
        sc.setValidee(dto.isValidee());
        sc.setCompetence(competence);
        return sc;
    }
} 