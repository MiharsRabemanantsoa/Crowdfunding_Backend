package com.crowdfunding.projet.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Calendar;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ModePaiement implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_modepaiement", nullable = false)
    private Long id_modepaiement;

    @Column(nullable = false,length = 10)
    private String type;

    @Column
    private String nomProprietaireCarte;

    @Column(length = 25)
    private double numeroCarte;

    @Temporal(TemporalType.DATE)
    @Column(columnDefinition = "DATE")
    private Calendar dateExpirationDate;

    @Column
    private int cvvCarte;



}
