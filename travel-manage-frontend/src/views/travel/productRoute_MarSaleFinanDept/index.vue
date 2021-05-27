<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" :inline="true" v-show="showSearch" label-width="150px">
      <el-form-item label="路线id" prop="id">
        <el-input
          v-model="queryParams.id"
          placeholder="请输入路线id"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="所属产品id" prop="productId">
        <el-input
          v-model="queryParams.productId"
          placeholder="请输入所属产品id"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="所属产品名称" prop="productName">
        <el-input
          placeholder="请输入所属产品名称"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="路线名称" prop="routeName">
        <el-input
          v-model="queryParams.routeName"
          placeholder="请输入路线名称"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
<!--      <el-form-item label="路线价格" prop="price">-->
<!--        <el-input-->
<!--          v-model="queryParams.price"-->
<!--          placeholder="请输入路线价格"-->
<!--          clearable-->
<!--          size="small"-->
<!--          @keyup.enter.native="handleQuery"-->
<!--        />-->
<!--      </el-form-item>-->
<!--      <el-form-item label="交通工具描述" prop="transportType">-->
<!--        <el-input-->
<!--          v-model="queryParams.transportType"-->
<!--          placeholder="请输入交通工具描述"-->
<!--          clearable-->
<!--          size="small"-->
<!--          @keyup.enter.native="handleQuery"-->
<!--        />-->
<!--      </el-form-item>-->
<!--      <el-form-item label="交通工具部分价格" prop="transportPrice">-->
<!--        <el-input-->
<!--          v-model="queryParams.transportPrice"-->
<!--          placeholder="请输入交通工具部分价格"-->
<!--          clearable-->
<!--          size="small"-->
<!--          @keyup.enter.native="handleQuery"-->
<!--        />-->
<!--      </el-form-item>-->
<!--      <el-form-item label="宾馆描述" prop="hotelType">-->
<!--        <el-input-->
<!--          v-model="queryParams.hotelType"-->
<!--          placeholder="请输入宾馆描述"-->
<!--          clearable-->
<!--          size="small"-->
<!--          @keyup.enter.native="handleQuery"-->
<!--        />-->
<!--      </el-form-item>-->
<!--      <el-form-item label="宾馆部分价格" prop="hotelPrice">-->
<!--        <el-input-->
<!--          v-model="queryParams.hotelPrice"-->
<!--          placeholder="请输入宾馆部分价格"-->
<!--          clearable-->
<!--          size="small"-->
<!--          @keyup.enter.native="handleQuery"-->
<!--        />-->
<!--      </el-form-item>-->
<!--      <el-form-item label="旅行描述" prop="travelType">-->
<!--        <el-input-->
<!--          v-model="queryParams.travelType"-->
<!--          placeholder="请输入旅行描述"-->
<!--          clearable-->
<!--          size="small"-->
<!--          @keyup.enter.native="handleQuery"-->
<!--        />-->
<!--      </el-form-item>-->
<!--      <el-form-item label="旅行部分价格" prop="travelPrice">-->
<!--        <el-input-->
<!--          v-model="queryParams.travelPrice"-->
<!--          placeholder="请输入旅行部分价格"-->
<!--          clearable-->
<!--          size="small"-->
<!--          @keyup.enter.native="handleQuery"-->
<!--        />-->
<!--      </el-form-item>-->
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="productRouteList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="路线id" align="center" prop="id" width="100"/>
      <el-table-column label="所属产品名称" align="center" prop="productName" width="500"/>
      <el-table-column label="路线名称" align="center" prop="routeName" width="400"/>
      <el-table-column label="路线价格" align="center" prop="price" width="200"/>
<!--      <el-table-column label="交通工具描述" align="center" prop="transportType" />-->
<!--      <el-table-column label="交通工具部分价格" align="center" prop="transportPrice" />-->
<!--      <el-table-column label="宾馆描述" align="center" prop="hotelType" />-->
<!--      <el-table-column label="宾馆部分价格" align="center" prop="hotelPrice" />-->
<!--      <el-table-column label="旅行描述" align="center" prop="travelType" />-->
<!--      <el-table-column label="旅行部分价格" align="center" prop="travelPrice" />-->
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="small"
            type="info"
            round
            icon="el-icon-edit"
            @click="handleView(scope.row)"
            v-hasPermi="['travel:productRoute:edit']"
          >查看详情</el-button>
        </template>
      </el-table-column>
    </el-table>

    <pagination
      v-show="total>0"
      :total="total"
      :page.sync="queryParams.pageNum"
      :limit.sync="queryParams.pageSize"
      @pagination="getList"
    />
    <!-- 查看产品路线详情对话框（不可编辑） -->
    <el-dialog :title="title" :visible.sync="openDetail" width="600px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="130px">
        <el-form-item label="所属产品id" prop="productId">
          {{form.productId}}
        </el-form-item>
        <el-form-item label="路线名称" prop="routeName">
          {{form.routeName}}
        </el-form-item>
        <el-form-item label="路线价格" prop="price">
          {{form.price}}
        </el-form-item>
        <el-form-item label="交通工具描述" prop="transportType" style="margin-top: 80px">
          {{form.transportType}}
        </el-form-item>
        <el-form-item label="交通工具部分价格" prop="transportPrice">
          {{form.transportPrice}}
        </el-form-item>
        <el-form-item label="宾馆描述" prop="hotelType" style="margin-top: 50px">
          {{form.hotelType}}
        </el-form-item>
        <el-form-item label="宾馆部分价格" prop="hotelPrice">
          {{form.hotelPrice}}
        </el-form-item>
        <el-form-item label="旅行描述" prop="travelType" style="margin-top: 50px">
          {{form.travelType}}
        </el-form-item>
        <el-form-item label="旅行部分价格" prop="travelPrice">
          {{form.travelPrice}}
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
<!--        <el-button type="primary" @click="submitForm">确 定</el-button>-->
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { listProductRoute, getProductRoute, delProductRoute, addProductRoute, updateProductRoute, exportProductRoute } from "@/api/travel/productRoute";

export default {
  name: "ProductRoute",
  components: {
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
      // 产品路线表格数据
      productRouteList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      openDetail: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        id: null,
        productId: null,
        productName: null,
        routeName: null,
        price: null,
        transportType: null,
        transportPrice: null,
        hotelType: null,
        hotelPrice: null,
        travelType: null,
        travelPrice: null
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询产品路线列表 */
    getList() {
      this.loading = true;
      listProductRoute(this.queryParams).then(response => {
        this.productRouteList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },
    // 取消按钮
    cancel() {
      this.openDetail = false;
      this.reset();
    },
    // 表单重置
    reset() {
      this.form = {
        id: null,
        productId: null,
        productName: null,
        routeName: null,
        price: null,
        transportType: null,
        transportPrice: null,
        hotelType: null,
        hotelPrice: null,
        travelType: null,
        travelPrice: null
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
    // 多选框选中数据
    handleSelectionChange(selection) {
      this.ids = selection.map(item => item.id)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 详细按钮操作 */
    handleView(row) {
      this.openDetail = true;
      this.title = "产品路线详情";
      this.form = row;
    }
  }
};
</script>
