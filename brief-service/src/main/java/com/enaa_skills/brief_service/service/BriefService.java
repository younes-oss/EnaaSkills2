package com.enaa_skills.brief_service.service;

import com.enaa_skills.brief_service.Model.Brief;
import com.enaa_skills.brief_service.Model.BriefCompetence;
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

    public Brief creatBrief(Brief brief) {
        return briefRepository.save(brief);
    }

    public List<Brief> getAllBriefs() {
        return (List<Brief>) briefRepository.findAll();
    }


    public BriefCompetence associeCompetence(Long briefId,Long competenceId)
    {
        Brief brief = briefRepository.findById(briefId).orElseThrow(()->new RuntimeException("Brief not trouvé"));

        BriefCompetence briefCompetence = new BriefCompetence();
        briefCompetence.setBrief(brief);
        briefCompetence.setCompetenceId(competenceId);

        return briefCompetenceRepository.save(briefCompetence);

    }

    public Brief createBriefDTO(Brief brief) {
        return briefRepository.save(brief);
    }

    public Brief getBrief(Long id) {
        return briefRepository.findById(id).orElseThrow(()->{
            return  new RuntimeException("Brief not found");
        });

    }

}