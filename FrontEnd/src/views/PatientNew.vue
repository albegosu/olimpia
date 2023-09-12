<script setup>
  import { ref } from 'vue';
  import { useRouter } from 'vue-router';
  import PatientData from '@/services/PatientData';
  
  const router = useRouter();
  const newPatient = ref({
    patientName: '',
    patientLastName: '',
    age: '',
    painType: 'CUELLO',
    description: '',
  });
  
  const createPatient = async () => {
    try {
      // Llama al servicio para crear un nuevo paciente
      const response = await PatientData.create(newPatient.value);
  
      // Después de crear el paciente, puedes redirigir a la vista de lista de pacientes
      router.push('/patients');
    } catch (error) {
      console.error(error);
    }
  };
</script>

<template>
    <div>
      <h1>Agregar Nuevo Paciente</h1>
      <form @submit.prevent="createPatient">
        <div class="form-group">
          <label for="patientName">Nombre:</label>
          <input v-model="newPatient.patientName" type="text" id="patientName" class="form-control" required>
        </div>
        <div class="form-group">
          <label for="patientLastName">Apellido:</label>
          <input v-model="newPatient.patientLastName" type="text" id="patientLastName" class="form-control" required>
        </div>
        <div class="form-group">
          <label for="age">Edad paciente:</label>
          <input v-model="newPatient.age" type="text" id="age" class="form-control" required>
        </div>
        <div class="form-group">
          <label for="painType">Zona dolor:</label>
          <select v-model="newPatient.painType" id="painType" class="form-control" required>
            <option value="CUELLO">CUELLO</option>
            <option value="ESPALDA">ESPALDA</option>
            <option value="HOMBRO">HOMBRO</option>
            <option value="TOBILLO">TOBILLO</option>
            <option value="CADERA">CADERA</option>
          </select>
        </div>
        <div class="form-group">
          <label for="description">Descripción:</label>
          <textarea v-model="newPatient.description" id="description" class="form-control" required></textarea>
        </div>
        <div class="form-group btn__group">
          <button type="submit" class="btn">Guardar</button>
          <RouterLink to="/patients" class="btn">Volver</RouterLink>
        </div>
      </form>
    </div>
  </template>
  
  <style scoped>
  /* Agrega estilos de CSS según tus necesidades para la vista de creación de pacientes */
  </style>
  