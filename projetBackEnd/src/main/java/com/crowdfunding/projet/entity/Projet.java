package com.crowdfunding.projet.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;
import org.springframework.format.annotation.DateTimeFormat;
import org.w3c.dom.Text;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Projet implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_projet", nullable = false)
    private Long idProjet;

    @Column(nullable = false)
    private String titre;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String descriptionCourte;

    @Column(nullable = false, length = 30)
    private String localisation;

    @Column(nullable = false)
    private String image;

    @Column(nullable = false)
    private String sousTitre1;

    @Column(nullable = false)
    private String sousTitre2;

    @Column(nullable = false)
    private String SousTitre3;

    @Column(nullable = false)
    private String image1;

    @Column(nullable = false)
    private String image2;

    @Column(nullable = false)
    private String image3;

    @Column(nullable = false)
    private Double sommeObjectif;

    @Column()
    private Double sommeCollecte = 0.0;

    @Column(nullable = false)
    private Double tauxInteret;

    @Temporal(TemporalType.DATE)
    @Column(nullable = false,columnDefinition = "DATE")
    private Calendar lancementSouhaite;

    @Temporal(TemporalType.DATE)
    @Column(nullable = true,columnDefinition = "DATE")
    private Calendar dateMiseEnLigne;

    @Temporal(TemporalType.DATE)
    @Column(nullable = false,columnDefinition = "DATE")
    private Calendar finCampagne;

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date creationCampagne;

    @Column(nullable = false)
    private int echeance;

    @Column(nullable = false)
    private int dureeRemboursement;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String descriptionLongue1;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String descriptionLongue2;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String descriptionLongue3;

    @Temporal(TemporalType.DATE)
    @Column(columnDefinition = "DATE")
    private Calendar debutRemboursement;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String descriptionLongue;

    @Column(nullable = true)
    private String sousTitre1;

    @Column(nullable = true)
    private String sousTitre2;

    @Column(nullable = true)
    private String sousTitre3;

    @Column(nullable = true, columnDefinition = "TEXT")
    private String description1;

    @Column(nullable = true, columnDefinition = "TEXT")
    private String description2;

    @Column(nullable = true, columnDefinition = "TEXT")
    private String description3;

    @Column(nullable = true)
    private String image1;

    @Column(nullable = true)
    private String image2;

    @Column(nullable = true)
    private String image3;

    @Column(nullable = false)
    private int etape_Creation=0;

    @ManyToOne
    private Statut statut;

//    @Cascade(org.hibernate.annotations.CascadeType.MERGE)
    @ManyToOne(cascade = CascadeType.MERGE)
    private Categorie categProjet;

    @ManyToOne
    @JoinColumn(name = "user_id_user")
    private Users user;

//    @OneToMany(mappedBy = "projetInvesti")
//    private List<Investissement> investissementList;

}
