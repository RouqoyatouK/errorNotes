package com.api.apierrornote.Service;

import com.api.apierrornote.Modele.Solution;

import java.util.List;


public interface SolutionService {

    Solution creer(Solution solution);

    //methode pour afficher la liste des solutions
    Iterable<Object[]> listeSolution();

    //methode pour afficher une solution par rapport a un probleme
    //String UniqueSolution();


}
