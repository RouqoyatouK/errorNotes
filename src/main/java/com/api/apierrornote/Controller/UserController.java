package com.api.apierrornote.Controller;


import com.api.apierrornote.Modele.User;
import com.api.apierrornote.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userservice;

    //methode qui prend l'url pour creer un user
    @PostMapping("/create")
    public User User (@RequestBody User user){ //prend un user en format Json et @RequestBody veut dire que la valeur doit être au niveau du corps
         return userservice.creer(user);
    }

}
