package com.crowdfunding.projet.controller;

import com.crowdfunding.projet.entity.Users;
import com.crowdfunding.projet.service.UserService;
import org.hibernate.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.*;


@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    //inscription user
    @PostMapping("/users")
    public String save(@RequestBody Users user){
        userService.saveUser(user);
        return "Inscription réussi";
    }
    
    //get all the users
    @GetMapping("/user")
    public List<Users> getUsers(){
        return userService.listUsers();}

    @GetMapping("/client/{id}")
    public Optional<Users> findUser(@PathVariable("id") Long id){
        return userService.OneUser(id);
    }

    @GetMapping("/client")
    public Users findUserOn(String email){
        return userService.userByMail(email);
    }
}
