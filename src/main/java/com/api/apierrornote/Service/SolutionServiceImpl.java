package com.api.apierrornote.Service;

import com.api.apierrornote.Modele.Solution;
import com.api.apierrornote.Repository.SolutionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SolutionServiceImpl implements SolutionService {

    @Autowired
    SolutionRepo solutionrepo;


    @Override
    public Solution creer(Solution solution) {
        return solutionrepo.save(solution);
    }
}
