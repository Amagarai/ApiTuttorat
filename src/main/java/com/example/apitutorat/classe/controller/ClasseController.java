package com.example.apitutorat.classe.controller;

import com.example.apitutorat.classe.Classe;
import com.example.apitutorat.classe.services.ClasseServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/classe/")
public class ClasseController {

    @Autowired
    ClasseServiceImp classeServiceImp;

    @PostMapping("add/{id}")
    public Classe addClasse(@PathVariable Long id,@RequestBody Classe classe){
        return this.classeServiceImp.addClasse(id, classe);
    }

    @GetMapping("mesclasses/{id}")
    public List<Classe> ClasseByTuteur(@PathVariable Long id){
        return this.classeServiceImp.classeByTuteur(id);
    }

    @GetMapping("{id}")
    public Classe classeById(@PathVariable Long id){
        return this.classeServiceImp.classeById(id);
    }

    @PutMapping("update/{id}")
    public Classe update(@RequestBody Classe classe, @PathVariable Long id){
        return classeServiceImp.updateClasse(classe, id);
    }

    @GetMapping("totale")
    public int Totale(){
        return classeServiceImp.totaleClasse();
    }

    @GetMapping("totale/{id}")
    public int totalById(@PathVariable Long id){
        return classeServiceImp.totaleMesClasses(id);
    }
}
