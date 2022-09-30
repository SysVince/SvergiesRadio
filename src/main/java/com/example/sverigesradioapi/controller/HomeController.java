package com.example.sverigesradioapi.controller;

import com.example.sverigesradioapi.service.MessageService;
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
    public String saveMessage(@PathVariable ("id") int messageId){
        messageService.saveMessage(messageId);

        return "redirect:/home";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteMessage(@PathVariable ("id") int messageId){
        messageService.deleteMessage(messageId);
        return "redirect:/home/saved";
    }

    @GetMapping("/saved")
    public String getSavedMessages(Model model){
        model.addAttribute("srmessages", messageService.findAll());
        return "savedmessages";

    }

}
