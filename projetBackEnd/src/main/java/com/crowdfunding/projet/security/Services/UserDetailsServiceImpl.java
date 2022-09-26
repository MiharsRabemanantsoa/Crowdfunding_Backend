package com.crowdfunding.projet.Security.Services;

import com.crowdfunding.projet.entity.Users;
import com.crowdfunding.projet.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    UserRepository userRepository;

    //tsy maintsy io ilay methode
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Users user = userRepository.findByEmail(email);
//                .orElseThrow(() -> new UsernameNotFoundException("Utilisateur introuvable avec e-mail: " + email));
        return UserDetailsImpl.build(user);
    }
}
