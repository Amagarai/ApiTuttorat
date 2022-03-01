package com.example.apitutorat.chat.controller;

import com.example.apitutorat.chat.Chat;
import com.example.apitutorat.chat.service.ChatServiceImp;
import com.example.apitutorat.users.Utulisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("api/chat")
public class ChatController {
    @Autowired
    ChatServiceImp chatServiceImp;

    @PostMapping("add/{from}/{to}")
    public Chat addChat( @RequestBody Chat chat, @PathVariable Long from, @PathVariable Long to){
        return chatServiceImp.addChat(chat, from, to);
    }

    @GetMapping("liste/{from}/{to}")
    public List<Chat> FindBySenderAndTo(@PathVariable Long from, @PathVariable Long to){
        return  chatServiceImp.ListChat(from, to);
    }

    @GetMapping("trouver/{id}")
    public List<Chat> trouver(@PathVariable Long id){
        return chatServiceImp.triuver(id);
    }
}
