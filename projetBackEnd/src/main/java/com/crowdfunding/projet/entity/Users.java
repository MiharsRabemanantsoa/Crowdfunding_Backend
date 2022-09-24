package com.crowdfunding.projet.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.nio.file.Paths;
import java.util.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Users implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user", nullable = false)
    private Long idUser;

    @Column(nullable = false, length = 50)
    private String nom;

    @Column(nullable = false, length = 50)
    private String prenom;

    @Column(nullable = false, length = 50, unique = true)
    private String email;

    @NotBlank
    @Column(nullable = false)
    private String motDePasse;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Calendar dateNaissance;

    @Column(nullable = true, length = 150)
    private String adresse;

    @Column(nullable = true, length = 30)
    private String ville;

    @Column(nullable = true, length = 20)
    private String Pays;

    @Column(nullable = true)
    private String photoProfil;

    @Column(nullable = true)
    private String cinRecto;

    @Column(nullable = true)
    private String cinVerso;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(updatable=false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateInscription;

    @Column
    private boolean isLogedIn = false;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(	name = "user_roles",
            joinColumns = @JoinColumn(name = "id_user"),
            inverseJoinColumns = @JoinColumn(name = "id_role"))
    private Set<Role> roles = new HashSet<>();

//    @OneToOne
//    private Role role;

//    @OneToMany(mappedBy = "users")
//    private List<Investissement> investissementList;

    @OneToMany(mappedBy = "users")
    private List<ProjetSuivi> projetSuivis;

    public Users(String nom, String prenom, String email, String password) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.motDePasse = password;
    }
}
