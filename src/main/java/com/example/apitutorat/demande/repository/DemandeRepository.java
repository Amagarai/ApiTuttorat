package com.example.apitutorat.demande.repository;

import com.example.apitutorat.demande.Demande;
import com.example.apitutorat.demande.Etat;
import com.example.apitutorat.users.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DemandeRepository extends JpaRepository<Demande, Long> {
    public List<Demande> findByEnvoyeurAndReceveurAndEtatIsTrueOrderByIdDesc(Utilisateur envoyeur, Utilisateur receveur);
    public List<Demande> findByReceveurAndEtatOrderByIdDesc(Utilisateur receveur, Etat etat);
    public List<Demande> findByReceveurOrderByIdDesc(Utilisateur receveur);
    public List<Demande> findByInitierIsTrueOrderByIdDesc();
    public List<Demande> findByReceveurAndInitierIsTrueOrderByIdDesc(Utilisateur envoyeur);
    public List<Demande> findByEnvoyeurAndInitierIsTrueOrderByIdDesc(Utilisateur receveur );
    public Demande findByEnvoyeurAndReceveurAndMatiere(Utilisateur envoyeur, Utilisateur receveur, String matiere);
    public List<Demande> findByEnvoyeurAndEtatOrderByIdDesc(Utilisateur user, Etat etat);
    public List<Demande> findByEtat(Etat etat);
}
