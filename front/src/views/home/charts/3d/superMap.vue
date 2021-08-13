<template>
  <div>
    <div
      id="EchartsContainer"
      style="
         {
          width: 95%;
          height: 871px;
        }
      "
    ></div>
  </div>
</template>

<script>
export default {
  data() {
    return {};
  },
  methods: {
    haveMap: function() {
      var ROOT_PATH =
        "https://cdn.jsdelivr.net/gh/isNijikawa/echarts-asset@main/assets/";

      let echarts = this.$echarts.init(
        document.getElementById("EchartsContainer")
      );
      echarts.clear();
      // 绘制图表
      $.getJSON(ROOT_PATH + "data/population.json", function(data) {
        data = data
          .filter(function(dataItem) {
            return dataItem[2] > 0;
          })
          .map(function(dataItem) {
            return [dataItem[0], dataItem[1], Math.sqrt(dataItem[2])];
          });
        echarts.setOption({
          backgroundColor: "#cdcfd5",
          geo3D: {
            map: "world",
            shading: "lambert",
            light: {
              main: {
                intensity: 5,
                shadow: true,
                shadowQuality: "high",
                alpha: 30
              },
              ambient: {
                intensity: 0
              },
              ambientCubemap: {
                texture: "asset/canyon.hdr",
                exposure: 1,
                diffuseIntensity: 0.5
              }
            },
            viewControl: {
              distance: 50,
              panMouseButton: "left",
              rotateMouseButton: "right"
            },
            groundPlane: {
              show: true,
              color: "#999"
            },
            postEffect: {
              enable: true,
              bloom: {
                enable: false
              },
              SSAO: {
                radius: 1,
                intensity: 1,
                enable: true
              },
              depthOfField: {
                enable: false,
                focalRange: 10,
                blurRadius: 10,
                fstop: 1
              }
            },
            temporalSuperSampling: {
              enable: true
            },
            itemStyle: {},

            regionHeight: 2
          },
          visualMap: {
            max: 40,
            calculable: true,
            realtime: false,
            inRange: {
              color: [
                "#313695",
                "#4575b4",
                "#74add1",
                "#abd9e9",
                "#e0f3f8",
                "#ffffbf",
                "#fee090",
                "#fdae61",
                "#f46d43",
                "#d73027",
                "#a50026"
              ]
            },
            outOfRange: {
              colorAlpha: 0
            }
          },
          series: [
            {
              type: "bar3D",
              coordinateSystem: "geo3D",
              shading: "lambert",
              data: data,
              barSize: 0.1,
              minHeight: 0.2,
              silent: true,
              itemStyle: {
                color: "orange",
                opacity: 0.8
              }
            }
          ]
        });
      });
    }
  },
  mounted: function() {
    this.haveMap();
  }
};
</script>

<style>
</style>