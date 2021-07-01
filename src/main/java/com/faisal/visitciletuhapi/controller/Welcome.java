package com.faisal.visitciletuhapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/welcome")
public class Welcome {
    
    @GetMapping
    public String welcome() {
        return "Selamat datang di API saya.";
    }
}
