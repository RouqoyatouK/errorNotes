package com.api.apierrornote.Repository;

import com.api.apierrornote.Modele.Commentaire;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentaireRepo extends JpaRepository<Commentaire, Long> {
}
