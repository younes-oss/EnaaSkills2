package com.enaa_skills.apprenant_service.service;

import com.enaa_skills.apprenant_service.entity.Rendu;
import com.enaa_skills.apprenant_service.repository.RenduRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class RenduService {

    @Autowired
    private RenduRepository renduRepository;

    public Rendu saveRendu(Rendu rendu) {
        rendu.setDateDepot(LocalDateTime.now());
        return renduRepository.save(rendu);
    }

    public List<Rendu> getRendusByApprenant(Long apprenantId) {
        return renduRepository.findByApprenantId(apprenantId);
    }
}

