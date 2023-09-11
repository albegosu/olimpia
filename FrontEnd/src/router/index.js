import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue'
import ManosView from '../views/ManosView.vue'
import EspacioView from '../views/EspacioView.vue'
import TecnicasView from '../views/TecnicasView.vue'
import BlogView from '../views/BlogView.vue'
import PatientsView from '../views/PatientsView.vue'
import PatientDetailsView from '../views/PatientDetailsView.vue' // Nuevo componente para los detalles del paciente
import PatientEditView from '../views/PatientEditView.vue' // Nuevo componente para editar datos del paciente

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'home',
      component: HomeView
    },
    {
      path: '/manos',
      name: 'manos',
      component: ManosView
    },
    {
      path: '/espacio',
      name: 'espacio',
      component: EspacioView
    },
    {
      path: '/tecnicas',
      name: 'tecnicas',
      component: TecnicasView
    },
    {
      path: '/blog',
      name: 'blog',
      component: BlogView
    },
    {
      path: '/patients',
      name: 'patients-list',
      component: PatientsView,
    },
    {
      path: '/patients/:id', // Ruta para ver detalles del paciente
      name: 'patient-details',
      component: PatientDetailsView,
      props: true, // Para pasar el parámetro ID como prop
    },
    {
      path: '/patients/:id/edit', // Ruta para editar datos del paciente
      name: 'patient-edit',
      component: PatientEditView,
      props: true, // Para pasar el parámetro ID como prop
    },
  ]
})

export default router
