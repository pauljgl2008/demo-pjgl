package com.example.demopjgl.controllers;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @GetMapping
    public String obtenerTodosLosUsuarios() {
        return "Hola - microservicio usuarios";
    }
}

