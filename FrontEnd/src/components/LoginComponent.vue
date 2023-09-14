<template>
    <div>
      <h2>Iniciar Sesión</h2>
      <form @submit="handleLogin">
        <div>
          <label for="email">Email:</label>
          <input type="email" id="email" v-model="email" required />
        </div>
        <div>
          <label for="password">Contraseña:</label>
          <input type="password" id="password" v-model="password" required />
        </div>
        <div>
          <button type="submit" class="btn">Iniciar Sesión</button>
        </div>
      </form>
    </div>
  </template>
  
  <script setup>
import { ref } from 'vue';
import loginService from '@/services/LoginService.js';
import useTokenStore from '@/services/TokenStore.js';
// import { useRoute, useRouter } from 'vue-router';

const email = ref('');
const password = ref('');

const tokenStore = useTokenStore();
// const route = useRoute();
// const router = useRouter();

const handleLogin = async () => {
  try {
    const token = await loginService.login(email.value, password.value);

    // Imprimir el token en la consola
    console.log('Token de autenticación:', token);

    // Almacena el token en el store de token
    tokenStore.setToken(token);

    // Redirige al usuario a la página de pacientes después del inicio de sesión
    // route.push('/patients');

  } catch (error) {
    console.error('Error de inicio de sesión:', error);
    // Maneja los errores de inicio de sesión según sea necesario.
  }
};
</script>

  