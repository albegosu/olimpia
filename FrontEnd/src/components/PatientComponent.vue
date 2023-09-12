<script setup>
import { defineProps } from 'vue';
import { RouterLink } from 'vue-router';

const { patient } = defineProps(['patient']);
</script>

<template>
  <div class="patientCard">
    <h1 class="patientCard__title">Detalles del Paciente</h1>
    <div class="patientCard__details">
      <h2>Paciente: {{ patient.patientName }} {{ patient.patientLastName }}</h2>
      <p>Fecha de primera consulta: {{ patient.consultationDate }}</p>
      <p>Tipo de Dolor: {{ patient.painType }}</p>
    </div>
    <div class="patientCard__btn">
      <RouterLink :to="`/patients/${patient.id}/edit`" class="btn">Editar</RouterLink>
      <RouterLink :to="`/patients/${patient.id}`" class="btn">Historial</RouterLink>
    </div>
  </div>
</template>

<style scoped>
.patientCard__details {
  border: 1px solid #ccc;
  border-radius: 0.2rem;
  padding: 10px;
  margin: 10px;
}
.btn{
  padding: 0.5rem;
  background-color: var(--green-color);
  border-radius: 0.4rem;
  color: var(--pink-color);
  font-size: 1.1rem;
}
.btn:hover{
  color: whitesmoke;
  letter-spacing: 0.05rem;
  cursor: pointer;
}
.patientCard__btn{
  display: flex;
  gap: 1rem;
}
</style>
  