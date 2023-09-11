<script setup>
import { ref, onMounted } from "vue";
import PatientData from "@/services/PatientData";

const histories = ref([]);

const patientsData = async () => {
  try {
    const response = await PatientData.getAll();
    console.log(response.data);
    histories.value = response.data.map((patient) => ({
      id: patient.id,
      age: patient.age,
      consultationDate: patient.consultationDate,
      description: patient.description,
      painType: patient.painType,
      patientLastName: patient.patientLastName,
      patientName: patient.patientName
    }));
  } catch (error) {
    console.log(error);
  }
};

onMounted(patientsData)

</script>

<template>
    <h1>Patients Works!</h1>
    <div v-for="history in histories">{{ history.age }}</div>
</template>