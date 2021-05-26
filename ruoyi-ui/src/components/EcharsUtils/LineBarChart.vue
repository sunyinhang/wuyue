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
    setOptions({ title, subtext, xaxis, yaxis, series } = {}) {
      let textTitle = {
        text: title,
        left: "center"
      };
      if (subtext) {
        textTitle.subtext = subtext;
      }
      for (let yax of yaxis) {
        yax.type = "value";
        yax.axisLabel = {
          formatter: "{value} " + yax.unit
        }
      }
      let names = [];
      for (let seri of series) {
        names.push(seri.name);
        seri.smooth = true;
        seri.animationDuration = 1000,
        seri.animationEasing = 'cubicInOut';
      }
      if (series.length > 1 && series[series.length - 1].type === 'line') {
        series[series.length - 1].yAxisIndex = yaxis.length - 1;
      }
      this.chart.setOption({
        title: textTitle,
        xAxis: {
          data: xaxis,
          boundaryGap: false,
          axisTick: {
            show: false
          }
        },
        grid: {
          left: 30,
          right: 30,
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
        yAxis: yaxis,
        legend: {
          left: 10,
          data: names
        },
        series: series
      })
    }
  }
}
</script>
