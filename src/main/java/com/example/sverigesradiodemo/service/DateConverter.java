package com.example.sverigesradiodemo.service;

import com.example.sverigesradiodemo.model.sverigesradio.SRMessage;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

@Component
public class DateConverter {

    // From API Microsoft JSON Date = "/Date(1663300527870+0200)/"
    // Converted Date = 2022-09-16 05:55:27
    public String microsoftDateToJavaDate(String createddate) {
        long convertedLong = Long.parseLong(createddate.substring(6,createddate.length()-10)) ;
        LocalDateTime localDateTime = LocalDateTime.ofEpochSecond(convertedLong, 0, ZoneOffset.ofHours(2));

        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        return localDateTime.format(dateFormatter);
    }
}
