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
        <div class="form-group">
          <button type="submit" class="btn btn-primary">Guardar</button>
          <RouterLink to="/patients">Volver</RouterLink>
        </div>
      </form>
    </div>
  </template>
  
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
  
  <style scoped>
  /* Agrega estilos de CSS según tus necesidades para la vista de creación de pacientes */
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
  </style>
  