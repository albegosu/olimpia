<script setup>
import { ref, onMounted } from 'vue';
import { useRoute, useRouter } from 'vue-router';

import PatientData from '@/services/PatientData';
import { usePatientDataStore } from '@/services/PiniaStore'; 

import Swal from 'sweetalert2';

const route = useRoute();
const router = useRouter();
const patientDataStore = usePatientDataStore();
const editedPatient = ref({});

const patientId = route.params.id;

onMounted(async () => {
  const patient = patientDataStore.getPatientDataList[patientId];
  if (patient) {
    editedPatient.value = { ...patient };
    console.log(editedPatient.patientName);
  } else {
      await fetchPatientDetails(patientId);
    }
});

const fetchPatientDetails = async (id) => {
  try {
    const response = await PatientData.getById(id);
    const data = response.data;
    
    patientDataStore.setPatientData(data);
    editedPatient.value = { ...data };

  } catch (error) {
    console.error(error);
    Swal.fire({
                position: 'center',
                icon: 'error',
                title: `${error}`,
                showConfirmButton: false,
                timer: 1500
              })
  }
};

const updatePatient = async () => {
  try {
    const { id, patientName, patientLastName, description, painType, tel, age } = editedPatient.value;
    const updatedData = { id, patientName, patientLastName, description, painType, tel, age};

    await Swal.fire({
        title: '¿Quiere guardar los cambios?',
        icon: 'warning',
        showCancelButton: true,
        confirmButtonColor: 'var(--green-color)',
        cancelButtonColor: 'var(--salmon-color)',
        confirmButtonText: 'Guardar'
      }).then((result) => {
        if (result.isConfirmed) {
          PatientData.updateID(editedPatient.value.id, updatedData);
          
          patientDataStore.updatePatient(updatedData);

          Swal.fire({
                      position: 'center',
                      icon: 'success',
                      title: 'Usuario actualizado correctamente',
                      showConfirmButton: false,
                      timer: 1500
                    })
      }
    })
  } catch (error) {
    console.error(error);
  }
  setTimeout(() => {
    router.replace('/patients');
  }, 1500)
};
</script>

<template>
  <div class="patientEditView">
    <p>Fecha primera consulta: {{ editedPatient.consultationDate }}</p>
    <form @submit.prevent="updatePatient">
      <div class="form">
        <div class="form__group">
          <label for="patientName">Nombre:</label>
          <input v-model="editedPatient.patientName" type="text" id="patientName" class="form__input" required>
        </div>
        <div class="form__group">
          <label for="patientLastName">Apellido:</label>
          <input v-model="editedPatient.patientLastName" type="text" id="patientLastName" class="form__input" required>
        </div>
        <div class="form__group">
          <label for="age">Edad paciente:</label>
          <input v-model="editedPatient.age" type="text" id="age" class="form__input" required>
        </div>
        <div class="form__group">
          <label for="painType">Zona dolor:</label>
          <select v-model="editedPatient.painType" id="painType" class="form__input" required>
            <option value="CUELLO">CUELLO</option>
            <option value="ESPALDA">ESPALDA</option>
            <option value="HOMBRO">HOMBRO</option>
            <option value="TOBILLO">TOBILLO</option>
            <option value="CADERA">CADERA</option>
          </select>
        </div>
        <div class="form__group">
          <label for="tel">Número de contacto:</label>
          <textarea v-model="editedPatient.tel" id="tel" class="form__input" required></textarea>
        </div>
        <div class="form__group">
          <label for="description">Descripción:</label>
          <textarea v-model="editedPatient.description" id="description" class="form__input" required></textarea>
        </div>
      </div>
      <div class="btn__group">
        <button type="submit" class="btn">Guardar</button>
        <RouterLink :to="`/patients`" class="btn">Volver</RouterLink>
      </div>
    </form>
  </div>
</template>

<style scoped>
.patientEditView {
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
}
</style>
