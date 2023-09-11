<template>
    <div>
      <h1>Detalles del Paciente</h1>
      <div class="patient-details">
        <h2>Paciente: {{ patient.patientName }} {{ patient.patientLastName }}</h2>
        <p>Fecha de Consulta: {{ patient.consultationDate }}</p>
        <p>Tipo de Dolor: {{ patient.painType }}</p>
      </div>
      <router-link :to="`/patients/${patient.id}/edit`">Editar</router-link>
      <router-link :to="`/patients/${patient.id}`">Historial</router-link>
    </div>
  </template>
  
  <script setup>
  import { defineProps } from 'vue';
  
  const { patient } = defineProps(['patient']);
  </script>
  
  <style scoped>
  .patient-details {
    border: 1px solid #ccc;
    padding: 10px;
    margin: 10px;
    background-color: #f9f9f9;
  }
  </style>
  