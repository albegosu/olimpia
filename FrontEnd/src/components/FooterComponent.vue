<script setup>
    import { RouterLink } from 'vue-router'
</script>

<template>
    <p class="footer_location">Gijón, 2024 &reg</p>
    <RouterLink to="/">
        <img class="footer__logo" src="../assets/img/Logo_olimpia.png" alt="Logo Olimpia">
    </RouterLink>
    <ul class="footer__menu">
        <li class="footer__menu--item"><RouterLink to="/espacio">Espacio</RouterLink></li>
        <li class="footer__menu--item"><RouterLink to="/privated">Área Privada</RouterLink></li>
        <li class="footer__menu--item"><RouterLink to="/blog">Blog</RouterLink></li>
        <li class="footer__menu--item"><RouterLink to="/contacto">Contacto</RouterLink></li>
    </ul>
</template>
<style>
.footer__location {
    font-style: italic;
}
.footer__logo {
    height: 3vh;
    margin-left: 6vw;
}
.footer__menu{
    display: flex;
    gap: 2vw;
}
.footer__menu--item {
    list-style: none;
}
.footer__menu--item a{
    text-decoration: none;
    color: var(--green-color);
    transition: 0.3s;
}
.footer__menu--item a:hover{
    text-decoration: none;
    color: white;
    letter-spacing: 0.2rem;
}
</style>