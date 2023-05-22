<!-- Usuario.vue -->
<template>
  <div>
    <span>{{ getNombreUser }}</span>
    <input
      type="text"
      v-model="nombreUsuario"
      placeholder="Nombre de usuario"
    />
    <button @click="guardarUsuario">Guardar</button>
  </div>
</template>
  
  <script>
import axios from "axios";
export default {
  data() {
    return {
      nombreUsuario: "",
      getNombreUser: "",
    };
  },
  methods: {
    guardarUsuario() {
      if (this.nombreUsuario.trim() !== "") {
        axios
          .post("http://localhost:8080/usuario/usuario", {
            nombre: this.nombreUsuario,
          })
          .then((response) => {
            this.mostrarUsuario();
          })
          .catch((error) => {
            console.error(error);
          });
      } else {
        alert("El nombre de usuario no puede estar vacío.");
      }
    },
    mostrarUsuario() {
      axios
        .get("http://localhost:8080/usuario/nameUser")
        .then((response) => {
          this.getNombreUser = response.data;
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
  