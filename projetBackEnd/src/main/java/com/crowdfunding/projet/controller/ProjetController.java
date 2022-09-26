package com.crowdfunding.projet.controller;

import com.crowdfunding.projet.entity.Notification;
import com.crowdfunding.projet.entity.Projet;
import com.crowdfunding.projet.repository.NotificationRepository;
import com.crowdfunding.projet.repository.ProjetRepository;
import com.crowdfunding.projet.repository.UserRepository;
import com.crowdfunding.projet.service.ProjetService;

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


import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.List;

@CrossOrigin(origins = {"http://localhost:3000/"})
@RestController
@RequestMapping("/api/test")
public class ProjetController {
    @Autowired
    private ProjetService projetService;
    @Autowired
    private ProjetRepository projetRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    NotificationRepository notificationRepository;

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

    @GetMapping("/unprojet/{id}")
    public Projet getSimpleOne(@PathVariable("id") Long id){return projetService.oneProject(id);
    }

    //changing statut of a project and modify the status
    @PutMapping("/projet/updateStatut")
    public Notification updateStatutProjet(@RequestBody Projet projet){
        Projet projetUpdated = projetService.oneProject(projet.getIdProjet());

        projetUpdated.setStatut(projet.getStatut());

        //creating notifications for each status changes
        Notification notification = new Notification();
        notification.setDaterecu(Calendar.getInstance());
        notification.setUserNotif(userRepository.findByEmail(projetUpdated.getUser().getEmail()));
        notification.setProjet(projetUpdated);
        notification.setRead(false);
        switch (projetUpdated.getStatut().getTypeStatut()){
            case "fermé":
                notification.setCorps("Bonjour. Votre campagne qui porte le titre de "+projetUpdated.getTitre()+" a atteint sa date butoir. Nous vous contacterons par email pour le virement de votre collecte.");
                break;
            case "en attente":
                notification.setCorps("Bonjour. Votre campagne qui porte le titre de "+projetUpdated.getTitre()+" est en attente de validation. Vous recevrez une notification une fois le processus de validation des projets est terminé.");
                break;
            case "validé":
                notification.setCorps("Bonjour. Votre campagne qui porte le titre de "+projetUpdated.getTitre()+" a été validée par l'équipe de LooP. Il est désormais disponnible sur la plateforme. Effectuez la première investissement pour encourager les autres.");
                projetUpdated.setDateMiseEnLigne(Calendar.getInstance());
                break;
            case "supprimé":
                notification.setCorps("Bonjour. Votre campagne qui porte le titre de "+projetUpdated.getTitre()+" a été refusée par l'équipe de LooP. Révisez votre campagne et fournissez les documents et explications nécessaires sur votre projet pour le valider.");
                break;
            default: break;
        }

        //save changes
        projetRepository.save(projetUpdated);
        notificationRepository.save(notification);
        return notification;
    }

    //afficher tous les projets en attente de validation
    @GetMapping("/admin/avalider")
    public  List<Projet> projetEnAttente(){
        return projetRepository.projetEnAttente();
    }

    @GetMapping("/admin/dash")
    public int projectNumber(){
        return projetService.nombreProjet();
    }

    @GetMapping("/admin/nombrePorteurProjet")
    public int porteurProjetNombre(){
        return projetRepository.nombrePorteurProjet();
    }

    @PostMapping("/newprojet")
    public Projet newProjet(@RequestBody Projet projet){
        projetService.save(projet);
        return projet;
    }
}
