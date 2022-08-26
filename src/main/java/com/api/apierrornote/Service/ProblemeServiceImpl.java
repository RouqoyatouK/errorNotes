package com.api.apierrornote.Service;

import com.api.apierrornote.Modele.Probleme;
import com.api.apierrornote.Repository.ProblemeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProblemeServiceImpl implements ProblemeService {
    @Autowired
    ProblemeRepo problemerepo;


    //implementation de la methode qui permet de creer un probleme
    @Override
    public Probleme creer(Probleme probleme) {
        return problemerepo.save(probleme);
    }
}
