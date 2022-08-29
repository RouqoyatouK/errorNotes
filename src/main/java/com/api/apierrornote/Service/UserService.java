package com.api.apierrornote.Service;

import com.api.apierrornote.Modele.User;

import java.util.List;

public interface UserService {

    //methode qui permet de creer un l'utilisateur
    User creer(User user);

    //methode permetant de retrouver un utilisateur par email et password ils
    // seront utiliser dans le UserServiceImpl avec comme retour la reqête defini dans le repot
    User TrouverParEmail(String email);
    //User TrouverParPassword(String password);

    //User TrouverParEmailEtMdp(String email, String password);
}
