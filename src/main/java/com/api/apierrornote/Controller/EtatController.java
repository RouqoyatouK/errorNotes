package com.api.apierrornote.Controller;


import com.api.apierrornote.Modele.Etat;
import com.api.apierrornote.Service.EtatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/etat")
public class EtatController {

    @Autowired
    EtatService etatservice;

    //methode qui prend l'url pour creer un etat
    @PostMapping("/create")
    public Etat create (@RequestBody Etat etat){
        return etatservice.creer(etat);
    }
}
