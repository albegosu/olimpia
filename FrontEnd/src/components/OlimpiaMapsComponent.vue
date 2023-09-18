
<script setup>
import { ref } from "vue";
import { GoogleMap, Marker } from "vue3-google-map";
import { apiKey } from "../config/config";

const center = ref({ lat: 43.52602062493763, lng: -5.683527164624468 });
</script>

<template>
  <GoogleMap :api-key="apiKey" :center="center" :zoom="15">
    <Marker :options="{ position: center }" />
  </GoogleMap>
</template>