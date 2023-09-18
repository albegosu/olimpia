<script setup>
    import InWorks from '@/components/InWorksComponent.vue'
</script>

<template>
    <div class="inWorks">
        <h2>¡Estamos trabajando en ello!</h2>
        <InWorks />
    </div>
</template>

<style scoped>
.inWorks {
    display: flex;
    flex-direction: column;
    align-items: center;
    padding: 3rem;
}

.inWorks h2 {
    text-align: center;
    font-size: 3rem;
    font-family:'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
}
</style>