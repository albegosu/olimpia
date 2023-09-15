import './assets/styles/main.css'
import './assets/styles/reset.css'
import './assets/styles/globals.css'

import { createApp } from 'vue'
import App from './App.vue'
import router from './router'
import { createPinia } from 'pinia'

import VueSweetalert2 from 'vue-sweetalert2';
import 'sweetalert2/dist/sweetalert2.min.css';

const options = {
    confirmButtonColor: 'var(--green-color)',
    cancelButtonColor: 'var(--salmon-color)',
};

const app = createApp(App)
const pinia = createPinia()

app.use(router)
app.use(pinia)
app.use(VueSweetalert2, options);

app.mount('#app')
