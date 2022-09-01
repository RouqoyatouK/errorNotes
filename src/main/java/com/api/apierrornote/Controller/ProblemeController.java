package com.api.apierrornote.Controller;

import com.api.apierrornote.Modele.Etat;
import com.api.apierrornote.Modele.Probleme;
import com.api.apierrornote.Modele.Solution;
import com.api.apierrornote.Modele.User;
import com.api.apierrornote.Repository.ProblemeRepo;
import com.api.apierrornote.Service.EtatService;
import com.api.apierrornote.Service.ProblemeService;
import com.api.apierrornote.Service.ProblemeServiceImpl;
import com.api.apierrornote.Service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

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
    @Autowired
    ProblemeRepo problemerepo;

    @Autowired
    ProblemeServiceImpl problemeServiceimpl ;

    @PostMapping("/create/{email}/{password}")
    public String create(@RequestBody Probleme probleme, @PathVariable String email, @PathVariable String password){

        //instanciation de User en user et user1 pour recuperer l'email et le mot de pass
        User user = userservice.TrouverParEmail(email);
        //User user1 = userservice.TrouverParPassword(password);
        //User user=userservice.TrouverParEmailEtMdp(email,password);

       // Etat etat = etatservice.TrouverParLibelle(libelle);

        System.out.println(user.getPassword());
        System.out.println(password);

        if (user == null) return "Email incorrect!";
        else if (!user.getPassword().equals(password)) return "Mot de passe incorrect!";
        /*recupère le password de l'email
        qu'il a saisie et verifie s'il est egale au password saisie en url*/
        else {


                // A la table probleme on affecte la valeur recuperer dans user1 et user
                probleme.setUser(user);
                //probleme.setEtat(etat);


                this.problemeservice.creer(probleme);

                return "Les donnes bien enregistre";
            }

        }

        //la gestion de notre fonctionnalite de recherche
        @GetMapping("/rechercher/{motcle}")
        public Object rechercherMotCle(@PathVariable("motcle") String motcle) {
        return problemeServiceimpl.rechercherParMotCle(motcle);
        }
        //Affichage des problemes
         @GetMapping("/liste")
         public Iterable<Object[]> listeProbleme(){
            return problemeservice.listeProbleme();
         }


         //modifier problème
         @PutMapping("/modifier/{email}/{password}/{idProbleme}")
    public String update(@RequestBody Probleme probleme, @PathVariable String email, @PathVariable String password, @PathVariable Long idProbleme){
        //Recuperer le user a travers son mail
        User modif = userservice.TrouverParEmail(email);
        /*Recuperer le probleme a traver idprobleme son but est de connaitre l'id de lutilisateur qui
             correspond a ce probleme afin de le comparer a a l'id de  user recuperer dans modif */
        Probleme promebl = problemerepo.findByIdProbleme(idProbleme);

        //s'il ne trouve pas le mail dans la base
        if (modif == null) return "vous n'êtes pas loger";
        //s'il trouve le mail mais que celui si n'est pas celui de l'utilisateur qui a creer le problème
        else if (promebl.getUser()!=modif){return "Seul celui qui a creer le probleme peut le modifier";}
        else{
            problemeservice.Modifier(idProbleme, probleme);
            //System.out.println("id du probleme "+idProbleme + "jhhjhj "+ probleme.getDescription());
            return "probleme modifier";
        }

         }


    }

