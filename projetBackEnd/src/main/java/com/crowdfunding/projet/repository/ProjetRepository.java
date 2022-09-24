package com.crowdfunding.projet.repository;

import com.crowdfunding.projet.entity.Projet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjetRepository extends JpaRepository<Projet, Long> {
    @Query(value = "SELECT * FROM projet ORDER BY somme_collecte DESC LIMIT 3;", nativeQuery = true)
    List<Projet> listAll();

    Projet findProjectByIdProjet(Long id);

    @Query(value = "SELECT COUNT(DISTINCT investissement.users_id_user ) as nombreUser,id_projet,creation_campagne,date_mise_en_ligne, debut_remboursement,description_courte,duree_remboursement,echeance,'etape_creation',\n" +
            "fin_campagne,image,localisation,somme_objectif,taux_interet,titre,description_longue,projet.etape_creation,categ_projet_id_categorie,lancement_souhaite,somme_collecte,statut_id_statut \n" +
            "from projet INNER JOIN investissement on investissement.projet_investi_id_projet = projet.id_projet where projet.id_projet = :id \n" +
            "GROUP BY projet.id_projet;", nativeQuery = true)
    Object findOneProject(@Param("id")Long id);

    /*projet compte client*/
    @Query(value = "SELECT * FROM projet INNER JOIN users  on projet.users_id_user=users.id_user WHERE id_user= :id  ;", nativeQuery = true)
    List<Projet> listProjetId(@Param("id")Long id);

    //comptage nombre projet
    @Query(value="SELECT COUNT (DISTINCT id_projet )FROM public.projet ;", nativeQuery = true)
    Long getCountProjet(Long id_notification);



}
