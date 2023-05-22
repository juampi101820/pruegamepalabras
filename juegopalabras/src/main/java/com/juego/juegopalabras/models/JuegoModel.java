package com.juego.juegopalabras.models;

import java.util.List;

public class JuegoModel {

    /*atributos */
    private int dificultad;
    private int puntaje;
    private List<String> palabrasNivel;
    private List<String> palabrasRecordar;

    /*metodos */
    public int getDificultad() {
        return dificultad;
    }
    public void setDificultad(int dificultad) {
        this.dificultad = dificultad;
    }
    public int getPuntaje() {
        return puntaje;
    }
    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }
    public List<String> getPalabrasNivel() {
        return palabrasNivel;
    }
    public void setPalabrasNivel(List<String> palabrasNivel) {
        this.palabrasNivel = palabrasNivel;
    }
    public List<String> getPalabrasRecordar() {
        return palabrasRecordar;
    }
    public void setPalabrasRecordar(List<String> palabrasRecordar) {
        this.palabrasRecordar = palabrasRecordar;
    }
}
