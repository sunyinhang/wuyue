<template>
  <div :class="className" :style="{ height: height, width: width }" />
</template>

<script>
let echarts = require("echarts");
require("echarts/theme/macarons"); // echarts theme
import resize from "./resize";

export default {
  mixins: [resize],
  props: {
    className: {
      type: String,
      default: "chart",
    },
    width: {
      type: String,
      default: "100%",
    },
    height: {
      type: String,
      default: "300px",
    },
    chartData: {
      type: Object,
      required: true,
    },
  },
  data() {
    return {
      chart: null,
    };
  },
  watch: {
    chartData: {
      deep: true,
      handler(val) {
        this.setOptions(val);
      },
    },
  },
  mounted() {
    this.$nextTick(() => {
      this.initChart();
    });
  },
  beforeDestroy() {
    if (!this.chart) {
      return;
    }
    this.chart.dispose();
    this.chart = null;
  },
  methods: {
    initChart() {
      this.chart = echarts.init(this.$el, "macarons");
      this.setOptions(this.chartData);
    },
    setOptions({ title, xaxis, yaxis }) {
      let textTitle = {
        text: title,
        left: "center"
      };
      let categoryNames = [];
      let resultYaxis = [];
      let series = [];
      for (let yax of yaxis) {
        categoryNames.push(yax.name);

        resultYaxis.push({
          type: "value",
          name: yax.name,
          axisLabel: {
            formatter: "{value} " + yax.unit,
          },
        });

        series.push({
          name: yax.name,
          type: yax.type,
          data: yax.datas,
          animationDuration: 1000,
          animationEasing: 'cubicInOut'
        });
      }
      if (series.length > 0) {
        series[series.length - 1].yAxisIndex = resultYaxis.length - 1;
      }
      this.chart.setOption({
        title: textTitle,
        tooltip: {
          trigger: "axis",
          axisPointer: {
            type: "cross",
            crossStyle: {
              color: "#999",
            },
          },
        },
        toolbox: {
          feature: {
            dataView: { show: true, readOnly: false },
            magicType: { show: true, type: ["line", "bar"] },
            restore: { show: true },
            saveAsImage: { show: true },
          },
        },
        legend: {
          data: categoryNames,
          left: "center",
          top: "bottom"
        },
        xAxis: [
          {
            type: "category",
            data: xaxis,
            axisPointer: {
              type: "shadow",
            },
          },
        ],
        yAxis: resultYaxis,
        series: series,
      });
    },
  },
};
</script>
