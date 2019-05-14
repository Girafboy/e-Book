import Vue from 'vue'
import VueResource from 'vue-resource'
import axios from 'axios'
import VueAxios from 'vue-axios'

Vue.use(VueAxios, axios);
Vue.use(VueResource);