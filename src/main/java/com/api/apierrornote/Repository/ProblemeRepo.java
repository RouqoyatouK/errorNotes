package com.api.apierrornote.Repository;


import com.api.apierrornote.Modele.Probleme;
import com.api.apierrornote.Modele.Solution;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProblemeRepo extends JpaRepository<Probleme, Long> {

    @Query(value = "insert into solution(probleme) values(?)", nativeQuery = true)
            public Long InsertId(Long probleme);



    // Trouver le problème par le titre
    Probleme findByTitre(String titre);

    //Requete permettant de faire la recherche par mot cle
    @Query(value = "select * from probleme where probleme.description like %?%", nativeQuery = true)
    List<Probleme> RechercherDescription(String motcle);
}
