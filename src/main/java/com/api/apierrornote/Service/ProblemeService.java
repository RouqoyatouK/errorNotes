package com.api.apierrornote.Service;

import com.api.apierrornote.Modele.Probleme;

public interface ProblemeService {

    //creer un bloblème
    Probleme creer(Probleme probleme);

    Probleme TrouverParTitre(String titre);
}
