package com.api.apierrornote.Service;

import com.api.apierrornote.Modele.Probleme;
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
    public Probleme Modifier(Long id, Probleme blem) {
        return problemerepo.findById(id).map(p->{
            if (blem.getTitre()!=null)
                p.setTitre(blem.getTitre());
            if (blem.getDescription()!=null)
                p.setDescription(blem.getDescription());
            if (blem.getTechnologie()!=null)
                p.setTechnologie(blem.getTechnologie());
            if (blem.getEtat()!=null)
                p.setEtat(blem.getEtat());

            return problemerepo.save(p);
        }).orElseThrow(()-> new RuntimeException("Le Problème n'a pas été trouver"));
    }

    //Modifier le problème


    @Override
    public Probleme TrouverParTitre(String titre) {
        return problemerepo.findByTitre(titre);
    }

    //implementation de la methode permettant de faire la recherche par mot cle
    @Override
    public Object rechercherParMotCle(String motcle) {
        List<Probleme> resultat;
        resultat = problemerepo.RechercherDescription(motcle);
        if (resultat.size() == 0) return "Aucun resultat trouvé pour votre recherche";
        else return resultat;
    }


    //implementation de la methode permettant d'afficher la liste des problemes'
    @Override
    public Iterable<Object[]> listeProbleme() {
        return problemerepo.listeProbleme();
    }

}
