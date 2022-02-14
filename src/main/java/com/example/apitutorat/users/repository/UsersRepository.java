package com.example.apitutorat.users.repository;

import com.example.apitutorat.users.Utulisateur;
import com.example.apitutorat.users.model.Tuteur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UsersRepository extends JpaRepository<Utulisateur, Long> {
    public List<Tuteur> findByAddresseAndSpecialite(String ville, String specialite);

    @Query("SELECT searc FROM Utulisateur searc WHERE searc.etat='ACTIVER'")
    public List<Utulisateur> lister();

    public List<Utulisateur> findByEtat_Activer();
}
