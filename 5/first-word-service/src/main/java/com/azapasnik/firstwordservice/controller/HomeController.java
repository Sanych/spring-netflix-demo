package com.azapasnik.firstwordservice.controller;

import com.azapasnik.firstwordservice.model.WordDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.Random;

@RestController
public class HomeController {

    @Value("${word.list}")
    private String words;

    @GetMapping(value = "/", produces = "application/json")
    public String getWord() throws JsonProcessingException {
        String[] strings = words.split(",");
        int i = new Random().nextInt(strings.length);

        WordDTO wordDTO = new WordDTO();
        wordDTO.setWord(strings[i]);
        wordDTO.setTime(new Date().getTime());

        return new ObjectMapper().writeValueAsString(wordDTO);
    }
}
