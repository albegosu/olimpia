<script setup>
    import { RouterLink } from 'vue-router'
</script>

<template>
    <nav>
        <p>Hi! I'm NavBar</p>
        <RouterLink to="/"></RouterLink>
    </nav>
</template>

<style scoped>
    nav {
        display: flex;
    }
    img {
    width: 100px;
  }
</style>