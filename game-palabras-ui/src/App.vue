<!-- App.vue -->
<template>
  <div id="app">
    <UsuarioComponent />
    <JuegoComponent />
  </div>
</template>

<script>
import UsuarioComponent from './Usuario.vue';
import JuegoComponent from './Juego.vue';

export default {
  name: 'App',
  components: {
    UsuarioComponent,
    JuegoComponent
  }
}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #b6b6b6;
}

body{
  background-color: #181619;
}
</style>
