package com.api.apierrornote.Repository;

import com.api.apierrornote.Modele.Solution;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SolutionRepo extends JpaRepository<Solution, Long> {
}
