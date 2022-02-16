package com.example.apitutorat.users.service;
import com.example.apitutorat.users.Etat;
import com.example.apitutorat.users.Profile;
import com.example.apitutorat.users.Utulisateur;
import com.example.apitutorat.users.model.Ecole;
import com.example.apitutorat.users.model.Eleve;
import com.example.apitutorat.users.model.Parent;
import com.example.apitutorat.users.model.Tuteur;
import com.example.apitutorat.users.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImp implements UserService{

    @Autowired
    UsersRepository usersRepository;
    @Autowired
    EcoleRepository ecoleRepository;
    @Autowired
    TuteurRepository tuteurRepository;
    @Autowired
    EleveRepository eleveRepository;
    @Autowired
    ParentRepository parentRepository;


    //----------------------------section de liste---------------------------


    @Override
    public List<Utulisateur> findAllEleve() {
        return usersRepository.listerEleve();
    }

    @Override
    public List<Utulisateur> findAllEcole() {
        return usersRepository.listerEcole();
    }

    @Override
    public List<Utulisateur> findAllParent() {
        return usersRepository.listerParent();
    }

    @Override
    public List<Utulisateur> findAllTuteur() {
        return usersRepository.listerTuteur();
    }

    @Override
    public Utulisateur finById(Long id) {
        return usersRepository.findById(id).get();
    }

    @Override
    public List<Utulisateur> liste() {

        return usersRepository.findAll();
    }

    @Override
    public List<Utulisateur> listerParentEleve() {
        return usersRepository.listerParentEleve();
    }


    @Override
    public List<Tuteur> recherche(String ville, String specialite) {
        return usersRepository.findByAddresseAndSpecialite(ville, specialite);
    }

    @Override
    public List<Utulisateur> FindAllDel() {
        return usersRepository.listDel();
    }

    //----------------fin


    //--------------------------------------section pour ajouter les utilisateurs----------------------------------------------

    @Override
    public Utulisateur addEleve(Eleve eleve) {
        return usersRepository.save(eleve);
    }

    @Override
    public Utulisateur addEcole(Ecole ecole) {
        return usersRepository.save(ecole);
    }

    @Override
    public Utulisateur addParent(Parent parent) {
        return usersRepository.save(parent);
    }

    @Override
    public Utulisateur addTuteur(Tuteur tuteur) {
        return usersRepository.save(tuteur);
    }

    //------fin


    //----------------------------------Section pour la  modification complète des utisateurs -------------------------------------------------

    @Override
    public void modify_ecole(Long id, Ecole utulisateur) {
        Ecole ecole= ecoleRepository.findById(id).get();
        ecole.setAddresse(utulisateur.getAddresse());
        ecole.setNom(utulisateur.getNom());
        ecole.setNumero(utulisateur.getNumero());
        ecole.setPassword(utulisateur.getPassword());
        ecole.setEmail(utulisateur.getEmail());
        ecole.setSite(utulisateur.getSite());
        ecoleRepository.save(ecole);
    }

    @Override
    public void modify_tuteur(Long id, Tuteur tuteur) {
        Tuteur user= tuteurRepository.findById(id).get();
        user.setAddresse(tuteur.getAddresse());
        user.setNumero(tuteur.getNumero());
        user.setNom(tuteur.getNom());
        user.setPassword(tuteur.getPassword());
        user.setAnciennete(tuteur.getAnciennete());
        user.setEtablissement(tuteur.getEtablissement());
        user.setSpecialite(tuteur.getSpecialite());
        user.setPrenom(tuteur.getPrenom());
        user.setNiveau(tuteur.getNiveau());
        tuteurRepository.save(user);
    }

    @Override
    public void modify_eleve(Long id, Eleve eleve) {
        Eleve user= eleveRepository.findById(id).get();
        user.setAddresse(eleve.getAddresse());
        user.setNom(eleve.getNom());
        user.setNumero(eleve.getNumero());
        user.setPassword(eleve.getPassword());
        user.setPrenom(eleve.getPrenom());
        user.setClasse(eleve.getClasse());
        user.setCour(eleve.getCour());
        user.setDescription(eleve.getDescription());
        user.setEcole(eleve.getEcole());
        user.setParents(eleve.getParents());
        eleveRepository.save(user);

    }

    @Override
    public void modidy_parent(Long id, Parent parent) {
        Parent user= parentRepository.findById(id).get();
        user.setNumero(parent.getNumero());
        user.setAddresse(parent.getAddresse());
        user.setNom(parent.getNom());
        user.setPrenom(parent.getPrenom());
        user.setTravail(parent.getTravail());
        user.setPassword(parent.getPassword());
        parentRepository.save(user);
    }

    //--------------fin


    //------------------------Section pour modifier un seule valeur -----------------------------------------


    @Override
    public void disponibilite(Long id, Tuteur tuteur) {
        Tuteur user= tuteurRepository.findById(id).get();
        if (!user.isDisponibilite()){
            user.setDisponibilite(true);
        }
        if (user.isDisponibilite()){
            user.setDisponibilite(false);
        }
    }

    @Override
    public void modify_pass(Long id, Utulisateur utulisateur) {
        Utulisateur user= usersRepository.findById(id).get();
        user.setPassword(utulisateur.getPassword());
        usersRepository.save(user);
    }

    //---------------------section delete et restorer--------------------------------------------------------------


    @Override
    public void delete(Long id) {
        Utulisateur utulisateur= usersRepository.findById(id).get();
        utulisateur.setEtat(Etat.DESACTIVER);
        utulisateur.setSupprime(true);
        usersRepository.save(utulisateur);
    }

    @Override
    public void restore(Long id) {
        Utulisateur user= usersRepository.findById(id).get();
        user.setEtat(Etat.ACTIVER);
        user.setSupprime(false);
        usersRepository.save(user);
    }

    //---------------------Login---------------


    @Override
    public List<Utulisateur> login(String numero, String password) {
        return usersRepository.findByNumeroAndPassword(numero, password);
    }
}
