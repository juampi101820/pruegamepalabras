<!-- Juego.vue -->
<template>
  <div id="juego" class="baseJuego container">
    <div class="flex-container">
      <h1>I know that word !!</h1>
      <h1 class="palabra">{{ palabra }}</h1>
      <button @click="iniciarJuego" class="btn btn-primary btn-lg">Iniciar juego</button>
      <img src="/cerebro.png" alt="Descripción de la imagen" />
    </div>
  </div>
</template>
  
  <script>
import axios from "axios";
export default {
  data() {
    return {
      palabra: "",
      indicePalabraActual: 0,
      palabraActual:"",
    };
  },
  methods: {
    iniciarJuego() {
      // recibe un numero como milisegundos, sirve para mostrar en pantalla las palabras a memorizar cada cierto tiempo
      const timeMemory = 5000;

      axios
        .post("http://localhost:8080/juego/iniciar", {
          // atributos que vaya a enviar (no envia nada)
        })
        .then((respuesta) => {
          this.juego = respuesta.data;
          console.log(this.juego);

          // valida si hay palabras en el array, si es asi entonces trae la primera y suma 1 al indice
          if (this.juego.palabrasRecordar.length > 0) {
            this.palabra = this.juego.palabrasRecordar[this.indicePalabraActual];
            this.indicePalabraActual++;
          }

          // ejecuta iniciarJuego cada cierto tiempo (param timeMemory)
          setInterval(() => {
            // valida si la longitud es mayor al indice, si es asi retorna la palabra.
            if (this.juego.palabrasRecordar.length > this.indicePalabraActual ) {
              this.palabra = this.juego.palabrasRecordar[this.indicePalabraActual];
              this.indicePalabraActual++;
            }
          }, timeMemory);
        })
        // si da error el post entonces lo muestra en consola.
        .catch((error) => {
          console.error(error);
        });
    },
  },
};
</script>

<style>
.baseJuego {
  border: 1px solid black;
  background-color: #332E2E;
  box-shadow: 10px 5px 10px rgba(0.5, 0.5, 0.5, 0.5);
  width: 982px;
  height: 638px;
}

@media (max-width: 992px) {
  .baseJuego {
    width: 80%;
    height: 70vh;
  }
}

.palabra{
  color: white;
  background-color: #5C5C5C;
}

.flex-container {
  display: flex;
  flex-direction: column;
  justify-content: space-between;
  align-items: center;
  height: 70vh; /* altura completa de la vista del navegador */
  padding: 4rem 0;
}

h1, .btn {
  margin: 1rem; /* Espacio alrededor de los elementos */
}
</style>
  