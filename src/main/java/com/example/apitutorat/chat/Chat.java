package com.example.apitutorat.chat;

import com.example.apitutorat.users.Utulisateur;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Chat {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String contenu;
    private LocalDate date;
    private LocalTime heure;

    @OneToOne
    private Utulisateur envoyeur;

    @OneToOne
    private Utulisateur receveur;
}
