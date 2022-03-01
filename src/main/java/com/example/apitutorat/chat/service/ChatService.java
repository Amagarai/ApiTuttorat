package com.example.apitutorat.chat.service;

import com.example.apitutorat.chat.Chat;
import com.example.apitutorat.users.Utulisateur;

import java.util.List;

public interface ChatService {
    public Chat addChat(Chat chat, Long from, Long to);
    public List<Chat> ListChat(Long from, Long to);
    public List<Chat> triuver(Long receveur);
}
