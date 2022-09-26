package com.crowdfunding.projet.controller;

import com.crowdfunding.projet.entity.Users;
import com.crowdfunding.projet.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
//import java.util.Optional;

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
    public Users findUser(@PathVariable("id") Long id){
        return userService.OneUser(id);
    }

    @GetMapping("/client")
    public Users findUserOn(String email){
        return userService.userByMail(email);
    }

    @PutMapping("/update")
    public ResponseEntity<Users> updateUser (@RequestBody Users userDetails){
        Users user = userService.OneUser(userDetails.getIdUser());
//                .orElseThrow(() -> new ResourceNotFoundException("l'id de l'utilisateur n'existe pas : " + id));

        user.setNom(userDetails.getNom());
        user.setPrenom(userDetails.getPrenom());
        user.setDateNaissance(userDetails.getDateNaissance());
        user.setEmail(userDetails.getEmail());
        user.setAdresse(userDetails.getAdresse());
        user.setVille(userDetails.getVille());
        user.setPays(userDetails.getPays());
        user.setCinRecto(userDetails.getCinRecto());
        user.setCinVerso(userDetails.getCinVerso());

        userService.saveUser(user);

        return new ResponseEntity<>(HttpStatus.OK);

    }

    @GetMapping("/admin/nombreClient")
    public int clientNumber(){
        return userService.nombreClient();
    }
}
