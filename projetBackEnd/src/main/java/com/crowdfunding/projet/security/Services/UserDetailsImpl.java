package com.crowdfunding.projet.Security.Services;

import com.crowdfunding.projet.entity.Users;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDetailsImpl implements UserDetails {
    private static final long serialVersionUID = 1L;
    //attributs
    private Long idUser;
    private String nom;
    private String email;
    @JsonIgnore
    private String motDePasse;
    private Collection<? extends GrantedAuthority> authorities;
    private String prenom;
    private String photoProfil;

    public UserDetailsImpl(Long idUser, String nom, String prenom, String photoProfil, String email, String motDePasse, List<GrantedAuthority> authorities) {
        this.idUser=idUser;
        this.nom=nom;
        this.prenom=prenom;
        this.photoProfil=photoProfil;
        this.email=email;
        this.motDePasse=motDePasse;
        this.authorities=authorities;
    }

    public static UserDetailsImpl build(Users user) {
        List<GrantedAuthority> authorities = user.getRoles().stream()
                .map(role -> new SimpleGrantedAuthority(role.getName().name()))
                .collect(Collectors.toList());
        return new UserDetailsImpl(
                user.getIdUser(),
                user.getNom(),
                user.getPrenom(),
                user.getPhotoProfil(),
                user.getEmail(),
                user.getMotDePasse(),
                authorities);
    }

    public String getPrenom() {
        return prenom;
    }

    public String getPhotoProfil() {
        return photoProfil;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    public Long getId() {
        return idUser;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String getPassword() {
        return motDePasse;
    }

    @Override
    public String getUsername() {
        return nom;
//        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        UserDetailsImpl user = (UserDetailsImpl) o;
        return Objects.equals(idUser, user.idUser);
    }
}
