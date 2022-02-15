package com.example.apitutorat.users;

import com.example.apitutorat.demeande.Demande;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(discriminatorType = DiscriminatorType.STRING)
public abstract class Utulisateur {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String prenom;
    private String numero;
    private String addresse;

    @Enumerated(EnumType.STRING)
    private Profile profile;
    private String password;
    @Enumerated(EnumType.STRING)
    private Etat etat = Etat.ACTIVER;
    private boolean supprime = false;

    @OneToMany(mappedBy = "envoyeur")
    private List<Demande> demandes;
}
