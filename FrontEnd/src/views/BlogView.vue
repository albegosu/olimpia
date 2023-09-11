<script setup>
import { ref, onMounted } from "vue";
import BlogData from "@/services/BlogData";

const blog = ref([]);

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

onMounted(blogData)

</script>

<template>
    <h1>Blog Works!</h1>
    <div v-for="blog in blog">{{ blog.blogMessage }}</div>
</template>