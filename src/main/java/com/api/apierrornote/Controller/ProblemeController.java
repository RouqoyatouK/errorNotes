package com.api.apierrornote.Controller;

import com.api.apierrornote.Modele.Etat;
import com.api.apierrornote.Modele.Probleme;
import com.api.apierrornote.Modele.User;
import com.api.apierrornote.Service.ProblemeService;
import com.api.apierrornote.Service.UserService;
import lombok.AllArgsConstructor;
import org.aspectj.weaver.ast.And;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/probleme")
public class ProblemeController {

    @Autowired
    ProblemeService problemeservice;

    UserService userservice;

    @PostMapping("/create/{email}")
    public String create(@RequestBody Probleme probleme, Etat etat , @PathVariable String email){
        User user = userservice.TrouverParEmail(email);

        if (user == null ){
            return "EMAIL N'EXISTE ÄS";
        }
        else{
             probleme.setUser(user);
             this.problemeservice.creer(probleme);
             return "Les donnes bien enregistre";
        }



    }
}
