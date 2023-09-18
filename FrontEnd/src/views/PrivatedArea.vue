<script setup>
    import { RouterLink } from 'vue-router'
</script>

<template>
    <div class="privated">
        <div>
            <RouterLink to="/patients" class="btn">Pacientes</RouterLink>
        </div>
        <div>
            <RouterLink to="/editblog" class="btn">Control Posts</RouterLink>
        </div>
    </div>
</template>

<style>
.privated {
    padding: 3rem;
    display: flex;
    flex-direction: column;
    gap: 3rem;
}
</style>