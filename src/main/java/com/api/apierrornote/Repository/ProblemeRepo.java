package com.api.apierrornote.Repository;


import com.api.apierrornote.Modele.Probleme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProblemeRepo extends JpaRepository<Probleme, Long> {
}
