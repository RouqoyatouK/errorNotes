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

@RestController
@AllArgsConstructor
@RequestMapping("/probleme")
public class ProblemeController {

    @Autowired
    ProblemeService problemeservice;

    UserService userservice;
    EtatService etatservice;

    @PostMapping("/create/{email}/{password}")
    public String create(@RequestBody Probleme probleme, @PathVariable String email, @PathVariable String password){

        //instanciation de User en user et user1 pour recuperer l'email et le mot de pass
        User user = userservice.TrouverParEmail(email);
        User user1 = userservice.TrouverParPassword(password);
      //  Etat etat = etatservice.TrouverParLibelle(libelle);


        if (userservice.TrouverParEmail(user.getEmail()) == null){


            return "Email N'EXISTE pas ou password erroné";

        }
        else{

            // A la table probleme on affecte la valeur recuperer dans user1 et user
             probleme.setUser(user);
             probleme.setUser(user1);
            // probleme.setEtat(etat);

            //
             this.problemeservice.creer(probleme);

             return "Les donnes bien enregistre";
        }



    }
}
