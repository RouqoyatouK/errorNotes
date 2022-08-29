package com.api.apierrornote.Repository;


import com.api.apierrornote.Modele.Probleme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProblemeRepo extends JpaRepository<Probleme, Long> {

    @Query(value = "insert into solution(probleme) values(?)", nativeQuery = true)
            public Long InsertId(Long probleme);



    // Trouver le problème par le titre
    Probleme findByTitre(String titre);
}
