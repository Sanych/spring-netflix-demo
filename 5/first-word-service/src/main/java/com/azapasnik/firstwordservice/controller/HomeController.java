package com.azapasnik.firstwordservice.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
public class HomeController {

    @Value("${word.list}")
    private String words;

    @GetMapping(value = "/")
    public String getWord() {
        String[] strings = words.split(",");
        int i = new Random().nextInt(strings.length);
        return strings[i];
    }
}
