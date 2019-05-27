import Vue from 'vue'
import App from './App.vue'
import router from './router'
import './element.js'
import axios from 'axios'
import store from './store'

axios.defaults.headers.post['Content-Type'] = 'application/x-www-form-urlencoded;charset=UTF-8';
axios.defaults.baseURL = "localhost:8080/JavaWeb/";
axios.defaults.withCredentials = false;
Vue.config.productionTip = false;
Vue.prototype.$axios = axios;

new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app');
