package com.api.apierrornote.Service;

import com.api.apierrornote.Modele.Probleme;

public interface ProblemeService {

    //creer un bloblème
    Probleme creer(Probleme probleme);

    //methode permettant de trouver le probleme avec le titre
    Probleme TrouverParTitre(String titre);
}
