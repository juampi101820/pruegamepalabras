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
      axios
        .post("http://localhost:8080/juego/iniciar", {
          // Incluye aquí cualquier otro atributo que necesites en tu objeto JuegoModel
        })
        .then((respuesta) => {
          this.juego = respuesta.data;
          console.log(this.juego);
          if (this.juego.palabrasRecordar.length > 0) {
            this.palabra = this.juego.palabrasRecordar[this.indicePalabraActual];
            this.indicePalabraActual++;
          }

          setInterval(() => {
            if (this.juego.palabrasRecordar.length > this.indicePalabraActual ) {
              this.palabra = this.juego.palabrasRecordar[this.indicePalabraActual];
              this.indicePalabraActual++;
            }
          }, 5000);
        })
        .catch((error) => {
          console.error(error);
        });
    },
  },
};
</script>

<style>
.baseJuego{
  border: 1px solid black;
  background-color: #332E2E;
  box-shadow: 10px 5px 10px rgba(0.5, 0.5, 0.5, 0.5);
  width: 982px;
  height: 638px;
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
  