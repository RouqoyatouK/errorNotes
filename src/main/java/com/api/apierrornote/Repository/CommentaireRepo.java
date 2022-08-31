package com.api.apierrornote.Repository;

import com.api.apierrornote.Modele.Commentaire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CommentaireRepo extends JpaRepository<Commentaire, Long> {

    //Requete permettant d'afficher la liste de commentaires
    @Query(value = "select solution.description_solution, commentaire.message, commentaire.date, user.nom, user.prenom from commentaire, solution, user where commentaire.solution = solution.id_solution and commentaire.user = user.id_user", nativeQuery = true)
    Iterable<Object[]> listeCommentaire();
}
