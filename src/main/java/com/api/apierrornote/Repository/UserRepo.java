package com.api.apierrornote.Repository;

import com.api.apierrornote.Modele.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {

    //Requête qui permet d'indiquer a l'etat qu'il doit inserer son id au niveau dans la table problème

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO probleme(user_id_user) values(?) ", nativeQuery = true)
    public Long InsertId(Long user_id_user);

    User findByPassword(String mdp);

    User findByEmail(String email);

}
