package com.example.apitutorat.users.repository;

import com.example.apitutorat.users.Utulisateur;
import com.example.apitutorat.users.model.Tuteur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UsersRepository extends JpaRepository<Utulisateur, Long> {
    public List<Tuteur> findByAddresseAndSpecialite(String ville, String specialite);


    //------------------section pour lister les utilisateurs-------------------------------------

    @Query("SELECT searc FROM Eleve searc WHERE searc.etat='ACTIVER'")
    public List<Utulisateur> listerEleve();

    @Query("select tuteur FROM Tuteur  tuteur where tuteur.etat='ACTIVER'")
    public List<Utulisateur> listerTuteur();

    @Query("select parent FROM Parent  parent where parent.etat='ACTIVER'")
    public List<Utulisateur> listerParent();

    @Query("select ecole FROM Ecole  ecole where ecole.etat='ACTIVER' ")
    public List<Utulisateur> listerEcole();


    //-----------------------------section pour lister les etats desactiver-------------------------------

    @Query("select users FROM Utulisateur  users where users.etat='DESACTIVER'")
    public List<Utulisateur> listDel();


}
