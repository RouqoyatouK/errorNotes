package com.api.apierrornote.Service;

import com.api.apierrornote.Modele.Etat;
import com.api.apierrornote.Repository.EtatRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class EtatServiceImplTest {

    @Autowired
    EtatRepo erepo;

    @Autowired
    EtatService etatService;

    @Test
    void creer() {
        Etat etat = new Etat(5L,"Tiec");
        etatService.creer(etat);

    }

    @Test
    void trouverParLibelle() {
    }
}