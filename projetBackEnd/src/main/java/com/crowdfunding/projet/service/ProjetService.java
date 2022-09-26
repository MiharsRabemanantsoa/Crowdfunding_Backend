package com.crowdfunding.projet.service;

import com.crowdfunding.projet.entity.Projet;
import com.crowdfunding.projet.repository.ProjetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjetService {
    @Autowired
    private ProjetRepository projetRepository;

    //appel de tous les projets
    public List<Projet> listAll(){
        return projetRepository.findAll();
    }

    //find project by id
    public  Projet oneProject(Long id){return projetRepository.findProjectByIdProjet(id);}

    //find project by id and show the number of participant
    public Object projectWithParticipant(Long id){return projetRepository.findOneProject(id);}

    //save one project
    public void save(Projet projet){projetRepository.save(projet);}

    //afficher tous les projets en attente de validation
    public  List<Projet> getProjetEnAttenteValidation(){return projetRepository.projetEnAttente();}

    //count the number of project
    public int nombreProjet(){return projetRepository.nombreProjet();}

    //count the number of user that created a project
    public int nombrePorteurProjet(){return projetRepository.nombrePorteurProjet();}
}
