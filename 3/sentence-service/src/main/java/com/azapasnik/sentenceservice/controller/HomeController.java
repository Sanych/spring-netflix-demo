package com.azapasnik.sentenceservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class HomeController {

    @Autowired
    DiscoveryClient discoveryClient;

    @Autowired
    RestTemplate restTemplate;

    @GetMapping(value = "/")
    public String getWord() {
        return makeServiceCall("first-word-service") + " " +
                makeServiceCall("second-word-service") + " " +
                makeServiceCall("third-word-service");
    }

    private String makeServiceCall(String serviceName) {
        List<ServiceInstance> serviceInstances = discoveryClient.getInstances(serviceName);
        if (!CollectionUtils.isEmpty(serviceInstances)) {
            return restTemplate.getForObject(serviceInstances.get(0).getUri(), String.class);
        }
        return "";
    }


}
