package com.example.demopjgl.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @GetMapping
    public String obtenerTodosLosUsuarios() {
        return "Hola - microservicio usuarios v4";
    }
}

