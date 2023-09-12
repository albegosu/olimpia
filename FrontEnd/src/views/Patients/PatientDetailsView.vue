<script setup>
import { ref, onMounted } from 'vue';
import { useRoute } from 'vue-router';
import PatientData from '@/services/PatientData';
import { usePatientDataStore } from '@/services/PiniaStore';

const route = useRoute();
const patientDataStore = usePatientDataStore();

const patientId = route.params.id;
const patient = ref(null);

// Obtén la lista completa de pacientes desde Pinia
const patientList = patientDataStore.getPatientDataList;

// Obtén el paciente por ID utilizando find
onMounted(() => {
  const foundPatient = patientList.find(item => item.id === patientId);
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
      <router-link v-if="patient" :to="`/patients/${patient.id}/edit`" class="btn">Editar</router-link>
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