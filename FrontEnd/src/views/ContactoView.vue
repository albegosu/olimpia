<script setup>
import { ref } from 'vue';
import { useRouter } from 'vue-router';

import ContactData from '@/services/ContactData';

import Map from '@/components/OlimpiaMapsComponent.vue'
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
    const response = await ContactData.create(formData);
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
  <div>
  <img class="home__banner" src="../assets/img/banner_CONTACTO.png" alt="Banner contacto">
  <div class="contactView">
    <div class="contactView__whats">
      <h2>Pide cita directamente:</h2>
      <a href="https://wa.me/623971921/?text=%C2%A1Hola!%20Quer%C3%ADa%20pedir%20una%20cita." target="_blank">
        <img src="../assets/img/WhatsAppButtonGreenMedium.png" alt="Whats Link" class="contactView__whats--icon">
      </a>
    </div>
    <div class="contactView__form">
      <h2 class="form__header">¡Contacta con nosotros!</h2>
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
  </div>
  <h2>¿Dónde estamos?</h2>
  <Map class="map"/>
</div>
</template>

<style scoped>
.home__banner{
  width: 100%;
}
.contactView {
  display: flex;
  padding: 5rem;
}
.contactView__form {
  flex: 40%;
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
}
.contactView__whats {
  display: flex;
  flex-direction: column;
  align-items: center;
}
.contactView__whats h2 {
  font-size: 2rem;
  color: black;
}
.contactView__whats--icon{
  width: 10vw;
  margin-top: 2rem;
}
.btn {
  margin: 2rem;
}
h2 {
  font-size: 3rem;
  font-weight: bolder;
  color: var(--green-color);
  text-align: center;
  margin-bottom: 2rem;
}
.map{
  width: 100%; 
  height: 500px;
}
</style>

  