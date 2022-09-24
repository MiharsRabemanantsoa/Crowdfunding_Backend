package com.crowdfunding.projet.controller;

import com.crowdfunding.projet.entity.Projet;
import com.crowdfunding.projet.repository.ProjetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
@RequestMapping("/home")
public class ProjetPopulaireController {
    @Autowired
    private ProjetRepository projetRepository;

    @GetMapping("/projetpop")
    public List<Projet> getPopulaireProjet(){
        return projetRepository.listAll();
    }


}
