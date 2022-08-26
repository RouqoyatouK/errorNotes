package com.api.apierrornote.Service;

import com.api.apierrornote.Modele.Etat;
import com.api.apierrornote.Modele.User;
import com.api.apierrornote.Repository.EtatRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EtatServiceImpl implements EtatService {

    @Autowired
    EtatRepo etatrepo;

    @Override
    public Etat creer(Etat etat) {
        return etatrepo.save(etat);
    }

    @Override
    public Etat TrouverParLibelle(String libelle) {
        return etatrepo.findByLibelle(libelle);
    }


}


