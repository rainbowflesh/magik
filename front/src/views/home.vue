<template>
  <div>
    <el-container class="home-container">
      <!--顶部-->
      <el-header style="margin-right: 15px; width: 100%">
        <span class="nav-logo">😅</span>
        <span class="head-title">流汗黄豆测试器</span>
        你好啊 {{ this.$store.state.user.userName }}
        <el-avatar
          shape="square"
          :size="36"
          :src="require('../assets/img/icon.png')"
        >
        </el-avatar>
      </el-header>
      <!-- 主体 -->
      <el-container>
        <!-- 侧边栏 -->
        <el-aside width="10%">
          <el-radio-group v-model="isCollapse" style="margin-bottom: 10px">
            <el-radio-button :label="false">展开</el-radio-button>
            <el-radio-button :label="true">收起</el-radio-button>
          </el-radio-group>
          <el-menu
            :default-active="$route.path"
            router
            text-color="black"
            active-text-color="red"
            class="el-menu-vertical-demo"
            :collapse="isCollapse"
          >
            <!--迭代生成菜单选项-->
            <el-menu-item
              v-for="(item, i) in navList"
              :key="i"
              :index="item.name"
            >
              <i :class="item.icon"></i>
              <span>{{ item.title }}</span>
            </el-menu-item>
            <!--固定生成菜单选项-->
            <el-submenu index="1">
              <template slot="title">
                <i class="el-icon-location"></i>
                <span slot="title">图表测试</span>
              </template>
              <el-menu-item-group>
                <span slot="title">平面表</span>
                <el-menu-item index="flatChart">竖/线图</el-menu-item>
                <el-menu-item index="cookieChart">圆盘图</el-menu-item>
                <el-menu-item index="mathChart">数学模型图</el-menu-item>
                <el-menu-item index="wordCloud">字符云图</el-menu-item>
                <el-menu-item index="waterBall">水球图</el-menu-item>
                <el-menu-item index="flowChart">矢量场图</el-menu-item>
              </el-menu-item-group>
              <el-menu-item-group title="立体表">
                <el-menu-item index="catterChart">散点图</el-menu-item>
                <el-menu-item index="barChart">柱状图</el-menu-item>
                <el-menu-item index="surfaceChart">曲线图</el-menu-item>
                <el-menu-item index="graphChart">关系图</el-menu-item>
              </el-menu-item-group>
            </el-submenu>
            <el-submenu index="2">
              <span slot="title">地球仪</span>
              <el-menu-item index="ball">鸭梨图</el-menu-item>
              <el-menu-item index="ballWithLine">线图</el-menu-item>
            </el-submenu>
          </el-menu>
        </el-aside>
        <el-main>
          <!--路由占位符-->
          <router-view></router-view>
        </el-main>
      </el-container>
    </el-container>
  </div>
</template>

<script>
export default {
  name: "Home",
  data() {
    return {
      // 迭代渲染的菜单选项如下绝赞配置中
      navList: [
        { name: "/index", title: "首页", icon: "el-icon-s-home" },
        { name: "/user", title: "查看用户信息", icon: "el-icon-s-custom" },
        { name: "/admin", title: "全知全视模式", icon: "el-icon-view" },
        { name: "/map", title: "地图测试", icon: "el-icon-map-location" },
        { name: "/supmap", title: "超级地图", icon: "el-icon-discover" }
      ],
      isCollapse: false
    };
  },
  methods: {
    printPic: function() {
      if (window.console) {
        Function.prototype.makeMulti = function() {
          let l = new String(this);
          l = l.substring(l.indexOf("/*") + 3, l.lastIndexOf("*/"));
          return l;
        };
        let string = function() {
          /*
          ██╗███████╗    ███╗   ██╗██╗     ██╗██╗██╗  ██╗ █████╗ ██╗    ██╗ █████╗ ██╗
          ██║██╔════╝    ████╗  ██║██║     ██║██║██║ ██╔╝██╔══██╗██║    ██║██╔══██╗██║
          ██║███████╗    ██╔██╗ ██║██║     ██║██║█████╔╝ ███████║██║ █╗ ██║███████║██║
          ██║╚════██║    ██║╚██╗██║██║██   ██║██║██╔═██╗ ██╔══██║██║███╗██║██╔══██║╚═╝
          ██║███████║    ██║ ╚████║██║╚█████╔╝██║██║  ██╗██║  ██║╚███╔███╔╝██║  ██║██╗
          ╚═╝╚══════╝    ╚═╝  ╚═══╝╚═╝ ╚════╝ ╚═╝╚═╝  ╚═╝╚═╝  ╚═╝ ╚══╝╚══╝ ╚═╝  ╚═╝╚═╝
          佛祖保佑0err 0warning                                                                                                                                                         
          */
        };
        console.log(string.makeMulti());
      }
      // 打印页面相关信息(代码更新时间)
      let date = new Date();
      let a = "background: #606060; color: #fff; border-radius: 3px 0 0 3px;";
      let b = "background: #1475B2; color: #fff; border-radius: 0 3px 3px 0;";
      console.log(`%c update in : %c ${date} `, a, b);
    }
  },
  mounted: function() {
    this.printPic();
  }
};
</script>

<style >
.nav-logo {
  position: absolute;
  padding-top: -1%;
  left: 4%;
  font-size: 40px;
}

.head-title {
  position: absolute;
  padding-top: 20px;
  left: 11%;
  font-size: 20px;
  font-weight: bold;
}
</style>
