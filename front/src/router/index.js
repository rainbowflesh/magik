import Vue from 'vue'
import Router from 'vue-router'
//导入登录页面组件
import Login from '@/views/login.vue'
import Home from '@/views/home.vue'


Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'Default',
      redirect: '/home',
      component: Home
    },
    {
      // home页面并不需要被访问，只是作为其它组件的父组件
      path: '/home',
      name: 'Home',
      component: Home,
      meta: {
        requireAuth: true
      },
      redirect: '/index',
      children: [
        {
          path: '/index',
          name: 'Index',
          component: () => import('@/views/home/index'),
          meta: {
            requireAuth: true
          }
        },
        {
          path: '/user',
          name: 'User',
          component: () => import('@/views/user/index'),
          meta: {
            requireAuth: true
          }
        },
        {
          path: '/admin',
          name: 'AdminPanel',
          component: () => import('@/views/admin/panel'),
          meta: {
            requireAuth: true
          }
        },
        {
          path: '/map',
          name: 'Map',
          component: () => import('@/views/home/map'),
          meta: {
            requireAuth: true
          }
        },
        {
          path: '/supmap',
          name: 'superMap',
          component: () => import('@/views/home/charts/3d/superMap'),
          meta: {
            requireAuth: true
          }
        },
        {
          path: '/flatChart',
          name: 'flatChart',
          component: () => import('@/views/home/charts/flatChart'),
          meta: {
            requireAuth: true
          }
        },
        {
          path: '/cookieChart',
          name: 'cookieChart',
          component: () => import('@/views/home/charts/cookieChart'),
          meta: {
            requireAuth: true
          }
        },
        {
          path: '/mathChart',
          name: 'mathChart',
          component: () => import('@/views/home/charts/mathChart'),
          meta: {
            requireAuth: true
          }
        },
        {
          path: '/wordCloud',
          name: 'wordCloud',
          component: () => import('@/views/home/charts/wordCloud'),
          meta: {
            requireAuth: true
          }
        },
        {
          path: '/waterBall',
          name: 'waterBall',
          component: () => import('@/views/home/charts/waterBall'),
          meta: {
            requireAuth: true
          }
        },
        {
          path: '/ball',
          name: 'EchartS4',
          component: () => import('@/views/home/charts/3d/ball'),
          meta: {
            requireAuth: true
          }
        },
        {
          path: '/catterChart',
          name: 'catterChart',
          component: () => import('@/views/home/charts/3d/catterChart'),
          meta: {
            requireAuth: true
          }
        },
        {
          path: '/barChart',
          name: 'barChart',
          component: () => import('@/views/home/charts/3d/barChart'),
          meta: {
            requireAuth: true
          }
        },
        {
          path: '/surfaceChart',
          name: 'surfaceChart',
          component: () => import('@/views/home/charts/3d/surfaceChart'),
          meta: {
            requireAuth: true
          }
        },
        {
          path: '/flowChart',
          name: 'flowChart',
          component: () => import('@/views/home/charts/flowChart'),
          meta: {
            requireAuth: true
          }
        },
        {
          path: '/graphChart',
          name: 'graphChart',
          component: () => import('@/views/home/charts/3d/graphChart'),
          meta: {
            requireAuth: true
          }
        },
        {
          path: '/ballWithLine',
          name: 'ballWithLine',
          component: () => import('@/views/home/charts/3d/ballWithLine'),
          meta: {
            requireAuth: true
          }
        },
      ]
    },
    //添加登录页面路由
    {
      path: '/login',
      name: 'Login',
      component: Login
    }
  ]
})
