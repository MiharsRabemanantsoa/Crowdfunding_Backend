package com.crowdfunding.projet.repository;

import com.crowdfunding.projet.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<Users, Long> {
    Optional<Users> findByNom(String username);
    Users findByEmail(String email);
    Boolean existsByNom(String username);
    Boolean existsByEmail(String email);

}
