package com.api.apierrornote.Repository;


import com.api.apierrornote.Modele.Probleme;
import com.api.apierrornote.Modele.Solution;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProblemeRepo extends JpaRepository<Probleme, Long> {

    //retourne le probleme correspondant à idProbleme
    Probleme findByIdProbleme(Long idProbleme);

    @Query(value = "insert into solution(probleme) values(?)", nativeQuery = true)
            public Long InsertId(Long probleme);



    //Trouver le problème par le titre
    Probleme findByTitre(String titre);

    //Requete permettant de faire la recherche par mot cle
    @Query(value = "select * from probleme, user where probleme.description like %?%", nativeQuery = true)
    List<Probleme> RechercherDescription(String motcle);

    //Requete permettant d'afficher la liste de probleme
    @Query(value = "select probleme.titre, probleme.description, probleme.technologie, probleme.date, etat.libelle, user.nom, user.prenom, user.email from probleme, etat, user where probleme.etat = etat.id_etat and probleme.user = user.id_user", nativeQuery = true)
    Iterable<Object[]> listeProbleme();
}
