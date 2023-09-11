import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue'
import ManosView from '../views/ManosView.vue'
import EspacioView from '../views/EspacioView.vue'
import TecnicasView from '../views/TecnicasView.vue'
import BlogView from '../views/BlogView.vue'
import PatientsView from '../views/PatientsView.vue'

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
      name: 'patients',
      component: PatientsView
    },
  ]
})

export default router
