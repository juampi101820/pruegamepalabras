package com.juego.juegopalabras.models;

public class UsuarioModel {
    /*atributos */
    private String nombre;
    private int dificultad = 1;
    /*metodos */

    // Getter y setter para nombre
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // Getter y setter para dificultad
    public int getDificultad() {
        return dificultad;
    }
    public void setDificultad(int dificultad) {
        this.dificultad = dificultad;
    }
    
}
