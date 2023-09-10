<script setup>
import { RouterView } from 'vue-router'
import Navbar from './components/NavbarComponent.vue'
import Footer from './components/FooterComponent.vue'
import OlimpiaMapsComponent from './components/OlimpiaMapsComponent.vue';
</script>

<template>
  <header>
    <Navbar />
  </header>
  <RouterView />
  <OlimpiaMapsComponent />
  <Footer></Footer>
</template>

<style scoped>
  img {
    width: 100px;
  }
</style>
