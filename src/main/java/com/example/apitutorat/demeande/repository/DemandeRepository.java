package com.example.apitutorat.demeande.repository;

import com.example.apitutorat.demeande.Demande;
import com.example.apitutorat.demeande.Etat;
import com.example.apitutorat.users.Utulisateur;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DemandeRepository extends JpaRepository<Demande, Long> {
    public List<Demande> findByEnvoyeurAndReceveurAndEtatIsTrue(Utulisateur envoyeur, Utulisateur receveur);
}
