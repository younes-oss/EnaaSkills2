package com.enaa_skills.competence_service.mapper;


import com.enaa_skills.competence_service.dto.CompetenceDto;
import com.enaa_skills.competence_service.model.Competence;
import com.enaa_skills.competence_service.model.SousCompetence;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CompetenceMapper {
    CompetenceMapper INSTANCE = Mappers.getMapper(CompetenceMapper.class);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "sousCompetences", source = "sousCompetences")
    Competence toEntity(CompetenceDto dto);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "competence", ignore = true)
    SousCompetence toEntity(CompetenceDto.SousCompetenceDto dto);

    CompetenceDto toDto(Competence entity);
} 