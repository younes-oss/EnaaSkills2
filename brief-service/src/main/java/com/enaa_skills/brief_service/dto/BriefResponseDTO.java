package com.enaa_skills.brief_service.dto;


import java.time.LocalDate;

public record BriefResponseDTO (
        Long id,
        String title,
        String description ,
        LocalDate dateLimite
){}