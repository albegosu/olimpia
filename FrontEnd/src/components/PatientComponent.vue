<script setup>
import { defineProps } from 'vue';
import { RouterLink } from 'vue-router';

const { patient } = defineProps(['patient']);
</script>

<template>
  <div class="patientCard">
    <h1 class="patientCard__title">Detalles del Paciente</h1>
    <RouterLink :to="`/patients/${patient.id}`">
      <div class="patientCard__details">
        <h2>Paciente: {{ patient.patientName }} {{ patient.patientLastName }}</h2>
        <p>Fecha de primera consulta: {{ patient.consultationDate }}</p>
        <p>Tipo de Dolor: {{ patient.painType }}</p>
      </div>
  </RouterLink>
    <div class="btn__group">
      <RouterLink :to="`/patients/${patient.id}/edit`" class="btn">Editar</RouterLink>
      <RouterLink :to="`/patients/${patient.id}`" class="btn">Historial</RouterLink>
    </div>
  </div>
</template>

<style scoped>
.patientCard{
  max-width: 20vw;

  display: flex;
  flex-direction: column;
  align-items: center;
}
@media (max-width: 1250px) {
  .patientCard{
    max-width: 50vw;
  }
}
@media (max-width: 750) {
  .patientCard{
    width: 80vw;
  }
}
.patientCard__details {
  border: 1px solid #ccc;
  border-radius: 0.2rem;
  padding: 10px;
  margin: 10px;
}
</style>
  