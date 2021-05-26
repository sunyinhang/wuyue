<template>
  <div :class="className" :style="{height:height,width:width}" />
</template>

<script>
let echarts = require('echarts')
require('echarts/theme/macarons') // echarts theme
import resize from './resize'

export default {
  mixins: [resize],
  props: {
    className: {
      type: String,
      default: 'chart'
    },
    width: {
      type: String,
      default: '100%'
    },
    height: {
      type: String,
      default: '350px'
    },
    autoResize: {
      type: Boolean,
      default: true
    },
    chartData: {
      type: Object,
      required: true
    }
  },
  data() {
    return {
      chart: null
    }
  },
  watch: {
    chartData: {
      deep: true,
      handler(val) {
        this.setOptions(val)
      }
    }
  },
  mounted() {
    this.$nextTick(() => {
      this.initChart()
    })
  },
  beforeDestroy() {
    if (!this.chart) {
      return
    }
    this.chart.dispose()
    this.chart = null
  },
  methods: {
    initChart() {
      this.chart = echarts.init(this.$el, 'macarons')
      this.setOptions(this.chartData)
    },
    setOptions({ title, subtitle, xdatas, ydatas, unit, standard, max, min } = {}) {
      let textTitle = {
        text: title,
        left: "center"
      };
      if (subtitle) {
        textTitle.subtext = subtitle;
      }
      let yAxis = { name: unit, type: "value" };
      if (max) {
        yAxis.max = max;
      }
      if (min) {
        yAxis.min = min;
      }
      let names = [];
      let series = [];
      for (let data of ydatas) {
        names.push(data.name);
        let yseries = {
          name: data.name,
          smooth: true,
          type: "line",
          data: data.data,
          animationDuration: 1000,
          animationEasing: 'cubicInOut'
        };
        if (standard && data.name === standard) {
          yseries.lineStyle = {
            type: "dotted"
          };
        }
        series.push(yseries);
      }
      this.chart.setOption({
        title: textTitle,
        xAxis: {
          data: xdatas,
          boundaryGap: false,
          axisTick: {
            show: false
          }
        },
        grid: {
          left: 20,
          right: 20,
          bottom: 20,
          top: 60,
          containLabel: true
        },
        tooltip: {
          trigger: 'axis',
          axisPointer: {
            type: 'cross'
          },
          padding: [5, 10]
        },
        toolbox: {
          feature: {
            dataView: { show: true, readOnly: false },
            magicType: { show: true, type: ["line", "bar"] },
            restore: { show: true },
            saveAsImage: { show: true },
          },
        },
        yAxis: yAxis,
        legend: {
          left: "center",
          top: "bottom",
          data: names
        },
        series: series
      })
    }
  }
}
</script>
