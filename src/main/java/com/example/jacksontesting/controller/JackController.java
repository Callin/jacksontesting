package com.example.jacksontesting.controller;

import com.example.jacksontesting.dto.JackDto;
import com.example.jacksontesting.dto.JackEsDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JackController {

    @GetMapping("/getjack")
    public JackDto getJack() {
        JackDto jackDto = new JackDto();
        jackDto.setName("Jack Doe");
        jackDto.setEmail("jack@doe.com");

        return jackDto;
    }

    @PostMapping("/postjack")
    public JackDto postJack(@RequestBody JackDto jackDto) {

        System.out.println(jackDto);

        return jackDto;
    }

    @PostMapping("/postjackes")
    public JackDto postJackEs(@RequestBody JackEsDto jackEsDto) {

        System.out.println(jackEsDto);

        return jackEsDto;
    }
}
