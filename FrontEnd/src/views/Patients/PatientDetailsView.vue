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

const patientId = route.params.id;

onMounted(() => {
  const foundPatient = patientDataStore.getPatientDataList[patientId];
  if (foundPatient) {
    patient.value = foundPatient;
  } else {
    fetchPatientDetails(patientId);
  }
});

const fetchPatientDetails = async (id) => {
  try {
    const response = await PatientData.getById(id);
    const data = response.data;

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
  <div class="detailsView">
    <h1>Detalles del Paciente</h1>
    <div class="detailsView__details" v-if="patient">
      <h2>Paciente: {{ patient.patientName }} {{ patient.patientLastName }}</h2>
      <p>Fecha de Consulta: {{ patient.consultationDate }}</p>
      <p>Edad: {{ patient.age }}</p>
      <p>Número de contacto: {{ patient.tel }}</p>
      <p>Tipo de Dolor: {{ patient.painType }}</p>
      <p>Descripción: {{ patient.description }}</p>
    </div>
    <div class="btn__group">
      <RouterLink v-if="patient" :to="`/patients/${patient.id}/edit`" class="btn">Editar</RouterLink>
      <RouterLink v-if="patient" :to="`/patients`" class="btn">Volver</RouterLink>
    </div>
  </div>
</template>

<style scoped>
.detailsView {
  display: flex;
  flex-direction: column;
  align-items: center;
}
.detailsView__details {
  border: 1px solid #ccc;
  padding: 40px;
  margin: 10px;
  width: 80vw;
  background-color: rgba(255, 255, 255, 0.5)
}
</style>