<script setup>
    import { RouterLink } from 'vue-router'
</script>

<template>
    <nav class="nav">
        <RouterLink to="/">
            <img class="nav__logo" src="../assets/img/Logo_olimpiaIcon.png" alt="Logo Olimpia">
        </RouterLink>
        <ul class="nav__menu">
            <li class="nav__menu--item"><RouterLink to="/manos">Manos</RouterLink></li>
            <li class="nav__menu--item"><RouterLink to="/espacio">Espacio</RouterLink></li>
            <li class="nav__menu--item"><RouterLink to="/tecnicas">Técnicas</RouterLink></li>
            <li class="nav__menu--item"><RouterLink to="/blog">Blog</RouterLink></li>
        </ul>
    </nav>
</template>

<style scoped>
    .nav {
        display: flex;
        justify-content: space-between;
        padding: 1rem;
        margin-right: 1rem;
    }
    .nav__logo {
        height: 6vh;
    }
    .nav__menu{
        display: flex;
        gap: 3vw;
        align-items: center;
    }
    .nav__menu--item {
        list-style: none;
    }
    .nav__menu--item a{
        text-decoration: none;
        color: var(--green-color);
    }
    .nav__menu--item a:hover{
        text-decoration: none;
        color: white;
    }

</style>