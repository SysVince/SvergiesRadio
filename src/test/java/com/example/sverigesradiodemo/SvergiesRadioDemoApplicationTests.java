package com.example.sverigesradiodemo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SvergiesRadioDemoApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    void splitTime(){
        //Given /Date(1661833053577+0200)/
        String dateString = "/Date(1661833053577+0200)/";

        //When
       String newDateString = dateString.substring(6,19);

        //Then
        System.out.println(newDateString);




    }

}
