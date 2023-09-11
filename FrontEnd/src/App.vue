<script setup>
import { RouterView } from 'vue-router'
import Navbar from './components/NavbarComponent.vue'
import FooterComponent from './components/FooterComponent.vue'
</script>

<template>
  <header>
    <Navbar />
  </header>
  <main>
    <RouterView />
  </main>
  <footer>
    <FooterComponent />
  </footer>
</template>

<style scoped>
img {
  width: 100px;
}
</style>
