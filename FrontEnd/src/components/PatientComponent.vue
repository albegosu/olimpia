<script setup>
import { defineProps } from 'vue';
import { RouterLink } from 'vue-router';
import { useRouter } from 'vue-router';

import { usePatientDataStore } from '@/services/PiniaStore';
import PatientData from '@/services/PatientData';

import { format } from 'date-fns';
import Swal from 'sweetalert2';

const router = useRouter();
const { patient } = defineProps(['patient']);
const patientDataStore = usePatientDataStore();
const formattedConsultationDate = format(new Date(patient.consultationDate), 'dd-MM-yyyy');

const deletePatient = async () => {
  try {
    await Swal.fire({
        title: '¿Quiere eliminar a este paciente?',
        text: 'Esta acción no se podrá deshacer',
        icon: 'warning',
        showCancelButton: true,
        confirmButtonColor: 'var(--green-color)',
        cancelButtonColor: 'var(--salmon-color)',
        confirmButtonText: 'Eliminar'
      }).then((result) => {
        if (result.isConfirmed) {
    
        PatientData.delete(patient.id);

        patientDataStore.updatePatient(patientDataStore.getPatientDataList.filter(p => p.id !== patient.id));
        
        Swal.fire({
          position: 'center',
          icon: 'success',
          title: 'Usuario eliminado correctamente',
          showConfirmButton: false,
          timer: 1500
        })
        router.push('/patients')
        router.go(0)
      }
    })
  } catch (error) {
    console.error(error);
  }
};
</script>

<template>
  <div class="patientCard">
    <RouterLink :to="`/patients/${patient.id}`">
      <h1 class="patientCard__title">Detalles del Paciente</h1>
      <div class="patientCard__details">
        <h2>Paciente: {{ patient.patientName }} {{ patient.patientLastName }}</h2>
        <p>Primera consulta: {{ formattedConsultationDate }}</p>
        <p>Tipo de Dolor: {{ patient.painType }}</p>
      </div>
  </RouterLink>
    <div class="btn__group">
      <RouterLink :to="`/patients/${patient.id}/edit`" class="btn">Editar</RouterLink>
      <RouterLink :to="`/patients/${patient.id}`" class="btn">Historial</RouterLink>
      <button @click="deletePatient" class="btn btn__delete">Eliminar</button>
    </div>
  </div>
</template>

<style scoped>
.patientCard{
  width: 20vw;
  border: 1px solid var(--salmon-color);
  border-radius: 0.5rem;
  display: flex;
  flex-direction: column;
  align-items: center;
  transition: 0.3s;
  padding: 1rem;
}
.patientCard:hover {
  background-color: var(--lightsalmon-color);
}
@media (max-width: 1250px) {
  .patientCard{
    min-width: 30vw;
  }
}
@media (max-width: 750) {
  .patientCard{
    min-width: 30vw;
  }
}
.patientCard__details {
  border-radius: 0.2rem;
  padding: 10px;
  margin: 10px;
}
</style>
  