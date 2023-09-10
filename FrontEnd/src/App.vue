<script setup>
import { RouterView } from 'vue-router'
import Navbar from './components/NavbarComponent.vue'
import Footer from './components/FooterComponent.vue'
</script>

<template>
  <header>
    <Navbar />
  </header>
  <RouterView />
  <Footer></Footer>
</template>

<style scoped>
  img {
    width: 100px;
  }
</style>
