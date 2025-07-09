package org.example.enaaskills.mapper;

import org.example.enaaskills.dto.SousCompetenceDto;
import org.example.enaaskills.model.Competence;
import org.example.enaaskills.model.SousCompetence;
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