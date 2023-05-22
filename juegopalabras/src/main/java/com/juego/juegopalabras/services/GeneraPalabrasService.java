package com.juego.juegopalabras.services;

import org.springframework.stereotype.Service;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class GeneraPalabrasService {

    private static final String RUTA_ARCHIVO_PALABRAS = "C:\\Users\\JPMARIN\\OneDrive - STF Group S.A\\Escritorio\\JPMC\\Aprendiendo\\GAME-PALABRAS\\juegopalabras\\src\\main\\java\\com\\juego\\juegopalabras\\services\\palabras.txt";

    public List<String> generarPalabrasAleatorias(int cantidad) {
        try {
            List<String> todasLasPalabras = Files.readAllLines(Paths.get(RUTA_ARCHIVO_PALABRAS));
            Random random = new Random();
            List<String> palabrasAleatorias = new ArrayList<>();

            for (int i = 0; i < cantidad; i++) {
                int indicePalabraAleatoria = random.nextInt(todasLasPalabras.size());
                palabrasAleatorias.add(todasLasPalabras.get(indicePalabraAleatoria));
            }

            return palabrasAleatorias;
        } catch (IOException e) {
            throw new RuntimeException("No se pudo leer el archivo de palabras", e);
        }
    }
}