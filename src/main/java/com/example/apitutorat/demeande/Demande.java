package com.example.apitutorat.demeande;

import com.example.apitutorat.users.Utulisateur;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Demande {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String contenu;
    private LocalDate date = LocalDate.now();
    private String matiere;

    private boolean etat;
    @ManyToOne
    private Utulisateur envoyeur;

    @ManyToOne
    private Utulisateur receveur;
}
