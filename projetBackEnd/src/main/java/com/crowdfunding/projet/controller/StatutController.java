package com.crowdfunding.projet.controller;

import com.crowdfunding.projet.entity.Projet;
// import com.crowdfunding.projet.entity.Projet;
import com.crowdfunding.projet.entity.Statut;
import com.crowdfunding.projet.repository.ProjetRepository;
import com.crowdfunding.projet.repository.StatutRepository;
import com.crowdfunding.projet.service.StatutService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
public class StatutController {
    
    @Autowired
    StatutService statutService;
    
    //Listes projets
    @GetMapping("/statut")
     public List<Statut> getListStatut() {
        return statutService.getListProjet();
    }

    @GetMapping("/onestatut")
    public Statut getOneStatut(@RequestBody String typeStatut){
        return statutService.oneStatut(typeStatut);
    }

}
