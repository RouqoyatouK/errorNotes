package com.api.apierrornote.Service;

import com.api.apierrornote.Modele.User;
import com.api.apierrornote.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepo userrepo;

    //implementation de la methode qui permet de d'enregistrer un utilisateur
    @Override
    public User creer(User user) {
        return userrepo.save(user);
    }
}
