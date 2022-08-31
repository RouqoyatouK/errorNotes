package com.api.apierrornote.Controller;

import com.api.apierrornote.Modele.Etat;
import com.api.apierrornote.Modele.Probleme;
import com.api.apierrornote.Modele.Solution;
import com.api.apierrornote.Modele.User;
import com.api.apierrornote.Repository.EtatRepo;
import com.api.apierrornote.Repository.ProblemeRepo;
import com.api.apierrornote.Service.ProblemeService;
import com.api.apierrornote.Service.SolutionService;
import com.api.apierrornote.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/solution")
public class SolutionController {

    @Autowired
    ProblemeService problemeservice;
    @Autowired
    SolutionService solutionservice;
    @Autowired
    UserService userservice;

    @Autowired
   ProblemeRepo problemeRepo;

    @Autowired
    EtatRepo etatRepo;


    @PostMapping("/create/{email}/{password}/{idProbleme}")
    public String creation(@RequestBody Solution solution, @PathVariable(value = "email") String email, @PathVariable("password") String password, @PathVariable Long idProbleme) {

        User a = userservice.TrouverParEmail(email);
       // Probleme b = problemeservice.TrouverParTitre(titre);
          // recupere le probleme a travers son id pour connaitre l'id de lutilisateur
        Probleme blm = problemeRepo.findByIdProbleme(idProbleme);
        //Etat et = etatRepo.findByIdEtat(idProbleme);

        String ett = "Fermer";




        if (a == null) {
            return "le mail n'existe pas";
        } else if (!a.getPassword().equals(password)) {
            return "Password incorrect";
        } else if (problemeRepo.findByIdProbleme(idProbleme) == null) {//verifie que le probleme existe

            return "le probleme ddesigne n'existe pas!";
        }

        //verifie que l'email dans l'url est le meme que celui qui a creer le probleme
        else if (blm.getUser() != a) return "Vous n'êtes pas autoriser a apporter une solution a ce problème !";

        else if(blm.getEtat().getLibelle().equals(ett)) return "etat fermer";// si etat est fermer pas de solution
        else {

            //attribue le probleme à la solution
            solution.setProbleme(problemeRepo.findByIdProbleme(idProbleme));
            //enregistrement du probleme
            this.solutionservice.creer(solution);
            return "Solution envoyée";

        }
    }
    @GetMapping("/liste")
    public Iterable<Object[]> listeSolution() {
        return solutionservice.listeSolution();
    }

}






