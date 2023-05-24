<template>
  <!-- header con el nombre del usuario, nivel y el boton de informacion del juego-->
  <header id="header" class="header-container">
    <h4 class="nameuser">{{ nombre }}</h4>
    <button type="button" class="btn btn-danger">Informacion</button>
  </header>
</template>
  
<script>
import axios from "axios";

export default {
  data() {
    return {
      nombre: "",
    };
  },
  methods: {
    mostrarUsuario() {
      axios
        .get("http://localhost:8080/usuario/nameUser")
        .then((respuesta) => {
          this.nombre = respuesta.data;
        })
        .catch((error) => {
          console.error(error);
        });
    },
  },
  mounted() {
    this.mostrarUsuario();
  },
};
</script>
  
  
  <style>
header {
  background-color: #232323;
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.4);
  position: fixed;
  top: 0;
  left: 0;
  width: 100%;
  height: 60px;
  z-index: 9999;
}

.header-container {
  display: flex;
  justify-content: space-between;
  align-items: center;
  padding: 15px;
}

</style>