package com.crowdfunding.projet.controller;

import com.crowdfunding.projet.dto.CreatePayment;
import com.crowdfunding.projet.dto.CreatePaymentResponse;
import com.crowdfunding.projet.dto.PaymentRequest;
import com.crowdfunding.projet.dto.StripeClient;
import com.crowdfunding.projet.entity.Investissement;
import com.crowdfunding.projet.entity.Projet;
import com.crowdfunding.projet.entity.Users;
import com.crowdfunding.projet.service.InvestissementService;
import com.crowdfunding.projet.service.PaymentService;
import com.crowdfunding.projet.service.ProjetService;
import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.Charge;
import com.stripe.model.Customer;
import org.hibernate.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/loop/invest")
public class InvestissementController {

    @Autowired
    InvestissementService investissementService;

    private StripeClient stripeClient;

    @Autowired
    ProjetService projetService;

    @Autowired
    InvestissementController(StripeClient stripeClient) {
        this.stripeClient = stripeClient;
    }

    //paiement dans stripe
    @PostMapping("/charge")
    public Charge chargeCard(@RequestHeader(value="token") String token, @RequestHeader(value="amount") Double amount) throws Exception {
        System.out.println(token);
        System.out.println(amount);
        return this.stripeClient.chargeNewCard(token, amount);
    }

    @PostMapping("/saveInvest")
    public void newInvest(@RequestBody  Investissement investissement){
        investissementService.enregisterInvest(investissement);
        Projet projet = projetService.oneProject(investissement.getProjetInvesti().getIdProjet());
        Double somme = investissement.getSommeInvesti()+projet.getSommeCollecte();

        //mise à jour de la somme collectée
        projet.setSommeCollecte(somme);
        projetService.save(projet);
    }

    @GetMapping("/admin/nombreInvestisseur")
    public int investisseurNumber(){
        return investissementService.nombreInvestisseur();

    
    @Autowired
    InvestissementRepository investissementRepository;
    @GetMapping("/investissementuser/{id}")
    public List<Investissement> getInvestissementByIdUser(@PathVariable("id") Long id) {
        return investissementRepository.listInvestissementId(id);
    }

    //comptage somme investissement dans le site
    @GetMapping("/comptageInvestissement")
    public Long getSommeInvestissement(Long id_investissement){
        return investissementRepository.getSommeInvestissement(id_investissement);
    }

    @GetMapping("/comptageInvestisseur")
    public Long getSommeInvestisseur(Long id_investissement){
        return investissementRepository.getSommeInvestisseur(id_investissement);
    }
}

