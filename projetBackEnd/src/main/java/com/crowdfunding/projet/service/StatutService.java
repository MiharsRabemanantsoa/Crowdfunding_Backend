package com.crowdfunding.projet.service;

import com.crowdfunding.projet.entity.Projet;
import com.crowdfunding.projet.entity.Statut;
import com.crowdfunding.projet.repository.StatutRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StatutService {
    @Autowired
    private StatutRepository statutRepository;
    //appel de tous les projets

    public List<Statut> getListProjet() {
        return (List<Statut>) statutRepository.findAll();
    }

    public Statut oneStatut(String typeStatut){return statutRepository.findStatutByTypeStatut(typeStatut);}

    
}
