package com.enaa_skills.apprenant_service.service;

import com.enaa_skills.apprenant_service.entity.Apprenant;
import com.enaa_skills.apprenant_service.repository.ApprenantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ApprenantService {

    @Autowired
    private ApprenantRepository apprenantRepository;

    public Apprenant inscrire(Apprenant apprenant) {
        return apprenantRepository.save(apprenant);
    }

    public List<Apprenant> getAll() {
        return apprenantRepository.findAll();
    }

    public Optional<Apprenant> getById(Long id) {
        return apprenantRepository.findById(id);
    }
}

