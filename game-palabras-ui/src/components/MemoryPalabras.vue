<template>
    <!-- memorizar las palabras -->
  <div id="juego" class="baseJuego container">
    <div class="flex-container">
      <h1>Memoriza</h1>
      <h1 class="palabra">{{ palabra }}</h1>
    </div>
  </div>
</template>

<script>
import apiService from '@/apiService'; // ajusta la ruta según donde tengas el archivo

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
      const timeMemory = 5000;

      apiService.iniciarJuego()
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
          }, timeMemory);
        })
        .catch((error) => {
          console.error(error);
        });
    },
  },
  mounted() {
    this.iniciar();
  },
};
</script>