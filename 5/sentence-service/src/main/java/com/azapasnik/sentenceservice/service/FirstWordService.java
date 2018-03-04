package com.azapasnik.sentenceservice.service;

import com.azapasnik.sentenceservice.model.WordDTO;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("first-word-service")
public interface FirstWordService {

    @GetMapping("/")
    WordDTO getWord();
}
