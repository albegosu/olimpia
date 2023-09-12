<script setup>
import { defineProps } from 'vue';
// import { RouterLink } from 'vue-router';

const { post } = defineProps(['post']);
</script>

<template>
<div class="patientCard">
    <div class="patientCard__details">
      <h2>Entrada: {{ post.blogTitle }}</h2>
      <p> {{ post.blogMessage }}</p>
    </div>
    <!-- <div class="btn__group">
      <RouterLink :to="`/patients/${patient.id}/edit`" class="btn">Editar</RouterLink>
      <RouterLink :to="`/patients/${patient.id}`" class="btn">Historial</RouterLink>
    </div> -->
  </div>
</template>

<style scoped>
.patientCard__details {
  border: 1px solid #ccc;
  border-radius: 0.2rem;
  padding: 10px;
  margin: 10px;
}
</style>
  