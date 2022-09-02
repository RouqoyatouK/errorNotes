package com.api.apierrornote.Service;

import com.api.apierrornote.Modele.Probleme;
import com.api.apierrornote.Modele.Solution;
import com.api.apierrornote.Repository.SolutionRepo;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class SolutionServiceImpl implements SolutionService {

    @Autowired
    SolutionRepo solutionrepo;


    @Override
    public Solution creer(Solution solution) {
        return solutionrepo.save(solution);
    }

    //implementation de la methode pour afficher la liste des solutions
    @Override
    public Iterable<Object[]> listeSolution() {
        return solutionrepo.listeSolution();
    }

   /* @Override
    public String UniqueSolution() {
        return solutionrepo.AfficherUneSolution();
    }*/


}
