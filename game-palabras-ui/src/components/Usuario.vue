<!-- Usuario.vue -->
<template>
  <!-- boton registrar usuario-->
  <div>
    <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#registeruser">
      usuario
    </button>
  </div>

<!-- Modal registrar uusario -->
<div class="modal fade" ref="modaluser" id="registeruser" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog modal-dialog-centered modal-dialog-scrollable">
    <div class="modal-content">
      <div class="modal-header">
        <h1 class="modal-title fs-5" id="exampleModalLabel" style="color: black; font-weight: bold;">Ingresar Usuario</h1>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body">
        <h5 style="color: black; text-align: left;">Nombre</h5>
        <input type="text" v-model="nombreUsuario" class="form-control" placeholder="Nombre de usuario" />
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cerrar</button>
        <button type="button" @click="guardarUsuario" class="btn btn-primary">Guardar</button>
      </div>
    </div>
  </div>
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
          .then((respuesta) => {
            // cerrar el modal
            var modaluser = new bootstrap.Modal(this.$refs.modaluser)
            modaluser.hide();

            window.location.reload(); // Recargar la página
          })
          .catch((error) => {
            console.error(error);
          });
      } else {
        alert("El nombre de usuario no puede estar vacío.");
      }
    },
  },
  mounted() {},
};
</script>
  