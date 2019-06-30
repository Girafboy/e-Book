import Vue from 'vue'
import Router from 'vue-router'
import Login from '../views/Login'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/Login',
      name: 'login',
      component: Login
    },
    {
      path: '/Register',
      name: 'register',
      component: () => import('../views/Register.vue')
    },
    {
      path: '/Detail',
      name: 'detail',
      component: () => import('../views/Detail.vue')
    },
    {
      path: '/Setting',
      name: 'setting',
      component: () => import('../views/Setting.vue')
    },
    {
      path: '/Cart',
      name: 'cart',
      component: () => import('../views/Cart.vue')
    },
    {
      path: '/Order',
      name: 'order',
      component: () => import('../views/Order.vue')
    },
    {
      path: '/',
      name: 'home',
      component: () => import(/* webpackChunkName: "about" */ '../views/Home.vue')
    },
    {
      path: '/admihome',
      name: 'admihome',
      component: () => import(/* webpackChunkName: "about" */ '../views/AdmiHome.vue')
    },
    {
      path: '/warehouse',
      name: 'warehouse',
      component: () => import(/* webpackChunkName: "about" */ '../views/Warehouse.vue')
    },
    {
      path: '/usermanage',
      name: 'usermanage',
      component: () => import(/* webpackChunkName: "about" */ '../views/UserManage.vue')
    },
    {
      path: '/admiorder',
      name: 'admiorder',
      component: () => import(/* webpackChunkName: "about" */ '../views/AdmiOrder.vue')
    },
    {
      path: '/admisetting',
      name: 'admisetting',
      component: () => import(/* webpackChunkName: "about" */ '../views/AdmiSetting.vue')
    },
    {
      path: '/picture',
      name: 'picture',
      component: () => import(/* webpackChunkName: "about" */ '../views/Picture.vue')
    }
  ]
})
