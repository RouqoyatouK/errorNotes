package com.api.apierrornote.Service;

import com.api.apierrornote.Modele.Etat;
import com.api.apierrornote.Modele.User;

public interface EtatService {
    //creer un etat
    Etat creer (Etat etat);

    //jai modif
    Etat TrouverParLibelle(String libelle);


}
