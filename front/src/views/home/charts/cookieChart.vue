<template>
  <div>
    <div
      id="pieChart1"
      style="
         {
          width: 871px;
          height: 871px;
        }
      "
    ></div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      chartData: [
        { value: 335, name: "直接访问" },
        { value: 310, name: "邮件营销" },
        { value: 274, name: "联盟广告" },
        { value: 235, name: "视频广告" },
        { value: 400, name: "搜索引擎" },
        { value: 110, name: "诈骗信息" }
      ]
    };
  },
  methods: {
    haveAngelPieChart: function() {
      let echarts = this.$echarts.init(document.getElementById("pieChart1"));
      echarts.clear();
      // 绘制图表
      echarts.setOption({
        backgroundColor: "#2c343c",
        title: {
          text: "Customized Pie",
          left: "center",
          top: 20,
          textStyle: {
            color: "#ccc"
          }
        },
        tooltip: {
          trigger: "item"
        },
        visualMap: {
          show: false,
          min: 80,
          max: 600,
          inRange: {
            colorLightness: [0, 1]
          }
        },
        series: [
          {
            name: "访问来源",
            type: "pie",
            radius: "55%",
            center: ["50%", "50%"],
            data: this.chartData.sort(function(a, b) {
              return a.value - b.value;
            }),
            roseType: "radius",
            label: {
              color: "rgba(255, 255, 255, 0.3)"
            },
            labelLine: {
              lineStyle: {
                color: "rgba(255, 255, 255, 0.3)"
              },
              smooth: 0.2,
              length: 10,
              length2: 20
            },
            itemStyle: {
              color: "#c23531",
              shadowBlur: 200,
              shadowColor: "rgba(0, 0, 0, 0.5)"
            },
            animationType: "scale",
            animationEasing: "elasticOut",
            animationDelay: function(idx) {
              return Math.random() * 200;
            }
          }
        ]
      });
    }
  },
  mounted: function() {
    this.haveAngelPieChart();
  }
};
</script>

<style>
</style>