package com.juego.juegopalabras.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.juego.juegopalabras.models.JuegoModel;
import com.juego.juegopalabras.services.JuegoService;

@RestController
@RequestMapping("/juego")
public class JuegoController {

    @Autowired
    private JuegoService juegoService;

    @PostMapping("/iniciar")
    public JuegoModel iniciarJuego() {
        return juegoService.iniciarJuego();
    }
    
}