package com.juego.juegopalabras.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.juego.juegopalabras.models.UsuarioModel;
import com.juego.juegopalabras.services.UsuarioService;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/usuario")
    public UsuarioModel guardarUsuario(@RequestBody UsuarioModel usuario) {
        
        return usuarioService.guardarUsuario(usuario);
    }

    @GetMapping("/nameUser")
    public String mostrarUsuario() {
        return usuarioService.mostrarUsuario();
    }
}
