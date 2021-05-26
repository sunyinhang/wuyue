<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" :inline="true" v-show="showSearch" label-width="80px">
      <el-form-item label="统计周期" label-width="80px">
        <el-radio-group v-model="queryParams.cycle" @change="getLineData">
          <el-radio
            v-for="dict in statisticsCycleOptions"
            :key="dict.dictValue"
            :label="dict.dictValue"
          >{{dict.dictLabel}}</el-radio>
        </el-radio-group>
      </el-form-item>
    </el-form>


<div style="position: relative;padding-left: calc(50% - 750px);">

  <line-chart :width="'1300px'" :height="'500px'" :chart-data="lineData1"/>
</div>

    <pagination
      v-show="total>0"
      :total="total"
      :page.sync="queryParams.pageNum"
      :limit.sync="queryParams.pageSize"
      @pagination="getList"
    />


  </div>
</template>

<script>
import { listSewageStatistics, getSewageStatistics, delSewageStatistics, addSewageStatistics, updateSewageStatistics, exportSewageStatistics, getLineData } from "@/api/yw/sewageStatistics";
import echarts from 'echarts'
import LineChart from "@/components/EcharsUtils/LineChart";

export default {
  name: "SewageStatistics",
  components: {
    LineChart
  },

  data() {
    return {
      // 遮罩层
      loading: true,
      // 选中数组
      ids: [],
      // 非单个禁用
      single: true,
      // 非多个禁用
      multiple: true,
      // 显示搜索条件
      showSearch: true,
      // 总条数
      total: 0,
      // 污水量统计， 按周期表格数据
      sewageStatisticsList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 状态数据字典
      statisticsCycleOptions: [],
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        cycle: 'hour',
        enter: null,
        out: null,
        beginDate: null,
        endTime: null
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
      },
      lineData1: {
        xdata: [1,2,3,4,5,6,7],
        ydata:{
          ydata1:[3,4,5,6,7],
          ydata2:[11,41,15,16,17],
        },
        lines: ['进水量', '排水量']
      }
    };
  },
  created() {
    this.getList();
    this.getLineData();
    this.getDicts("statistics_cycle").then(response => {
      this.statisticsCycleOptions = response.data;
    });
  },
  methods: {
    getLineData() {
      getLineData(this.queryParams.cycle).then(response => {
        this.lineData1 = response.data;
      });
    },
    /** 查询污水量统计， 按周期列表 */
    getList() {
      this.loading = true;
      listSewageStatistics(this.queryParams).then(response => {
        this.sewageStatisticsList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },
    // 取消按钮
    cancel() {
      this.open = false;
      this.reset();
    },
    // 表单重置
    reset() {
      this.form = {
        id: null,
        cycle: null,
        enter: null,
        out: null,
        beginDate: null,
        endTime: null
      };
      this.resetForm("form");
    },
    /** 搜索按钮操作 */
    handleQuery() {
      this.queryParams.pageNum = 1;
      this.getList();
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.resetForm("queryForm");
      this.handleQuery();
    },





  }
};
</script>
