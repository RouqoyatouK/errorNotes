package com.api.apierrornote.Controller;

import com.api.apierrornote.Modele.Probleme;
import com.api.apierrornote.Modele.Solution;
import com.api.apierrornote.Modele.User;
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


    @PostMapping("/create/{email}/{password}/{titre}")
    public String creation(@RequestBody Solution solution, @PathVariable(value = "email") String email, @PathVariable("password") String password, @PathVariable(value = "titre") String titre) {

        User a = userservice.TrouverParEmail(email);
        Probleme b = problemeservice.TrouverParTitre(titre);

        if (a == null) {
            return "le mail n'existe pas";
        } else if (!a.getPassword().equals(password)) {
            return "Password incorrect";
        } else if (b == null) {

            return "le probleme ddesigne n'existe pas!";
        } else {

            solution.setProbleme(b);
            this.solutionservice.creer(solution);
            return "Solution envoyée";

        }
    }

}






