<script setup>
import { defineProps } from 'vue';
// import { RouterLink } from 'vue-router';

const { post } = defineProps(['post']);
</script>

<template>
<div class="patientCard">
  <img :src="post.imgUrl" alt="Post Image">
  <section class="patientCard__details">
    <h2>{{ post.blogTitle }}</h2>
    <span>{{ post.blogSubtitle }}</span>
    <p> {{ post.blogMessage }}</p>
  </section>
</div>
</template>

<style>
.patientCard {
  border: 1px solid #ccc;
  border-radius: 0.5rem;
  margin: 10px;
  display: flex;
  flex-direction: column;
  gap: 1rem;
}
.patientCard img {
  max-width: 100%;
  border-radius: 0.5rem 0.5rem 0 0;
}
.patientCard__details {
  padding: 1rem;
}
.patientCard__details h2 {
  font-size: 1.5rem;
  font-weight: bolder;
}
.patientCard__details span {
  color: var(--green-color);
  font-weight: bold;
}
.patientCard__details p {
  margin-top: 1rem;

}
</style>
  