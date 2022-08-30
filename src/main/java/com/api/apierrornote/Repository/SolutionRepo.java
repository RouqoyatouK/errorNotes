package com.api.apierrornote.Repository;

import com.api.apierrornote.Modele.Solution;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface SolutionRepo extends JpaRepository<Solution, Long> {


    //Requete permettant d'afficher la liste de probleme
    @Query(value = "select probleme.titre, solution.description_solution, solution.ressources, solution.recherche, solution.temps_consacre, user.nom, user.prenom, user.email from probleme, solution, user where solution.probleme = probleme.id_probleme and probleme.user = user.id_user", nativeQuery = true)
    Iterable<Object[]> listeSolution();

}
