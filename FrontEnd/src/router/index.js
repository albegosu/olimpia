import { createRouter, createWebHistory } from 'vue-router'

import HomeView from '../views/HomeView.vue'
import ContactoView from '../views/ContactoView.vue'
import EspacioView from '../views/EspacioView.vue'
import TecnicasView from '../views/TecnicasView.vue'
import BlogView from '../views/BlogView.vue'
import PrivatedArea from '../views/PrivatedArea.vue'
import EditBlog from '../views/EditBlogView.vue'

import PatientsView from '../views/Patients/PatientsView.vue'
import PatientDetailsView from '../views/Patients/PatientDetailsView.vue' // Nuevo componente para los detalles del paciente
import PatientEditView from '../views/Patients/PatientEditView.vue' // Nuevo componente para editar datos del paciente
import PatientNew from '../views/Patients/PatientNew.vue'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'home',
      component: HomeView
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
      path: '/contacto',
      name: 'contacto',
      component: ContactoView
    },
    {
      path: '/patients',
      name: 'patients',
      component: PatientsView
    },
    {
      path: '/patients/:id',
      name: 'patient-details',
      component: PatientDetailsView,
      props: true
    },
    {
      path: '/patients/:id/edit',
      name: 'patient-edit',
      component: PatientEditView,
      props: true
    },
    {
      path: '/newpatient',
      name: 'patient-new',
      component: PatientNew
    },
    {
      path: '/privated',
      name: 'privated-area',
      component: PrivatedArea
    },
    {
      path: '/editblog',
      name: 'edit-blog',
      component: EditBlog
    }
  ]
})

export default router;
