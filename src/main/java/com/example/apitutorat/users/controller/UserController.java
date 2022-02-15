package com.example.apitutorat.users.controller;

import com.example.apitutorat.users.Utulisateur;
import com.example.apitutorat.users.model.Ecole;
import com.example.apitutorat.users.model.Eleve;
import com.example.apitutorat.users.model.Parent;
import com.example.apitutorat.users.model.Tuteur;
import com.example.apitutorat.users.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("api/")
public class UserController {
    @Autowired
    UserService userService;

    //--------------------------section d'ajout--------------------------------
    @PostMapping("add/ecole")
    public Utulisateur addEcole(@RequestBody Ecole ecole){
        return userService.addEcole(ecole);
    }

    @PostMapping("add/eleve")
    public Utulisateur addEleve(@RequestBody Eleve eleve){
        return userService.addEleve(eleve);
    }

    @PostMapping("add/parent")
    public Utulisateur addParent(@RequestBody Parent parent){
        return userService.addParent(parent);
    }

    @PostMapping("add/tuteur")
    public Utulisateur addTuteur(@RequestBody Tuteur tuteur){
        return userService.addTuteur(tuteur);
    }


    //--------------fin

    //------------------------section de recherche---------------------------------

    @GetMapping("search/{ville}/{specialite}")
    public List<Tuteur> recherche(@PathVariable String ville, @PathVariable String specialite){
        return userService.recherche(ville, specialite);
    }

    @GetMapping("liste")
    public List<Utulisateur> liste(){
        return userService.liste();
    }

    @GetMapping("liste/eleve")
    public List<Utulisateur> listEleve(){
        return userService.findAllEleve();
    }

    @GetMapping("liste/tuteur")
    public List<Utulisateur> listTuteur(){
        return userService.findAllTuteur();
    }

    @GetMapping("liste/ecole")
    public List<Utulisateur> listEcole(){
        return userService.findAllEcole();
    }

    @GetMapping("liste/parent")
    public List<Utulisateur> listParent(){
        return userService.findAllParent();
    }

    @GetMapping("trouver/{id}")
    public Utulisateur findByID(@PathVariable Long id){
        return userService.finById(id);
    }

    @GetMapping("liste/del")
    public List<Utulisateur> findAllDel(){
        return userService.FindAllDel();
    }

    @GetMapping("liste/users")
    public List<Utulisateur> listerParentEleve(){
        return userService.listerParentEleve();
    }




    //-------------------------section de modification---------------------------------------------

    @PutMapping("modify/ecole/{id}")
    public void modify_ecole(@PathVariable Long id, @RequestBody Ecole ecole){
        userService.modify_ecole(id, ecole);
    }

    @PutMapping("modify/tuteur/{id}")
    public void modify_tuteur(@PathVariable Long id, @RequestBody Tuteur tuteur){
        userService.modify_tuteur(id, tuteur);
    }

    @PutMapping("modify/eleve/{id}")
    public void modify_eleve(@PathVariable Long id, @RequestBody Eleve eleve){
        userService.modify_eleve(id, eleve);
    }

    @PutMapping("modify/parent/{id}")
    public void modify_parent(@PathVariable Long id, @RequestBody Parent parent){
        userService.modidy_parent(id, parent);
    }

    @PutMapping("tuteur/dispo/{id}")
    public void disponibiliter(@PathVariable Long id, @RequestBody Tuteur tuteur){
        userService.disponibilite(id, tuteur);
    }

    @PutMapping("user/modifypass/{id}")
    public void Modify_Password(@PathVariable Long id, @RequestBody Utulisateur user){
        userService.modify_pass(id, user);
    }


    //-------------------------------section supprimer te restorer---------------------------------------
    @PutMapping("del/{id}")
    public void delete(@PathVariable Long id){
        userService.delete(id);
    }

    @PutMapping("restore/{id}")
    public void restorer(@PathVariable Long id){
        userService.restore(id);
    }
}
