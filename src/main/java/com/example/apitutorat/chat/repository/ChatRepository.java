package com.example.apitutorat.chat.repository;

import com.example.apitutorat.chat.Chat;
import com.example.apitutorat.users.Utulisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ChatRepository  extends JpaRepository<Chat, Long> {
    public List<Chat> findByEnvoyeurAndReceveur(Utulisateur envoyeur, Utulisateur receveur);
    public List<Chat> findByReceveurAndEnvoyeur(Utulisateur receveur, Utulisateur envoyeur);
    public List<Chat> findByReceveur(Utulisateur receveur);

    public List<Chat> findByEnvoyeurAndReceveurAndReceveurAndEnvoyeur(Utulisateur envoyeur,  Utulisateur receveur, Utulisateur receveurI,  Utulisateur envoyeurI);
}
