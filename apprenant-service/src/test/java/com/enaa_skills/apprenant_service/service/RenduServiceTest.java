package com.enaa_skills.apprenant_service.service;

import com.enaa_skills.apprenant_service.entity.Rendu;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class RenduServiceTest {
    @Autowired
    private RenduService renduService;
    @Test
    void saveRendu() {
        Rendu rendu = new Rendu();
        rendu.setApprenantId(1L);
        rendu.setBriefId(1L);
        rendu.setContenu("contenu");
        rendu.setDateDepot(LocalDateTime.now());
        Rendu save = renduService.saveRendu(rendu);

        assertNotNull(save);
        assertEquals(rendu.getApprenantId(), save.getApprenantId());
        assertEquals(rendu.getBriefId(), save.getBriefId());
        assertEquals(rendu.getContenu(), save.getContenu());
        assertEquals(rendu.getDateDepot(), save.getDateDepot());
    }

    @Test
    void getRendusByApprenant() {
    }
}