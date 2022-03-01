package com.example.apitutorat.chat.service;

import com.example.apitutorat.chat.Chat;
import com.example.apitutorat.chat.repository.ChatRepository;
import com.example.apitutorat.users.Utulisateur;
import com.example.apitutorat.users.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class ChatServiceImp implements ChatService{

    @Autowired
    ChatRepository chatRepository;

    @Autowired
    UsersRepository usersRepository;

    @Override
    public Chat addChat(Chat chat, Long from, Long to) {
        Utulisateur envoyeur = usersRepository.findById(from).get();
        Utulisateur receveur = usersRepository.findById(to).get();
        chat.setEnvoyeur(envoyeur);
        chat.setReceveur(receveur);
        chat.setDate(LocalDate.now());
        chat.setHeure(LocalTime.now());
        return chatRepository.save(chat);
    }

    @Override
    public List<Chat> triuver(Long receveur) {
        Utulisateur utulisateur= usersRepository.findById(receveur).get();
        return chatRepository.findByReceveur(utulisateur);
    }

    @Override
    public List<Chat> ListChat(Long from, Long to) {
        Utulisateur envoyeur= usersRepository.findById(from).get();
        Utulisateur receveur= usersRepository.findById(to).get();
        return chatRepository.findByEnvoyeurAndReceveurAndReceveurAndEnvoyeur(envoyeur, receveur, receveur, envoyeur);
    }
}
