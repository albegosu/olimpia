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
  <img class="home__banner" src="../assets/img/banner_BLOG.png" alt="Banner blog">
  <div class="blog">
    <h1 class="blog__title">¡Blog Olimpia!</h1>
    <div class="blog__container">
      <div v-for="post in posts" :key="posts.id">
        <PostComponent :post="post"/>
      </div>
    </div>
  </div>
</template>

<style scoped>
.home__banner{
  width: 100%;
}
.blog__title {
  font-size: 2rem;
  text-align: center;
}
.blog__container{
  display: grid;
  grid-template-columns: 1fr 1fr;
  padding: 2rem;
}
</style>