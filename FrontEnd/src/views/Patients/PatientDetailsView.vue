<script setup>
import { ref, onMounted } from 'vue';
import { useRoute } from 'vue-router';
import { RouterLink } from 'vue-router';

import PatientData from '@/services/PatientData';
import { usePatientDataStore } from '@/services/PiniaStore';

import Swal from 'sweetalert2';

const route = useRoute();

const patientDataStore = usePatientDataStore();

const patient = ref(null);

//Obtener el ID desde la URL
const patientId = route.params.id;

// Obtén la lista completa de pacientes desde Pinia
const patientList = patientDataStore.getPatientDataList;

// Obtén el paciente por ID utilizando find
onMounted(() => {
  const foundPatient = patientDataStore.getPatientDataList[patientId];
  if (foundPatient) {
    patient.value = foundPatient;
  } else {
    // Si el paciente no está en Pinia, intenta cargarlo desde la API
    fetchPatientDetails(patientId);
  }
});

const fetchPatientDetails = async (id) => {
  try {
    const response = await PatientData.getById(id);
    const data = response.data;
    // Almacena los datos del paciente en Pinia
    patientDataStore.setPatientData(data);
    patient.value = data;
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
</script>

<template>
  <div>
    <h1>Detalles del Paciente</h1>
    <div class="patient-details" v-if="patient">
      <h2>Paciente: {{ patient.patientName }} {{ patient.patientLastName }}</h2>
      <p>Edad: {{ patient.age }}</p>
      <p>Fecha de Consulta: {{ patient.consultationDate }}</p>
      <p>Tipo de Dolor: {{ patient.painType }}</p>
      <p>Descripción: {{ patient.description }}</p>
    </div>
    <div class="btn__group">
      <RouterLink v-if="patient" :to="`/patients/${patientList.id}/edit`" class="btn">Editar</RouterLink>
      <router-link v-if="patient" :to="`/patients`" class="btn">Volver</router-link>
    </div>
  </div>
</template>

<style scoped>
.patient-details {
  border: 1px solid #ccc;
  padding: 10px;
  margin: 10px;
  background-color: #f9f9f9;
}
</style>