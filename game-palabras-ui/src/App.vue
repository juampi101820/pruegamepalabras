<!-- App.vue -->
<template>
  <div id="app">
    <HeaderComponent />
    <UsuarioComponent />
    <JuegoComponent />
  </div>
</template>

<script>
import HeaderComponent from './components/Header.vue';
import UsuarioComponent from './components/Usuario.vue';
import JuegoComponent from './components/Juego.vue';

export default {
  name: 'App',
  components: {
    HeaderComponent,
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
  color: #ffffff;
}

body{
  background-color: #3A3A3A;
}
</style>
