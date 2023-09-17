<script setup>
import { ref, onMounted } from 'vue';
import { useRoute, useRouter } from 'vue-router';

import PatientData from '@/services/PatientData';
import { usePatientDataStore } from '@/services/PiniaStore'; 

import Swal from 'sweetalert2';

const route = useRoute();
const router = useRouter();

const patientDataStore = usePatientDataStore();

const editedPatient = ref({});

// Accede al ID de la URL
const patientId = route.params.id;

// Copia los datos del paciente original para la edición
onMounted(async () => {
  const patient = patientDataStore.getPatientDataList[patientId];
  if (patient) {
    editedPatient.value = { ...patient }; // Copia los datos para evitar mutaciones no deseadas
    console.log(editedPatient.patientName);
  } else {
    // Si el paciente no está en Pinia, intenta cargarlo desde la API
    await fetchPatientDetails(patientId);
  }
});

const fetchPatientDetails = async (id) => {
  try {
    const response = await PatientData.getById(id);
    const data = response.data;
    // Almacena los datos del paciente en Pinia
    patientDataStore.setPatientData(data);
    editedPatient.value = { ...data }; // Copia los datos para evitar mutaciones no deseadas

  } catch (error) {
    console.error(error);
    Swal.fire({
            position: 'center',
            icon: 'error',
            title: `${error}`,
            showConfirmButton: false,
            timer: 1500
          })
  }
};

const updatePatient = async () => {
  try {
    const { id, patientName, patientLastName, description, painType, tel, age } = editedPatient.value;
    // Crear un objeto con los campos que necesitas para la actualización
    const updatedData = { id, patientName, patientLastName, description, painType, tel, age};

    await Swal.fire({
        title: '¿Quiere guardar los cambios?',
        icon: 'warning',
        showCancelButton: true,
        confirmButtonColor: 'var(--green-color)',
        cancelButtonColor: 'var(--salmon-color)',
        confirmButtonText: 'Guardar'
      }).then((result) => {
        if (result.isConfirmed) {
          // Enviar una solicitud al servicio para actualizar la información
          PatientData.updateID(editedPatient.value.id, updatedData);
          
          // Actualiza los datos del paciente en Pinia
          patientDataStore.updatePatient(updatedData);
          console.log(updatedData);

          Swal.fire({
          position: 'center',
          icon: 'success',
          title: 'Usuario actualizado correctamente',
          showConfirmButton: false,
          timer: 1500
        })
        }
      })
    } catch (error) {
      console.error(error);
    }
    // Redirige a la vista de detalles del paciente después de la actualización
    await router.push('/patients');
};
</script>

<template>
  <div class="patientEditView">
    <p>Fecha primera consulta: {{ editedPatient.consultationDate }}</p>
    <form @submit.prevent="updatePatient">
      <div class="form">
        <div class="form__group">
          <label for="patientName">Nombre:</label>
          <input v-model="editedPatient.patientName" type="text" id="patientName" class="form__input" required>
        </div>
        <div class="form__group">
          <label for="patientLastName">Apellido:</label>
          <input v-model="editedPatient.patientLastName" type="text" id="patientLastName" class="form__input" required>
        </div>
        <div class="form__group">
          <label for="age">Edad paciente:</label>
          <input v-model="editedPatient.age" type="text" id="age" class="form__input" required>
        </div>
        <div class="form__group">
          <label for="painType">Zona dolor:</label>
          <select v-model="editedPatient.painType" id="painType" class="form__input" required>
            <option value="CUELLO">CUELLO</option>
            <option value="ESPALDA">ESPALDA</option>
            <option value="HOMBRO">HOMBRO</option>
            <option value="TOBILLO">TOBILLO</option>
            <option value="CADERA">CADERA</option>
          </select>
        </div>
        <div class="form__group">
          <label for="tel">Número de contacto:</label>
          <textarea v-model="editedPatient.tel" id="tel" class="form__input" required></textarea>
        </div>
        <div class="form__group">
          <label for="description">Descripción:</label>
          <textarea v-model="editedPatient.description" id="description" class="form__input" required></textarea>
        </div>
      </div>
      <div class="btn__group">
        <button type="submit" class="btn">Guardar</button>
        <RouterLink :to="`/patients`" class="btn">Volver</RouterLink>
      </div>
    </form>
  </div>
</template>

<style scoped>
.patientEditView {
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
}
</style>
