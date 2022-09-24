package com.crowdfunding.projet.controller;


import com.crowdfunding.projet.entity.Investissement;
import com.crowdfunding.projet.repository.InvestissementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
@RequestMapping("/investissement")
public class InvestissementController {

    @Autowired
    InvestissementRepository investissementRepository;
    @GetMapping("/investissementuser/{id}")
    public List<Investissement> getInvestissementByIdUser(@PathVariable("id") Long id) {
        return investissementRepository.listInvestissementId(id);
    }
}

