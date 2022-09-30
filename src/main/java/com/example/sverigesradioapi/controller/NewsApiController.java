package com.example.sverigesradioapi.controller;

import com.example.sverigesradioapi.model.entity.SRMessage;
import com.example.sverigesradioapi.model.SRNews;
import com.example.sverigesradioapi.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/news")
public class NewsApiController {

    //ResponseEntity<> i Framtiden

    @Autowired
    MessageService messageService;

    @GetMapping
    public SRNews getAllSRNews(){
        return messageService.getAllSRNews();
    }


    @GetMapping("/{id}")
    public SRMessage findMessageById(@PathVariable ("id") int messageId){
        return messageService.findMessageById(messageId);
    }


    @PostMapping("/{id}")
    public void saveMessage(@PathVariable ("id") int messageId){
         messageService.saveMessage(messageId);
    }

    @DeleteMapping("/{id}")
    public void deleteMessage(@PathVariable ("id") int messageId){
         messageService.deleteMessage(messageId);
    }

    @GetMapping("/saved")
    public List<SRMessage> getSavedMessages(){
        return messageService.findAll();
    }

}