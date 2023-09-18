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
  <div class="blogView">
  <img class="home__banner" src="../assets/img/banner_BLOG.png" alt="Banner blog">
    <section class="blog__container">
      <article class="blog__container--li" v-for="post in posts" :key="posts.id">
        <PostComponent :post="post"/>
      </article>
    </section>
  </div>
</template>

<style>
.blogView{
  padding-bottom: 10vh;
}
.home__banner{
  width: 100%;
}
.blog__title {
  font-size: 2rem;
  text-align: center;
}
.blog__container{
  display: grid;
  height: 100vh;
  grid-template-columns: 1fr 1fr 1fr 1fr;
  gap: 1rem;
  padding: 2rem;
  margin-bottom: 10vh;
}
.blog__container--li {
  height: auto;
}
</style>