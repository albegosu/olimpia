<script setup>
import { defineProps } from 'vue';
// import { RouterLink } from 'vue-router';

const { post } = defineProps(['post']);
</script>

<template>
<div class="patientCard">
  <img :src="post.imgUrl" alt="Post Image">
  <section>
    <h2>Entrada: {{ post.blogTitle }}</h2>
    <p> {{ post.blogMessage }}</p>
  </section>
</div>
</template>

<style>
.patientCard {
  border: 1px solid #ccc;
  border-radius: 0.2rem;
  padding: 10px;
  margin: 10px;
  display: flex;
  gap: 1rem;
}
.patientCard img {
  max-width: 20vw;
}
</style>
  