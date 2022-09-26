package com.crowdfunding.projet.repository;

import com.crowdfunding.projet.entity.Statut;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface StatutRepository extends JpaRepository<Statut,Long>{

    @Query(value = " select * from statut where type_statut = :statut ",nativeQuery = true)
    Statut findStatutByTypeStatut(@Param("statut") String typeStatut);
}
