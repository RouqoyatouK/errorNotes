package com.api.apierrornote.Modele;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Solution {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idSolution;
    private String descriptionSolution;
    private String tempsConsacre;
    private String ressources;
    private String recherche;
    private Date date = new Date();

    @OneToOne
    @JoinColumn (name = "probleme")
    private Probleme probleme;


    @OneToMany(mappedBy = "solution")
    private List<Commentaire> commentaire;

}
