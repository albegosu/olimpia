<script setup>
import { ref } from 'vue';
import { useRouter } from 'vue-router';

import ContactData from '@/services/ContactData';

import Swal from 'sweetalert2';

const router = useRouter();

const nombre = ref('');
const apellido = ref('');
const telefono = ref('');
const correo = ref('');
const dolor = ref('');

const enviarFormulario = async () => {
  const formData = {
    nombre: nombre.value,
    apellido: apellido.value,
    telefono: telefono.value,
    correo: correo.value,
    dolor: dolor.value
  };

  try {
    // Llama al servicio para crear un nuevo paciente tras el alert de confirmación
    const response = await ContactData.create(formData);
    // CLG PRUEBAS
    console.log(response);

    Swal.fire({
              position: 'center',
              icon: 'success',
              title: 'Formulario de contacto enviado correctamente',
              showConfirmButton: false,
              timer: 1500
            })
    setTimeout(() => {
      router.push('/');
    }, 1500);
  } catch (error) {
    console.error(error);
  }
};
</script>

<template>
    <div class="newContactForm">
      <h1 class="form__header">¡Contacta con nosotros!</h1>
      <form @submit.prevent="enviarFormulario">
        <div class="form">
          <div class="form__group">
          <label for="nombre" class="form__label">Nombre:</label>
          <input type="text" id="nombre" v-model="nombre" class="form-control form__input" required>
          </div>
          <div class="form__group">
          <label for="apellido" class="form__label">Apellido:</label>
          <input type="text" id="apellido" v-model="apellido" class="form-control form__input" required>
          </div>
          <div class="form__group">
          <label for="telefono" class="form__label">Teléfono de contacto:</label>
          <input type="tel" id="telefono" v-model="telefono" class="form-control form__input" required>
          </div>
          <div class="form__group">
          <label for="correo" class="form__label">Correo electrónico:</label>
          <input type="email" id="correo" v-model="correo" class="form-control form__input" required>
          </div>
          <div class="form__group"> 
          <label for="dolor" class="form__label">Dolor:</label>
          <select id="dolor" v-model="dolor" class="form-control form__input">
              <option value="espalda">Cadera</option>
              <option value="cuello">Cuello</option>
              <option value="cuello">Espalda</option>
              <option value="hombro">Hombro</option>
              <option value="rodilla">Tobillo</option>
          </select>
          </div>
          <div>
            <button type="submit" class="btn">Enviar</button>
          </div>
        </div>
      </form>
    </div>
</template>

<style>
.newContactForm{
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
}
</style>

  