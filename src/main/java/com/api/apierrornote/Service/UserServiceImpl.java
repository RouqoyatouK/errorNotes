package com.api.apierrornote.Service;

import com.api.apierrornote.Modele.User;
import com.api.apierrornote.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepo userrepo;

    //implementation de la methode qui permet de d'enregistrer un utilisateur
    @Override
    public User creer(User user) {

        return userrepo.save(user);
    }

    // methode d'implementation de UserService pour trouver l'utilisateur par l'email

    @Override
    public User TrouverParEmail(String email) {

        return userrepo.findByEmail(email);
    }

    //j'ai fait
    @Override
    public User TrouverParPassword(String password) {

        return userrepo.findByPassword(password);
    }


    // methode d'implementation de UserService pour trouver l'utilisateur par le password


}
