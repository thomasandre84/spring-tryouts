import { createApp } from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import PrimeVue from 'primevue/config'
import axios from 'axios'

const app = createApp(App)
.use(store)
.use(router)
.use(PrimeVue)

app.config.globalProperties.$http = axios

app.mount('#app')
