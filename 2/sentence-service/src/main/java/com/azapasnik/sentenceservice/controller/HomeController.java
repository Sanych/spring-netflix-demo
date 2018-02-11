package com.azapasnik.sentenceservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class HomeController {

    @Value("${first.word}")
    private String firstUri;

    @Value("${second.word}")
    private String secondUri;

    @Value("${third.word}")
    private String thirdUri;

    @Autowired
    RestTemplate restTemplate;

    @GetMapping(value = "/")
    public String getWord() {
        return restTemplate.getForObject(firstUri, String.class) + " " +
                restTemplate.getForObject(secondUri, String.class) + " " +
                restTemplate.getForObject(thirdUri, String.class);
    }

}
