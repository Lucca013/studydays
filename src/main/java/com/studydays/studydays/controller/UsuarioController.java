package com.studydays.studydays.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UsuarioController {
    @GetMapping("/login")
    public String login(){
        return "auth/login";
    }

    @GetMapping("/cadastro")
    public String cadastro(){
        return "auth/cadastro";
    }
}
