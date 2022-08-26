package com.api.apierrornote.Repository;

import com.api.apierrornote.Modele.Etat;
import com.api.apierrornote.Modele.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface EtatRepo extends JpaRepository<Etat, Long> {

    //jai modif
    Etat findByLibelle(String libelle);


}
