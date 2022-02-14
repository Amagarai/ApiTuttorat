package com.example.apitutorat.users.model;

import com.example.apitutorat.users.Utulisateur;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("ECOLE")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ecole extends Utulisateur {
    @Column(length = 24)
    private String site;
    private String email;
}
