package com.example.sverigesradiodemo.controller;

import com.example.sverigesradiodemo.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/home")
public class HomeController {

    @Autowired
    MessageService messageService;

    @GetMapping
    public String getAllSRNews(Model model){
        model.addAttribute("srmessages", messageService.getAllSRNews().getMessages());
        return "home";
    }

    @PostMapping("/{id}")
    public String saveMessage(@PathVariable ("id") int messageId, Model model){
        messageService.saveMessage(messageId);
        model.addAttribute("srmessages", messageService.getAllSRNews().getMessages());
        return "home";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteMessage(@PathVariable ("id") int messageId, Model model){
        messageService.deleteMessage(messageId);
        model.addAttribute("srmessages", messageService.findAll());
        return "savedmessages";
    }

    @GetMapping("/saved")
    public String getSavedMessages(Model model){
        model.addAttribute("srmessages", messageService.findAll());
        return "savedmessages";

    }

}
