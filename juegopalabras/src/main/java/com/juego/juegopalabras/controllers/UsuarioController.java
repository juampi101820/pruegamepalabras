package com.juego.juegopalabras.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.juego.juegopalabras.models.UsuarioModel;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    
    private UsuarioModel usuarioActual;

    @PostMapping("/usuario")
    public UsuarioModel guardarUsuario(@RequestBody UsuarioModel usuario) {
        usuarioActual = usuario;
        return usuario;
    }

    @GetMapping("/nameUser")
    public String mostrarUsuario() {
        if (usuarioActual == null) {
            return "";
        }
        return usuarioActual.getNombre();
    }
}
