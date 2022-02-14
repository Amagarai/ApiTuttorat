package com.example.apitutorat.users.model;

import com.example.apitutorat.users.Utulisateur;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import java.util.List;

@Entity
@DiscriminatorValue("ELEVE")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Eleve extends Utulisateur {
    private String cour;
    private String ecole;
    private String classe;
    private String parents;
    private String description;
}
