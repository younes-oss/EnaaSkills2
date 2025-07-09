package org.example.enaaskills.dto;

public class SousCompetenceDto {
    private Long id;
    private String nom;
    private boolean validee;
    private Long competenceId;

    public SousCompetenceDto() {}

    public SousCompetenceDto(Long id, String nom, boolean validee, Long competenceId) {
        this.id = id;
        this.nom = nom;
        this.validee = validee;
        this.competenceId = competenceId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public boolean isValidee() {
        return validee;
    }

    public void setValidee(boolean validee) {
        this.validee = validee;
    }

    public Long getCompetenceId() {
        return competenceId;
    }

    public void setCompetenceId(Long competenceId) {
        this.competenceId = competenceId;
    }
} 