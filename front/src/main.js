// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'
//引入ElementUI
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'
import store from './store'
// 引入mapbox
import mapboxgl from 'mapbox-gl'
// 引入echarts
import * as echarts from "echarts";
// 引入图形插件
import 'echarts-gl';
// 引入字符云插件
import 'echarts-wordcloud';
// 引入水球插件
import 'echarts-liquidfill'
// 引入axios
import axios from 'axios'
// 全局注册
Vue.prototype.$echarts = echarts
Vue.prototype.$axios = axios
// 设置反向代理，前端请求默认发送到 http://localhost:8888/api
axios.defaults.baseURL = 'http://localhost:8088/api'
Vue.config.productionTip = false

/* eslint-disable no-new */
Vue.use(mapboxgl)
Vue.use(ElementUI)

//钩子函数，访问路由前调用
router.beforeEach((to, from, next) => {
  //路由需要认证
  if (to.meta.requireAuth) {
    //判断store里是否有token
    if (store.state.token) {
      next()
    } else {
      next({
        path: 'login',
        query: { redirect: to.fullPath }
      })
    }
  } else {
    next()
  }
}
)


new Vue({
  el: '#app',
  router,
  // 注意这里
  store,
  components: { App },
  template: '<App/>'
})
