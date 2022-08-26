package com.api.apierrornote.Modele;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Etat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEtat;
    private String libelle;


}
