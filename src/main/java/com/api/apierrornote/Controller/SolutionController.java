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

import static org.apache.coyote.http11.Constants.a;

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
        // Probleme blm = problemeRepo.findByIdProbleme(idProbleme);
        Probleme blm = problemeRepo.findByIdProbleme(idProbleme);

        //Etat et = etatRepo.findByIdEtat(idProbleme);

        String ett = "Fermer";

        if (a == null || a.getPassword().equals(password)) return "Erreur avec le mail ou le password";

        else if (problemeRepo.findByIdProbleme(idProbleme) == null) return "Le probleme designer n'existe pas";
        else if (idProbleme != null) return "la solution existe deja";
        else if (blm.getEtat().getLibelle().equals(ett)) return "etat fermer";
        else {
            solution.setProbleme(problemeRepo.findByIdProbleme(idProbleme));
            this.solutionservice.creer((solution));
            return "Solution envoyés";
        }
    }



    @GetMapping("/liste")
    public Iterable<Object[]> listeSolution() {
        return solutionservice.listeSolution();
    }





}






