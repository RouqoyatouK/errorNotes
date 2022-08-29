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
    @Query(value = "INSERT INTO probleme(user) values(?) ", nativeQuery = true)
    public Long InsertId(Long user);



    //requête permetant de retrouver un utilisateur par email et password ils seront utiliser
    // comme retout dans UserserviceImpl

    //jai modif
    //User findByEmailAndPassword(String email,String password); on pouvait aussi l'utiliser
    User findByPassword(String password);

    User findByEmail(String email);

}
