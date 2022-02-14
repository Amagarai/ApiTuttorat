package com.example.apitutorat.users.repository;

import com.example.apitutorat.users.Utulisateur;
import com.example.apitutorat.users.model.Tuteur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UsersRepository extends JpaRepository<Utulisateur, Long> {
    public List<Tuteur> findByAddresseAndSpecialite(String ville, String specialite);


    //------------------section pour lister les utilisateurs-------------------------------------

    @Query("SELECT searc FROM Utulisateur searc WHERE searc.etat='ACTIVER' and searc.profile='ELEVE'")
    public List<Utulisateur> listerEleve();

    @Query("select tuteur FROM Utulisateur  tuteur where tuteur.etat='ACTIVER' and tuteur.profile='TUTEUR'")
    public List<Utulisateur> listerTuteur();

    @Query("select parent FROM Utulisateur  parent where parent.etat='ACTIVER' and parent.profile='PARENT'")
    public List<Utulisateur> listerParent();

    @Query("select ecole FROM Utulisateur  ecole where ecole.etat='ACTIVER' and ecole.profile='TUTEUR'")
    public List<Utulisateur> listerEcole();


    //-----------------------------section pour lister les etats desactiver-------------------------------

    @Query("select users FROM Utulisateur  users where users.etat='DESACTIVER'")
    public List<Utulisateur> listDel();

}
