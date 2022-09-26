package com.crowdfunding.projet.repository;

import com.crowdfunding.projet.entity.Investissement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface InvestissementRepository extends JpaRepository<Investissement,Long> {

    @Query(value = "SELECT COUNT(DISTINCT users_id_user ) from investissement",nativeQuery = true)
    int nombreInvestisseur();
}
