package com.api.apierrornote.Controller;


import com.api.apierrornote.Modele.User;
import com.api.apierrornote.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userservice;



    //methode qui prend l'url pour creer un user
    @PostMapping("/create")
    public User create (@RequestBody User user){ //prend un user en format Json et @RequestBody veut dire que la valeur doit être au niveau du corps
         return userservice.creer(user);
    }


    //Creer un admin a travers le superAdmin
    @PostMapping("/create/{email}/{mdp}/{role}")
    public Object creationAdmin(@RequestBody User userAdmin, @PathVariable(value = "role") String role, @PathVariable(value = "email") String email, @PathVariable(value = "mdp") String password){
        User userAdm = userservice.TrouverParEmail(email); //recuperer l'email dans l'url


        String vari = "User";
        if (userAdm == null){ return "Email incorrect!";}
        else if (!userAdm.getPassword().equals(password)) {return "Mot de passe incorrect!";}

       else if (!userAdm.getRole().equals(role) || userAdm.getRole().equals(vari)){
           /*si le role correspondant au l'email est pareil a celui dans l'url ou
            si le rôle correspondant à l'email = User
            */
            return "Vous n'êtes pas autoriser a creer un admin";
        } else{
           userAdmin.setRole("Admin");
           return  userservice.creer(userAdmin);

        }







    }



    }
