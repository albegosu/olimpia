<script setup>
  import { ref, onMounted } from 'vue';
  import { useRouter } from 'vue-router';
  
  import BlogData from '@/services/BlogData';
  import PostComponent from "@/components/PostComponent.vue"

  import Swal from 'sweetalert2';
 
  const router = useRouter();

  const newBlog = ref({
    blogTitle: '',
    blogSubtitle: '',
    blogMessage: '',
    imgUrl: '',
  });
    
    const createPost = async () => {
      try {
        await Swal.fire({
          title: '¿Quiere guardar el nuevo post?',
          icon: 'warning',
          showCancelButton: true,
          confirmButtonColor: 'var(--green-color)',
          cancelButtonColor: 'var(--salmon-color)',
          confirmButtonText: 'Guardar'
        }).then((result) => {
          if (result.isConfirmed) {
            
            // Llama al servicio para crear un nuevo paciente tras el alert de confirmación
            const response = BlogData.create(newBlog.value);
            //CLG PRUEBAS
            console.log(response);
            Swal.fire({
              position: 'center',
              icon: 'success',
              title: 'Paciente creado correctamente',
              showConfirmButton: false,
              timer: 1500
            })
          } 
        })
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
      // Después de crear el paciente, puedes redirigir a la vista de lista de pacientes
      router.go(0);
      router.push('/ediBlog');
  };

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

const editPost = () => {
  // Agrega aquí la lógica para editar el post
};

const deletePost = async (postId) => {
  try {
    await Swal.fire({
      title: '¿Quiere eliminar el post?',
      icon: 'warning',
      showCancelButton: true,
      confirmButtonColor: 'var(--green-color)',
      cancelButtonColor: 'var(--salmon-color)',
      confirmButtonText: 'Eliminar'
    }).then((result) => {
      if (result.isConfirmed) {
        console.log(postId);
        // Llama al servicio para eliminar el post
        BlogData.delete(postId);
        // Actualiza la lista de posts después de eliminar
        blogData();
        Swal.fire({
          position: 'center',
          icon: 'success',
          title: 'Post eliminado correctamente',
          showConfirmButton: false,
          timer: 1500
        })
      }
    });
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
  router.go(0);
  router.push('/ediBlog');
};

</script>

<template>
  <div class="newPost">
    <h1 class="form__header">Agregar un nuevo Post</h1>
    <form @submit.prevent="createPost">
      <div class="form">
        <div class="form__group">
          <label for="blogTitle" class="form__label">Títulos:</label>
          <input v-model="newBlog.blogTitle" type="text" id="blogTitle" class="form-control form__input" placeholder="Titulo Post" required>
        </div>
        <div class="form__group">
          <label for="blogSubtitle" class="form__label">Categoría:</label>
          <input v-model="newBlog.blogSubtitle" type="text" id="blogSubtitle" class="form-control form__input" placeholder="Categoría Post" required>
        </div>
        <div class="form__group">
          <label for="blogMessage">Artículo:</label>
          <textarea v-model="newBlog.blogMessage" type="text" id="blogMessage" class="form-control form__input" placeholder="Contenido Post" required></textarea>
        </div>
        <div class="form__group">
          <label for="imgUrl">URL imagen:</label>
          <input v-model="newBlog.imgUrl" type="text" id="imgUrl" class="form-control form__input" placeholder="URL post" required>
        </div>
      </div>
      <div class="btn__group">
        <button type="submit" class="btn">Guardar</button>
        <RouterLink to="/patients" class="btn">Volver</RouterLink>
      </div>
    </form>
    <div class="blog">
      <h1 class="blog__title">¡Blog Olimpia!</h1>
      <div class="blog__container">
        <div v-for="post in posts" :key="post.id">
          <PostComponent :post="post"/>
          <div class="btn__group">
            <button @click="editPost" class="btn">Editar</button>
            <button @click="deletePost(post.id)" class="btn">Eliminar</button>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<style scoped>
.newPost{
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
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
  