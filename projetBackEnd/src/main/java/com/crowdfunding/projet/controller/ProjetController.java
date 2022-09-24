package com.crowdfunding.projet.controller;

import com.crowdfunding.projet.entity.Projet;

import com.crowdfunding.projet.repository.ProjetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.crowdfunding.projet.service.ProjetService;

import org.springframework.web.bind.annotation.*;


import java.util.List;

@CrossOrigin(origins = {"http://localhost:3000/"})
@RestController
@RequestMapping("/api/test")
public class ProjetController {
    @Autowired
    ProjetService projetService;
    @Autowired
    ProjetRepository projetRepository;
    //@GetMapping("/lien" )

    @GetMapping("/projet")
    public List<Projet> getAllProject(){
        System.out.println("mandeveeeee");
        return projetService.listAll();
    }

    //for the page that show details about one project
    @GetMapping("/details/{id}")
    public ResponseEntity<?> getOneProject(@PathVariable("id") Long id){
        return new ResponseEntity<>(projetService.projectWithParticipant(id), HttpStatus.OK);
    }

    //appel les projets de l'user
    @GetMapping("/projetuser/{id}")
    public List<Projet> getProjetByIdUser(@PathVariable ("id") Long id) {
        return projetRepository.listProjetId(id);
    }

    //prend la valeur  de chaque elements de projet
    @GetMapping("/{id}")
    public Projet getProjetByIdDetails(@PathVariable ("id") Long id) {
        return projetService.oneProject(id);
    }

    //save la valeur de chaque element modifier
    @PostMapping("/save")
    public Projet saveProjet(@RequestBody Projet projet) {
        return projetRepository.save(projet);
    }


    //  update projet par id

         @PutMapping("/modifier/{idProjet}")
        public ResponseEntity<Projet> updateProjet(@PathVariable Long idProjet, @RequestBody Projet projetDetails) {
         Projet updateProjet = projetRepository.findProjectByIdProjet(idProjet);

         /*updateProjet.setIdProjet(projetDetails.getIdProjet());*/
         updateProjet.setTitre(projetDetails.getTitre());
         updateProjet.setDescriptionCourte(projetDetails.getDescriptionCourte());
         updateProjet.setImage(projetDetails.getImage());
         updateProjet.setSousTitre1(projetDetails.getSousTitre1());
         updateProjet.setImage1(projetDetails.getImage1());
         updateProjet.setDescriptionLongue1(projetDetails.getDescriptionLongue1());
         updateProjet.setSousTitre2(projetDetails.getSousTitre2());
         updateProjet.setImage2(projetDetails.getImage2());
         updateProjet.setDescriptionLongue2(projetDetails.getDescriptionLongue2());
         updateProjet.setSousTitre3(projetDetails.getSousTitre3());
         updateProjet.setImage3(projetDetails.getImage3());
         updateProjet.setDescriptionLongue3(projetDetails.getDescriptionLongue3());

         projetRepository.save(updateProjet);
         return ResponseEntity.ok(updateProjet);
        }

}
