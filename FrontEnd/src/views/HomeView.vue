<script setup>
import { ref, onMounted } from "vue";
import PatientData from "@/services/PatientData";
import BlogData from "@/services/BlogData";

const histories = ref([]);
const blog = ref([]);

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

const blogData = async () => {
  try {
    const responseBlog = await BlogData.getAll();
    console.log(responseBlog.data);
    blog.value = responseBlog.data.map((post) => ({
      id: post.id,
      blogMessage: post.blogMessage,
      blogTitle: post.blogTitle,
    }));
  } catch (error) {
    console.log(error);
  }
};

onMounted(patientsData)
onMounted(blogData)


</script>

<template>
  <main>
    <div v-for="history in histories">{{ history.age }}</div>
    <div v-for="blog in blog">{{ blog.blogMessage }}</div>
  </main>
</template>
