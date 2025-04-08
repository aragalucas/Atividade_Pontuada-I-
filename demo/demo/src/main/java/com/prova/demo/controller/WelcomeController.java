package com.prova.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

    @GetMapping("/")
    public String mensagemBoasVindas() {
        return "Bem-vindo à API de Gestão de Funcionários!";
    }

    @GetMapping("/dev")
    public String nomeDesenvolvedor() {
        return "Desenvolvedor: Lucas Aragão Oliveira";
    }
}