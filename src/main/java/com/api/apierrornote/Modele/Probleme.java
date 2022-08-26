package com.api.apierrornote.Modele;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Probleme {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProbleme;
private  String titre;
private  String description;
private String technologie;

//methode pour migrer la cle primaire de l'etat comme cle secondaire dans probleme
@ManyToOne
    private Etat etat;

//methode pour migrer la cle primaire de user comme cle secondaire dans probleme
@ManyToOne
    private User user;
}
