<script setup>
  import { ref } from 'vue';
  import { useRouter } from 'vue-router';
  import PatientData from '@/services/PatientData';
  import { usePatientDataStore } from '@/services/PiniaStore.js';

  const router = useRouter();
  const patientDataStore = usePatientDataStore();
  
  const newPatient = ref({
    patientName: '',
    patientLastName: '',
    age: '',
    painType: 'CUELLO',
    description: '',
    date: 'dd/mm/yyyy',
  });
  
  const createPatient = async () => {
    try {
      // Llama al servicio para crear un nuevo paciente
      const response = await PatientData.create(newPatient.value);
      const data = response.data;
      patientDataStore.setPatientData(data);

      // Después de crear el paciente, puedes redirigir a la vista de lista de pacientes
      router.push('/patients');
    } catch (error) {
      console.error(error);
    }
  };

  const currentDate = new Date();
  const time = currentDate.toLocaleTimeString([], { hour: '2-digit', minute: '2-digit' });
  const date = currentDate.toLocaleDateString([], { day: '2-digit', month: '2-digit', year: '2-digit' });

</script>

<template>
  <div class="newPatientView">
    <h1 class="form__header">Agregar nuevo Paciente</h1>
    <form @submit.prevent="createPatient">
      <div class="form">
        <div class="form__group">
          <label for="patientName" class="form__label">Nombre:</label>
          <input v-model="newPatient.patientName" type="text" id="patientName" class="form-control form__input" placeholder="Nombre paciente" required>
        </div>
        <div class="form__group">
          <label for="patientLastName">Apellido:</label>
          <input v-model="newPatient.patientLastName" type="text" id="patientLastName" class="form-control form__input" placeholder="Apellido paciente" required>
        </div>
        <div class="form__group">
          <label for="age">Edad paciente:</label>
          <input v-model="newPatient.age" type="text" id="age" class="form-control form__input" placeholder="Edad paciente" required>
        </div>
        <div class="form__group">
          <label for="painType">Zona dolor:</label>
          <select v-model="newPatient.painType" id="painType" class="form-control form__input" required>
            <option value="CUELLO">CUELLO</option>
            <option value="ESPALDA">ESPALDA</option>
            <option value="HOMBRO">HOMBRO</option>
            <option value="TOBILLO">TOBILLO</option>
            <option value="CADERA">CADERA</option>
          </select>
        </div>
        <div class="form__group">
          <label for="description">Descripción:</label>
          <textarea v-model="newPatient.description" id="description" class="form-control form__input" required></textarea>
        </div>
      </div>
      <div class="btn__group">
        <button type="submit" class="btn">Guardar</button>
        <RouterLink to="/patients" class="btn">Volver</RouterLink>
      </div>
    </form>
  </div>
</template>

<style scoped>
.newPatientView{
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
}
.formHeader{
  text-align: center;
  font-size: 2rem;
  font-weight: 700;
  color: black;
}
.btn{
  background-color: var(--salmon-color);
}
.btn:hover{
  background-color: var(--lightsalmon-color);
}
</style>
  