package com.api.apierrornote.Service;

import com.api.apierrornote.Modele.Probleme;
import com.api.apierrornote.Modele.Solution;
import com.api.apierrornote.Repository.ProblemeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProblemeServiceImpl implements ProblemeService {
    @Autowired
    ProblemeRepo problemerepo;


    //implementation de la methode qui permet de creer un probleme
    @Override
    public Probleme creer(Probleme probleme) {
        return problemerepo.save(probleme);
    }

    @Override
    public Probleme TrouverParTitre(String titre) {
        return problemerepo.findByTitre(titre);
    }

    //implementation de la methode permettant de faire la recherche par mot cle
    @Override
    public List<Probleme> RechercherDescription(String motcle) {
        return problemerepo.RechercherDescription(motcle);
    }



}
