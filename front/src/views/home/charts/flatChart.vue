<template>
  <div>
    <div>
      <el-button
        id="butt"
        v-bind:icon="iconData"
        style="{border: none,align-self: center;}"
        @click="changeIcon()"
        native-type="button"
      >
        切换视图
      </el-button>
    </div>
    <div
      id="EchartsContainer"
      style="
         {
          width: 600px;
          height: 400px;
        }
      "
    ></div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      iconData: "el-icon-data-analysis",
      chartType: [
        { name: "bar", value: "bar" },
        { name: "line", value: "line" }
      ],
      // 默认图标类型是0, 对应charType的下标0
      chartChose: 0,
      xAxisData: ["类型1", "类型2", "类型3", "类型4", "类型5", "类型6"],
      seriesData: [5, 20, 36, 10, 10, 20],
      valueName: "量"
    };
  },
  methods: {
    haveEcharts: function() {
      // 基于准备好的dom，初始化echarts实例
      let echarts = this.$echarts.init(
        document.getElementById("EchartsContainer")
      );
      echarts.clear();
      // 绘制图表
      echarts.setOption({
        title: { text: "在Vue中使用eecharts" },
        tooltip: {},
        legend: {
          data: this.valueName
        },
        xAxis: {
          data: this.xAxisData
        },
        yAxis: {},
        series: [
          {
            name: this.valueName,
            type: this.chartType[this.chartChose].value,
            data: this.seriesData
          }
        ]
      });
    },
    changeIcon() {
      if (this.iconData == "el-icon-data-line") {
        this.iconData = "el-icon-data-analysis";
        this.$data.chartChose = 0;
        this.haveEcharts();
      } else {
        this.iconData = "el-icon-data-line";
        this.$data.chartChose = 1;
        this.haveEcharts();
      }
    }
  },
  mounted: function() {
    this.haveEcharts();
  }
};
</script>
<style scoped>
#chart1 {
  width: 300px;
  height: 300px;
}
</style>