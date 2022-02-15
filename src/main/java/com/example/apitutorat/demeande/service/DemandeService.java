package com.example.apitutorat.demeande.service;

import com.example.apitutorat.demeande.Demande;
import com.example.apitutorat.demeande.Etat;

import java.util.List;

public interface DemandeService {
    public String sendDemande(Long from, Long to, String matiere);
    public String acceptDemande(Long id);
    public String declinerDemande(Long id);

    public List<Demande> listesDemande(Long from_id, Long to_id);
}
