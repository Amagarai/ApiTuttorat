package com.example.apitutorat.demeande.controller;

import com.example.apitutorat.demeande.Demande;
import com.example.apitutorat.demeande.service.DemandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("api/demande/")
public class DemandeController {
    @Autowired
    DemandeService demandeService;

    @PostMapping("send/{from}/{to}/{matiere}")
    public String sendDemande(@PathVariable Long from, @PathVariable Long to, @PathVariable String matiere){
        return demandeService.sendDemande(from, to, matiere);
    }

    @GetMapping("notif/{id}")
    public List<Demande> GetMyDemande(@PathVariable Long id){
        return demandeService.GetByReceveur(id);
    }

    @PutMapping("accepter/{id}")
    public void InititierDemande(@PathVariable Long id){
        demandeService.InitierDemande(id);
    }

    @PutMapping("decliner/{id}")
    public void DeclinerDemande(@PathVariable Long id){
        demandeService.declinerDemande(id);
    }

    @PutMapping("aprouve/{id}")
    public void AccepterDemande(@PathVariable Long id){
        demandeService.accepterDemande(id);
    }

    @GetMapping("initier")
    public List<Demande> init(){
        return demandeService.ListeAllInitier();
    }

    @GetMapping("initier/{from}")
    public List<Demande> GetListeInitierByEnvoyeurAndReceveur(@PathVariable Long from){
        return demandeService.InitierByEnvoyeurAndReceveur(from);
    }
}
