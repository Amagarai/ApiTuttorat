package com.example.apitutorat.demeande.service;

import com.example.apitutorat.demeande.Demande;
import com.example.apitutorat.demeande.Etat;
import com.example.apitutorat.demeande.repository.DemandeRepository;
import com.example.apitutorat.users.Utulisateur;
import com.example.apitutorat.users.repository.UsersRepository;
import com.example.apitutorat.users.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DemandeServiceImp implements DemandeService{

    @Autowired
    DemandeRepository demandeRepository;

    @Autowired
    UsersRepository usersRepository;


    @Override
    public String sendDemande(Long from, Long to, String matiere) {
        Utulisateur sender= usersRepository.findById(from).get();
        Utulisateur receveur= usersRepository.findById(to).get();

        Demande demande= new Demande();
        demande.setEnvoyeur(sender);
        demande.setReceveur(receveur);
        demande.setMatiere(matiere);
        demande.setContenu("Veut vous envoyer "+matiere+" une demante");
        demandeRepository.save(demande);

        //receveur.setOldTotale(receveur.getTotaleNotif());
        receveur.setTotaleNotif(receveur.getTotaleNotif()+1);

        usersRepository.save(receveur);
        return "Demande envoyer avec succes";
    }

    @Override
    public void InitierDemande(Long id) {
        Demande demande = demandeRepository.findById(id).get();
        demande.setInitier(true);
        demandeRepository.save(demande);
    }

    @Override
    public String declinerDemande(Long id) {
        Demande demande = demandeRepository.findById(id).get();
        demande.setEtat(Etat.DECLINER);
        demandeRepository.save(demande);
        return "Demande Refuser";
    }

    @Override
    public void accepterDemande(Long id) {
        Demande demande= demandeRepository.findById(id).get();
        demande.setEtat(Etat.ACCEPTER);
        demandeRepository.save(demande);
    }

    @Override
    public List<Demande> listesAllDemande(Long from_id, Long to_id) {
        Utulisateur from= usersRepository.findById(from_id).get();
        Utulisateur to= usersRepository.findById(to_id).get();
        return demandeRepository.findByEnvoyeurAndReceveurAndEtatIsTrue(from,to);
    }

    @Override
    public List<Demande> GetByReceveur(Long id) {
        Utulisateur user= usersRepository.findById(id).get();
        return demandeRepository.findByReceveur(user);
    }

    @Override
    public List<Demande> ListeAllInitier() {
        return demandeRepository.findByInitierIsTrue();
    }

    @Override
    public List<Demande> InitierByEnvoyeurAndReceveur(Long from_id) {
        Utulisateur envoyeur= usersRepository.findById(from_id).get();

        return demandeRepository.findByReceveurAndInitierIsTrue(envoyeur);
    }
}
