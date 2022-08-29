package com.api.apierrornote.Controller;

import com.api.apierrornote.Modele.Etat;
import com.api.apierrornote.Modele.Probleme;
import com.api.apierrornote.Modele.User;
import com.api.apierrornote.Service.EtatService;
import com.api.apierrornote.Service.ProblemeService;
import com.api.apierrornote.Service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@AllArgsConstructor
@RequestMapping("/probleme")
public class ProblemeController {

    @Autowired
    ProblemeService problemeservice;

    @Autowired
    UserService userservice;

    @Autowired
    EtatService etatservice;

    @PostMapping("/create/{email}/{password}/{libelle}")
    public String create(@RequestBody Probleme probleme, @PathVariable String libelle, @PathVariable String email, @PathVariable String password){

        //instanciation de User en user et user1 pour recuperer l'email et le mot de pass
        User user = userservice.TrouverParEmail(email);
        //User user1 = userservice.TrouverParPassword(password);
        //User user=userservice.TrouverParEmailEtMdp(email,password);

        Etat etat = etatservice.TrouverParLibelle(libelle);

        System.out.println(user.getPassword());
        System.out.println(password);

        if (user == null) return "Email incorrect!";
        else if (!user.getPassword().equals(password)) return "Mot de passe incorrect!";
        /*recupère le password de l'email
        qu'il a saisie et verifie s'il est egale au password saisie en url*/
        else {


                // A la table probleme on affecte la valeur recuperer dans user1 et user
                probleme.setUser(user);
                probleme.setEtat(etat);


                this.problemeservice.creer(probleme);

                return "Les donnes bien enregistre";
            }

        }




    }

