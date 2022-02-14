package com.example.apitutorat.users.service;

import com.example.apitutorat.users.Utulisateur;
import com.example.apitutorat.users.model.Ecole;
import com.example.apitutorat.users.model.Eleve;
import com.example.apitutorat.users.model.Parent;
import com.example.apitutorat.users.model.Tuteur;

import java.util.List;

public interface UserService {

    public List<Utulisateur> liste();
    public void supprinmer(Long id);
    public Utulisateur finById(Long id);
    public List<Utulisateur> findAll();

    //-------------------------section modier-----------------------------------------------
    public void modify_ecole(Long id, Ecole utulisateur);
    public void modify_tuteur(Long id, Tuteur tuteur);
    public void modify_eleve(Long id, Eleve eleve);
    public void modidy_parent(Long id, Parent  parent);
    public void disponibilite(Long id, Tuteur tuteur);
    public void modify_pass(Long id, Utulisateur utulisateur);
    public List<Tuteur> recherche(String ville, String specialite);

    //------------------Section ajout-------------------------------------------------------

    public Utulisateur addEleve(Eleve eleve);
    public Utulisateur addEcole(Ecole ecole);
    public Utulisateur addParent(Parent parent);
    public Utulisateur addTuteur(Tuteur tuteur);

}
