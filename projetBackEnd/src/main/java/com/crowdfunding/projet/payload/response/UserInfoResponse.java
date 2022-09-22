package com.crowdfunding.projet.payload.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;
import java.util.List;

public class UserInfoResponse {
//    private Long id;
//    private String username;
//    private String email;
    private List<String> roles;
    private Long idUser;
    private String nom;
    private String email;
//    private Collection<? extends GrantedAuthority> authorities;
    private String prenom;
    private String photoProfil;

    public UserInfoResponse(Long idUser, String nom, String email, String prenom, List<String> roles) {
        this.idUser = idUser;
        this.nom = nom;
        this.email = email;
        this.roles = roles;
        this.prenom = prenom;
//        this.photoProfil = photoProfil;
    }

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getPhotoProfil() {
        return photoProfil;
    }

    public void setPhotoProfil(String photoProfil) {
        this.photoProfil = photoProfil;
    }
    //    public UserInfoResponse(Long id, String username, String email, List<String> roles) {
//        this.id = id;
//        this.username = username;
//        this.email = email;
//        this.roles = roles;
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public String getUsername() {
//        return username;
//    }
//
//    public void setUsername(String username) {
//        this.username = username;
//    }
//
//    public List<String> getRoles() {
//        return roles;
//    }
}
