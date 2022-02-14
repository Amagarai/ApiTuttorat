package com.example.apitutorat.users.model;

import com.example.apitutorat.users.Utulisateur;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@DiscriminatorValue("PARENT")
public class Parent extends Utulisateur {
    private String travail;
}
