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
    <form @submit.prevent="enviarFormulario">
        <div>
        <label for="nombre">Nombre:</label>
        <input type="text" id="nombre" v-model="nombre" required>
        </div>
        <div>
        <label for="apellido">Apellido:</label>
        <input type="text" id="apellido" v-model="apellido" required>
        </div>
        <div>
        <label for="telefono">Teléfono de contacto:</label>
        <input type="tel" id="telefono" v-model="telefono" required>
        </div>
        <div>
        <label for="correo">Correo electrónico:</label>
        <input type="email" id="correo" v-model="correo" required>
        </div>
        <div>
        <label for="dolor">Dolor:</label>
        <select id="dolor" v-model="dolor">
            <option value="espalda">Espalda</option>
            <option value="cuello">Cuello</option>
            <option value="hombro">Hombro</option>
            <option value="rodilla">Rodilla</option>
        </select>
        </div>
        <button type="submit">Enviar</button>
    </form>
</template>

  