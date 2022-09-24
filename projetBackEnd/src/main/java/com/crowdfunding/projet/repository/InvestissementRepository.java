package com.crowdfunding.projet.repository;


import com.crowdfunding.projet.entity.Investissement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InvestissementRepository extends JpaRepository<Investissement, Long> {
    @Query(value = "SELECT * FROM investissement INNER JOIN users  on investissement.users_id_user=users.id_user WHERE id_user= :id  ;", nativeQuery = true)
    List<Investissement> listInvestissementId(@Param("id")Long id);

}
