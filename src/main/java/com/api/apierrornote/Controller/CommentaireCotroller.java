package com.api.apierrornote.Controller;

import com.api.apierrornote.Modele.Commentaire;
import com.api.apierrornote.Modele.Probleme;
import com.api.apierrornote.Modele.Solution;
import com.api.apierrornote.Modele.User;
import com.api.apierrornote.Service.CommentaireService;
import com.api.apierrornote.Service.ProblemeService;
import com.api.apierrornote.Service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/commentaire")
public class CommentaireCotroller {


    @Autowired
    CommentaireService commentaireservice;
    UserService userservice;




    @PostMapping("/create/{email}/{password}")
    public String create(@RequestBody Commentaire commentaire, Solution solution, @PathVariable String email, @PathVariable String password) {

        //Authentification de l'utilisateur
        User us = userservice.TrouverParEmail(email);

        //verification de l'email et du mot de passe saisie à l'url
        if (us == null) return "email incorrect!";
        else if (!us.getPassword().equals(password)) return "Mot de passe incorrect!";
        else {
            commentaire.setUser(us);
            //commentaire.setSolution(us);
            this.commentaireservice.creer(commentaire);

            return "Les donnes bien enregistre";
        }
    }
    @GetMapping("/liste")
    public Iterable<Object[]> listeCommentaire() {
        return commentaireservice.listeCommentaire();
    }
}
