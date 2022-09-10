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
}
