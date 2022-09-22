package com.crowdfunding.projet.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Investissement implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_investissement", nullable = false)
    private Long idInvestissement;

    @Column(nullable = false)
    private Double sommeInvesti;

    @Column(nullable = false)
    private Double montantGain;

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateInvestissement;

//    @Column(nullable = false)
//    private int etapeCreation;

    @ManyToOne
    private Users users;

    @ManyToOne
    private Projet projetInvesti;

//    @ManyToOne
//    private ModePaiement modePaiement;

}
