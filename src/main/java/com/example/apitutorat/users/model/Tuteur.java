package com.example.apitutorat.users.model;

import com.example.apitutorat.users.Utulisateur;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("TUTEUR")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Tuteur extends Utulisateur {
    private String specialite;
    private String etablissement;
    private boolean disponibilite = true;
    private int anciennete;
    private String niveau;
}
