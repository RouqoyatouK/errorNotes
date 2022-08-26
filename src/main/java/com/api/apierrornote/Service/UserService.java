package com.api.apierrornote.Service;

import com.api.apierrornote.Modele.User;

import java.util.List;

public interface UserService {

    //methode qui permet de creer un l'utilisateur
    User creer(User user);

    //methode
    User TrouverParEmail(String email);
    User TrouverParMdp(String mdp);

}
