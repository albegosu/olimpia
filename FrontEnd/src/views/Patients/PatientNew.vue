<script setup>
  import { ref } from 'vue';
  import { useRouter } from 'vue-router';
  
  import PatientData from '@/services/PatientData';
  import { usePatientDataStore } from '@/services/PiniaStore.js';
  
  import { format } from 'date-fns';   //DEPENDENCIA PARA CAMBIAR FORMATO DE FECHA ENTRE BBDD Y FRONT

  import Swal from 'sweetalert2';

 
  const router = useRouter();
  const patientDataStore = usePatientDataStore();
  
  const newPatient = ref({
    patientName: '',
    patientLastName: '',
    age: '',
    painType: 'CUELLO',
    description: '',
    tel: '',
    consultationDate: ''
  });

    //CREAR INSTANCIA DATE Y DAR FORMATE SEGÚN BBDD
    const currentDate = new Date();
    const date = format(currentDate, 'yyyy-MM-dd');
    
    const createPatient = async () => {
      try {
        await Swal.fire({
          title: '¿Quiere guardar el nuevo paciente?',
          icon: 'warning',
          showCancelButton: true,
          confirmButtonColor: 'var(--green-color)',
          cancelButtonColor: 'var(--salmon-color)',
          confirmButtonText: 'Guardar'
        }).then((result) => {
          if (result.isConfirmed) {
            //ASIGNAMOS LA DATE ACTUAL AL PACIENTE
            newPatient.value.consultationDate = date;
            
            // Llama al servicio para crear un nuevo paciente tras el alert de confirmación
            const response = PatientData.create(newPatient.value);
            //CLG PRUEBAS
            console.log(response);
            // Insertamos el paciente en PiniaStore
            const data = response.data;
            patientDataStore.setPatientData(data);

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
      router.push('/patients');
  };

</script>

<template>
  <div class="newPatientView">
    <h1 class="form__header">Agregar nuevo Paciente</h1>
    <form @submit.prevent="createPatient">
      <div class="form">
        <div class="form__group">
          <label for="patientName" class="form__label">Nombre:</label>
          <input v-model="newPatient.patientName" type="text" id="patientName" class="form-control form__input" placeholder="Nombre paciente" required>
        </div>
        <div class="form__group">
          <label for="patientLastName">Apellido:</label>
          <input v-model="newPatient.patientLastName" type="text" id="patientLastName" class="form-control form__input" placeholder="Apellido paciente" required>
        </div>
        <div class="form__group">
          <label for="age">Edad paciente:</label>
          <input v-model="newPatient.age" type="text" id="age" class="form-control form__input" placeholder="Edad paciente" required>
        </div>
        <div class="form__group">
          <label for="painType">Zona dolor:</label>
          <select v-model="newPatient.painType" id="painType" class="form-control form__input" required>
            <option value="CUELLO">CUELLO</option>
            <option value="ESPALDA">ESPALDA</option>
            <option value="HOMBRO">HOMBRO</option>
            <option value="TOBILLO">TOBILLO</option>
            <option value="CADERA">CADERA</option>
          </select>
        </div>
        <div class="form__group">
          <label for="tel">Número de contacto:</label>
          <input type="number" v-model="newPatient.tel" id="tel" class="form-control form__input" required>
        </div>
        <div class="form__group">
          <label for="description">Descripción:</label>
          <textarea v-model="newPatient.description" id="description" class="form-control form__input" required></textarea>
        </div>
      </div>
      <div class="btn__group">
        <button type="submit" class="btn">Guardar</button>
        <RouterLink to="/patients" class="btn">Volver</RouterLink>
      </div>
    </form>
  </div>
</template>

<style scoped>
.newPatientView{
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
}
.formHeader{
  text-align: center;
  font-size: 2rem;
  font-weight: 700;
  color: black;
}
.btn{
  background-color: var(--salmon-color);
}
.btn:hover{
  background-color: var(--lightsalmon-color);
}
</style>
  