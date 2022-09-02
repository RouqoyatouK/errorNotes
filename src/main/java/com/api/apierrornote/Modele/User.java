package com.api.apierrornote.Modele;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {

    //Definition de tout nos attribut

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUser;

    @Column(length = 50, nullable = false)
    private String nom;
    @Column(length = 50, nullable = false)
    private String prenom;

    @Column(length = 50, unique = true)
    private String email;

    @Column(length = 50, nullable = false)
    private String password;
    private Date date = new Date();

    //quand on creer le user il est authaumatiquement le rôle  User
    private String role = new String("User");

}