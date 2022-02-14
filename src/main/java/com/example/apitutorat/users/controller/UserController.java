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

    @GetMapping("search/{ville}/{specialite}")
    public List<Tuteur> recherche(@PathVariable String ville, @PathVariable String specialite){
        return userService.recherche(ville, specialite);
    }

    //-------------------------section de modification---------------------------------------------

    @PutMapping("modify/ecole/{id}/{ecole}")
    public void modify_ecole(@PathVariable Long id, @PathVariable Ecole ecole){
        userService.modify_ecole(id, ecole);
    }

    @PutMapping("modify/tuteur/{id}/{tuteur}")
    public void modify_tuteur(@PathVariable Long id, @PathVariable Tuteur tuteur){
        userService.modify_tuteur(id, tuteur);
    }

    @PutMapping("modify/eleve/{id}/{eleve}")
    public void modify_eleve(@PathVariable Long id, @PathVariable Eleve eleve){
        userService.modify_eleve(id, eleve);
    }

    @PutMapping("modify/parent/{id}/{parent}")
    public void modify_parent(@PathVariable Long id, @PathVariable Parent parent){
        userService.modidy_parent(id, parent);
    }

    @PutMapping("tuteur/dispo/{id}/{tuteur}")
    public void disponibiliter(@PathVariable Long id, @PathVariable Tuteur tuteur){
        userService.disponibilite(id, tuteur);
    }

    @PutMapping("user/modifypass/{id}/{user}")
    public void Modify_Password(@PathVariable Long id, @PathVariable Utulisateur user){
        userService.modify_pass(id, user);
    }
}
