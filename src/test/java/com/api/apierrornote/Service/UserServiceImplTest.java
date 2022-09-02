package com.api.apierrornote.Service;

import com.api.apierrornote.Modele.User;
import com.api.apierrornote.Repository.UserRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserServiceImplTest {

    @Autowired
    UserRepo ur;
    @Autowired
    UserService userService;


    @Test
    void creer() {
        User us = new User(7L,"Tiec","Tiec","tiec@gmail.fr","123B",new Date(),"user");
        /*us.setNom("Yng");
        us.setPrenom("Bk");
        us.setEmail("bki@gmail.com");
        us.setPassword("123A");
        us.setDate(new Date());
        us.setRole("user");*/
        userService.creer(us);

        //User usSave = ur.save(us);
        /*assertEquals(us.getIdUser(), us.getIdUser());
        assertEquals(us.getNom(), usSave.getNom());
        assertEquals(us.getPrenom(), usSave.getPrenom());
        assertEquals(us.getEmail(), usSave.getEmail());
        assertEquals(us.getPassword(), usSave.getPassword());
        assertEquals(us.getDate(), us.getDate());
        assertEquals(us.getRole(), us.getRole());*/


    }

    @Test
    void supprimer() {
    }

    @Test
    void trouverParEmail() {
    }
}