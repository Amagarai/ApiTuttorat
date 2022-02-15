package com.example.apitutorat.demeande.controller;

import com.example.apitutorat.demeande.service.DemandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
}
