<!-- Juego.vue -->
<template>
  <div>
    <h1>Juego</h1>
    <h1 class="palabra">{{ palabra }}</h1>
    <button @click="iniciarJuego">Iniciar juego</button>
  </div>
</template>
  
  <script>
import axios from "axios";
export default {
  data() {
    return {
      palabra: "",
      indicePalabraActual: 0,
    };
  },
  methods: {
    iniciarJuego() {
      axios
        .post("http://localhost:8080/juego/iniciar", {
          // Incluye aquí cualquier otro atributo que necesites en tu objeto JuegoModel
        })
        .then((response) => {
          this.juego = response.data;
          console.log(response.data);
          if (this.juego.palabrasRecordar && this.juego.palabrasRecordar.length > 0) {
            this.palabra = this.juego.palabrasRecordar[this.indicePalabraActual];
            this.indicePalabraActual++;
          }

          setInterval(() => {
            if (
              this.juego.palabrasRecordar &&
              this.juego.palabrasRecordar.length > this.indicePalabraActual
            ) {
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
.palabra{
  background-color: rgb(248, 248, 248);
  opacity: 0.4;
}
</style>
  