package com.azapasnik.sentenceservice.controller;

import com.azapasnik.sentenceservice.service.FirstWordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class HomeController {

    @Autowired
    DiscoveryClient discoveryClient;

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    FirstWordService firstWordService;

    @GetMapping(value = "/")
    public String getWord() {
        return firstWordService.getWord().getWord() + " " +
                makeServiceCall("second-word-service") + " " +
                makeServiceCall("third-word-service");
    }

    private String makeServiceCall(String serviceName) {
        return restTemplate.getForObject("http://" + serviceName, String.class);
    }
}