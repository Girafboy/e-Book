// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App.vue'
import router from './router'
import './element.js'
import axios from 'axios'
import global from './components/GLOBAL'

axios.defaults.headers['Content-Type'] = 'application/json;charset=UTF-8'
axios.defaults.baseURL = 'http://localhost:8000/'
axios.defaults.withCredentials = false
Vue.config.productionTip = false
Vue.prototype.$axios = axios
Vue.prototype.GLOBAL = global

// 添加请求拦截器
axios.interceptors.request.use(function (config) {
  // 参数格式转换
  // if (config.method === 'post') {
  //   config.params = qs.parse(config.data)
  // }
  // if (config.method === 'put') {
  //   config.params = qs.parse(config.data)
  // }
  return config
}, function (error) {
  // 对请求错误做些什么
  return Promise.reject(error)
})
/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  components: { App },
  template: '<App/>'
})
