package com.juego.juegopalabras.services;

import org.springframework.stereotype.Service;
import com.juego.juegopalabras.models.JuegoModel;

import java.util.ArrayList;
import java.util.List;

@Service
public class JuegoService {

    private final GeneraPalabrasService generaPalabrasService;
    private JuegoModel juegoActual;

    public JuegoService(GeneraPalabrasService generaPalabrasService) {
        this.generaPalabrasService = generaPalabrasService;
    }

    /* crea el juego con una dificutal y las palabras, retorna el juego */
    public JuegoModel iniciarJuego() {
        juegoActual = new JuegoModel();
        // se agrega +1 a la dificultad
        Adddificultad();
        asignarPalabrasPorNivel();
        return juegoActual;
    }

    /* ejecuta la funcion de generar palabrar de acuerdo al nivel actual */
    public void asignarPalabrasPorNivel() {
        int dificultad = juegoActual.getDificultad();
        switch (dificultad) {
            case 1:
                generarPalabras(10, 20);
                break;
            case 2:
                generarPalabras(20, 40);
                break;
            case 3:
                generarPalabras(25, 50);
                break;
            case 4:
                generarPalabras(30, 60);
                break;
            case 5:
                generarPalabras(35, 70);
                break;
            case 6:
                generarPalabras(40, 80);
                break;
            case 7:
                generarPalabras(50, 100);
                break;
            case 8:
                generarPalabras(60, 120);
                break;
            case 9:
                generarPalabras(70, 140);
                break;
            case 10:
                generarPalabras(100, 200);
                break;
            default:
                throw new IllegalArgumentException("Dificultad inválida: " + dificultad);
        }
    }

    /* se crean una cantidad de palabras por nivel y a recordar */
    public void generarPalabras(int cantRecordar, int cantNivel) {
        List<String> palabrasNivel = generaPalabrasService.generarPalabrasAleatorias(cantNivel);
        List<String> palabrasRecordar = new ArrayList<>(palabrasNivel.subList(0, cantRecordar));

        juegoActual.setPalabrasRecordar(palabrasRecordar);
        juegoActual.setPalabrasNivel(palabrasNivel);
    }

    /* agregar +1 a la dificultad */
    public JuegoModel Adddificultad() {
        juegoActual.setDificultad(juegoActual.getDificultad() + 1);
        return juegoActual;
    }

    
    
}
