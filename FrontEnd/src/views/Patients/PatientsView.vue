<script setup>
import { ref, onMounted } from 'vue';
import PatientData from '@/services/PatientData';
import PatientComponent from '@/components/PatientComponent.vue';
import { usePatientDataStore } from '@/services/PiniaStore';
import { RouterLink } from 'vue-router';

const patients = ref([]);
const searchTerm = ref('');
const filteredPatients = ref([]);

// Obtén el módulo de Pinia
const patientDataStore = usePatientDataStore(); 

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

<template>
  <div class="patientsView">
    <div class="patientsView__header">
      <RouterLink to="/newpatient" class="btn btnAdd">Agregar Nuevo</RouterLink>
      <div class="filter">
        <input v-model="searchTerm" class="filter__input" type="text" placeholder="Buscar por nombre o apellido" @keyup.enter="filterPatients">
        <button @click="filterPatients" class="btn">Filtrar</button>
      </div>
    </div>
    <section class="patientList">
      <h1 class="patientList__title">Lista de Pacientes</h1>
      <div class="patientList__cards">
        <div class="patientList__cards--card" v-for="patient in filteredPatients" :key="patient.id">
          <PatientComponent :patient="patient" />
        </div>
      </div>
    </section>
  </div>
</template>

<style scoped>
.patientsView{
  display: flex;
  flex-direction: column;
}
.patientsView__header{
  display: flex;
  align-items: center;
  justify-content: center;
  gap: 7rem;
}
.filter{
  display: flex;
  justify-content: center;
  align-items: center;
  gap: 2rem;

  background-color: var(--lightsalmon-color);
  padding: 0.3rem;
  padding-right: 0.7rem;
  border-radius: 0.4rem;
}
.filter__input{
  padding: 1rem;
  background-color: transparent;
  min-width: 12vw;
  transition: 0.3s;
}
.filter__input::placeholder{
  color: whitesmoke;
}
.filter__input:focus{
  outline-color: transparent;
  outline-style: none;
  font-size: 1rem;
  min-width: 15vw;
}
.patientList{
  margin: 2rem;
}
.patientList__title{
  text-align: center;
  font-size: 2rem;
  font-weight: 700;
  color: black;
}
.patientList__cards{
  display: grid;
  grid-template-columns: 1fr 1fr;
}
.patientList__cards--card{
  margin: 1rem 3rem;
}
</style>
