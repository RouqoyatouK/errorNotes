package com.api.apierrornote.Repository;

import com.api.apierrornote.Modele.Commentaire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CommentaireRepo extends JpaRepository<Commentaire, Long> {


}
