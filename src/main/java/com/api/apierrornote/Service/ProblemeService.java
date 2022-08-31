package com.api.apierrornote.Service;

import com.api.apierrornote.Modele.Probleme;
import com.api.apierrornote.Modele.Solution;

import java.util.List;

public interface ProblemeService {

    //creer un bloblème
    Probleme creer(Probleme probleme);


    Probleme TrouverParTitre(String titre);

    //methode de recherche de probleme par mot cle
    List<Probleme> RechercherDescription(String motcle);

    //methode pour afficher la liste des problemes
    Iterable<Object[]> listeProbleme();

}
