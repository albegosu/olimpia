<template>
  <div>
    <h1>Lista de Pacientes</h1>
    <div>
      <input v-model="searchTerm" type="text" placeholder="Buscar por nombre o apellido" @keyup.enter="filterPatients">
      <button @click="filterPatients">Filtrar</button>
    </div>
    <div v-for="patient in filteredPatients" :key="patient.id">
      <PatientComponent :patient="patient" />
    </div>
  </div>
</template>

<script setup>
import { ref, onMounted } from 'vue';
import PatientData from '@/services/PatientData';
import PatientComponent from '../components/PatientComponent.vue';
import { usePatientDataStore } from '../services/PiniaStore';

const patients = ref([]);
const searchTerm = ref('');
const filteredPatients = ref([]);

const patientDataStore = usePatientDataStore(); // Obtén el módulo de Pinia

const fetchPatients = async () => {
  try {
    const response = await PatientData.getAll();
    patients.value = response.data;
    // Almacena los pacientes en Pinia
    patientDataStore.setPatientData(patients.value);
    // Mostrar todos los pacientes al cargar la página
    filteredPatients.value = patients.value;
  } catch (error) {
    console.error(error);
  }
};

onMounted(fetchPatients);

const filterPatients = () => {
  if (searchTerm.value.trim() === '') {
    // Si el campo de búsqueda está vacío, muestra todos los pacientes
    filteredPatients.value = patients.value;
  } else {
    // Filtra la lista de pacientes solo si hay un término de búsqueda
    const filtered = patients.value.filter(patient => {
      const fullName = `${patient.patientName} ${patient.patientLastName}`;
      return fullName.toLowerCase().includes(searchTerm.value.toLowerCase());
    });
    filteredPatients.value = filtered;
  }
};
</script>
