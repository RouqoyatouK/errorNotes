package com.api.apierrornote.Service;

import com.api.apierrornote.Modele.Commentaire;

public interface CommentaireService {

    //methode pour creer notre commentaire
    Commentaire creer(Commentaire commentaire);

    //methode pour afficher la liste des commentaire
    Iterable<Object[]> listeCommentaire();
}
