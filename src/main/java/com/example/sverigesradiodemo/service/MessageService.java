package com.example.sverigesradiodemo.service;

import com.example.sverigesradiodemo.model.sverigesradio.SRMessage;
import com.example.sverigesradiodemo.model.sverigesradio.SRNews;
import com.example.sverigesradiodemo.repository.SRMessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;


import java.util.List;

@Service
public class MessageService {

    //Exception handling i framtiden

    SRNews srNews;

    @Autowired
    WebClient webClient;
    @Autowired
    SRMessageRepository srMessageRepository;

    @Autowired
    DateConverter dateConverter;

    public SRNews getAllSRNews() {

        srNews = webClient
                .get()
                .uri("http://api.sr.se/api/v2/traffic/messages?format=json")
                .exchangeToMono(clientResponse -> clientResponse.bodyToMono(SRNews.class))
                .block(); //Synkront, annars är webclient asynkront

        for (SRMessage srMessage : srNews.getMessages()) {
            String convertedDate = dateConverter.microsoftDateToJavaDate(srMessage.getCreateddate());
            srMessage.setCreateddate(convertedDate);
        }
        return srNews;
    }

    //    List<SRMessage> srMessages = Arrays.asList(srNews.getMessages());
//    List<SRMessage> srMessages = List.of(srNews.getMessages());
//    SRMessage[] srMessages = srNews.getMessages();
    public SRMessage findMessageById(int id) {
        SRMessage foundMessage = null;

        SRMessage[] srMessages = srNews.getMessages();
        for (SRMessage srMessage : srMessages) {
            if (id == srMessage.getId()) {
                foundMessage = srMessage;
            }
        }
        return foundMessage;
    }


    public void saveMessage(int id) {
        srMessageRepository.save(findMessageById(id));
    }

    public void deleteMessage(int id) {
        List<SRMessage> srMessages = findAll();

        for (SRMessage srMessage : srMessages) {
            if (srMessage.getLocalId() == id) {
                srMessageRepository.delete(srMessage);
            }
        }
    }

    public List<SRMessage> findAll() {
        return srMessageRepository.findAll();
    }
}
