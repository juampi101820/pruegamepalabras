package com.juego.juegopalabras.services;

import org.springframework.stereotype.Service;
import com.juego.juegopalabras.models.UsuarioModel;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


@Service
public class UsuarioService {
    
    private UsuarioModel usuarioActual;
    private final String RUTA_USUARIOSJSON = "src/main/resources/usuarios.json";

    /*Retorna el usuario actual del juego */
    public UsuarioModel getUsuarioActual() {
        return this.usuarioActual;
    }

    /* carga los usuarios del json en map y lo agrega, luego lo guarda en el json */
    public UsuarioModel guardarUsuario(UsuarioModel usuario) {
        Map<String, UsuarioModel> usuarios = cargarUsuarios();

        // convertir el nombre en minuscula.    
        usuario.setNombre(usuario.getNombre().toLowerCase());
        // Actualiza el usuario en el mapa. (guarda el nombre y el objeto)
        usuarios.put(usuario.getNombre(), usuario);
        // Guarda el mapa actualizado de usuarios.
        guardarUsuarios(usuarios);
        // el usuario actual es el enviado en el HTTP
        usuarioActual = usuario;
        return usuario;
    }

    /*carga el json y retorna los usuarios en un map  */
    private Map<String, UsuarioModel> cargarUsuarios() {
        Map<String, UsuarioModel> usuarios;
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            usuarios = objectMapper.readValue(new File(RUTA_USUARIOSJSON),
                    new TypeReference<Map<String, UsuarioModel>>(){});
        } catch (IOException e) {
            e.printStackTrace();
            usuarios = new HashMap<>();
        }

        return usuarios;
    }


    /*guarda los usuarios del map en el json */
    private void guardarUsuarios(Map<String, UsuarioModel> usuarios) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            objectMapper.writeValue(new File(RUTA_USUARIOSJSON), usuarios);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*muestra el nombre del usuario actual */
    public String mostrarUsuario() {
        if (usuarioActual == null) {
            return "";
        }
        
        return usuarioActual.getNombre();
    }

}

