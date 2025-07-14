package com.enaa_skills.brief_service.mapper;


import com.enaa_skills.brief_service.Model.Brief;
import com.enaa_skills.brief_service.dto.BriefDto;
import com.enaa_skills.brief_service.dto.BriefResponseDTO;

public class BriefMapper {

    public static Brief toEntity(BriefDto briefDTO) {
        Brief brief = new Brief();
        brief.setTitle(briefDTO.titre());
        brief.setDescription(briefDTO.description());
        brief.setDateLimit(briefDTO.dateLimite());
        return brief;
    }

    public static BriefDto toDTO(Brief brief) {
        return new BriefDto(
                brief.getTitle(),
                brief.getDescription(),
                brief.getDateLimit()
        );

    }

    public static BriefResponseDTO toResponseDTO(Brief brief) {
        return new BriefResponseDTO(
                brief.getId(),
                brief.getTitle(),
                brief.getDescription(),
                brief.getDateLimit()
        );
    }
}
