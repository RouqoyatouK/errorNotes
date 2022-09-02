package com.api.apierrornote.Service;

import com.api.apierrornote.Modele.Probleme;

import java.util.List;
import java.util.Optional;

public interface ProblemeService {

    //creer un bloblème
    Probleme creer(Probleme probleme);

    //Modifier problème
    Probleme Modifier(Long id, Probleme blem );


    Probleme TrouverParTitre(String titre);

    //methode de recherche de probleme par mot cle
    List<Probleme> RechercherDescription(String motcle);

    //methode pour modifier un probleme


    //methode pour afficher la liste des problemes
    Iterable<Object[]> listeProbleme();

}
