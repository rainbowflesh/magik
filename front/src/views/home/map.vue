<template>
  <div
    id="mapContainer"
    style="height: 783px; width: 95%; text-align: center"
  ></div>
</template>

<script>
export default {
  props: {
    mapWidth: {
      type: String
    },
    mapHeight: {
      type: String
    }
  },
  data() {
    return {};
  },
  methods: {
    haveMapbox: function() {
      var mapboxgl = require("mapbox-gl/dist/mapbox-gl.js");
      mapboxgl.accessToken =
        "the TOKEN";
      var map = new mapboxgl.Map({
        container: "mapContainer",
        style: "mapbox://styles/mapbox/streets-v11"
      });
      console.log(map);
    }
  },
  mounted: function() {
    this.haveMapbox();
  }
};
</script>

<style>
@import url("https://api.mapbox.com/mapbox-gl-js/v2.3.1/mapbox-gl.css");
</style>