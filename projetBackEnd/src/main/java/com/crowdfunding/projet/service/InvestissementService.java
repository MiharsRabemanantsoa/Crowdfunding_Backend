package com.crowdfunding.projet.service;

import com.crowdfunding.projet.entity.Investissement;
import com.crowdfunding.projet.repository.InvestissementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InvestissementService {
    @Autowired
    InvestissementRepository investissementRepository;

    //enregistrer un nouveau investissement
    public void enregisterInvest(Investissement investissement){
        investissementRepository.save(investissement);
    }
}
