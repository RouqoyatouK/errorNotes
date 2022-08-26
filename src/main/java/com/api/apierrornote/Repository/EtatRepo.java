package com.api.apierrornote.Repository;

import com.api.apierrornote.Modele.Etat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EtatRepo extends JpaRepository<Etat, Long> {
}
