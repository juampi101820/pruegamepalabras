package com.juego.juegopalabras.controllers;

import java.util.Random;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.juego.juegopalabras.models.JuegoModel;
import com.juego.juegopalabras.services.JuegoService;

@RestController
@RequestMapping("/juego")
public class JuegoController {

    private final JuegoService juegoService;

    public JuegoController(JuegoService juegoService) {
        this.juegoService = juegoService;
    }

    @PostMapping("/iniciar")
    public JuegoModel iniciarJuego() {
        return juegoService.iniciarJuego();
    }
    
}