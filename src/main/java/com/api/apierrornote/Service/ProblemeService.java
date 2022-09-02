package com.api.apierrornote.Service;

import com.api.apierrornote.Modele.Probleme;

public interface ProblemeService {

    //creer un bloblème
    Probleme creer(Probleme probleme);

    //Modifier problème
    Probleme Modifier(Long id, Probleme blem );


    Probleme TrouverParTitre(String titre);

    public Object rechercherParMotCle(String motcle);

    //methode de recherche de probleme par mot cle
    //String RechercherDescription(String motcle);

    //methode pour modifier un probleme


    //methode pour afficher la liste des problemes
    Iterable<Object[]> listeProbleme();

}
