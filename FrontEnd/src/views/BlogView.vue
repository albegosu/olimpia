<script setup>
import { ref, onMounted } from "vue";
import BlogData from "@/services/BlogData";
import PostComponent from "@/components/PostComponent.vue"

const posts = ref([]);

const blogData = async () => {
  try {
    const responseBlog = await BlogData.getAll();
    console.log(responseBlog.data);
    posts.value = responseBlog.data;

  } catch (error) {
    console.log(error);
  }
};

onMounted(blogData)

</script>

<template>
    <h1>Blog Works!</h1>
    <div v-for="post in posts" :key="posts.id">
      <PostComponent :post="post"/>
    </div>
</template>