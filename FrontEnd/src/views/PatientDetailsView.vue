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
    <router-link v-if="patient" :to="`/patients/${patient.id}/edit`">Editar</router-link>
    <router-link v-if="patient" :to="`/patients`">Volver</router-link>
  </div>
</template>

<script setup>
import { ref, onMounted } from 'vue';
import PatientData from '@/services/PatientData';
import { useRoute } from 'vue-router';

const route = useRoute(); // Utiliza useRoute para acceder a la ruta actual
const patient = ref(null); // Inicializa patient como null

const fetchPatientDetails = async () => {
  const patientId = route.params.id; // Obtén el ID del paciente desde la ruta actual
  try {
    const response = await PatientData.getById(patientId);
    patient.value = response.data; // Asigna los datos del paciente a patient
  } catch (error) {
    console.error(error);
  }
};

onMounted(fetchPatientDetails);
</script>

<style scoped>
.patient-details {
  border: 1px solid #ccc;
  padding: 10px;
  margin: 10px;
  background-color: #f9f9f9;
}
</style>
