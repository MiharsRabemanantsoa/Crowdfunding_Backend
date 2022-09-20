package com.crowdfunding.projet.service;

import com.crowdfunding.projet.entity.Users;
import com.crowdfunding.projet.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void saveUser(Users user){
        userRepository.save(user);
    }
    
    public List<Users> listUsers(){
        return userRepository.findAll();
        }
}
