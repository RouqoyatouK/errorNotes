package com.api.apierrornote.Service;

import com.api.apierrornote.Modele.Commentaire;
import com.api.apierrornote.Repository.CommentaireRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentaireServiceImpl implements CommentaireService {
    
    @Autowired
    CommentaireRepo commentairerepo;
    
    @Override
    public Commentaire creer(Commentaire commentaire) {
        return commentairerepo.save(commentaire);
    }
}
