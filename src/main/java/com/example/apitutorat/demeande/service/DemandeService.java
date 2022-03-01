package com.example.apitutorat.demeande.service;

import com.example.apitutorat.demeande.Demande;
import com.example.apitutorat.demeande.Etat;

import java.util.List;

public interface DemandeService {
    public String sendDemande(Long from, Long to, String matiere);
    public void InitierDemande(Long id);
    public String declinerDemande(Long id);
    public void accepterDemande(Long id);

    public List<Demande> listesAllDemande(Long from_id, Long to_id);
    public List<Demande> GetByReceveur(Long id);
    public List<Demande> ListeAllInitier();
    public List<Demande> InitierByEnvoyeurAndReceveur(Long from_id);

}
