package com.api.apierrornote.Modele;

import lombok.*;

import javax.persistence.*;
import java.util.Date;


@Entity
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Commentaire {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date date = new Date();
    private String message;

    //gestion de migration des cles
    @ManyToOne
    @JoinColumn(name = "user")
    private User user;


    @ManyToOne
    private Solution solution;

}
