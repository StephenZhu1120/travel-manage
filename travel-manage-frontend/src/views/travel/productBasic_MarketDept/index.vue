<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" :inline="true" v-show="showSearch" label-width="150px">
      <el-form-item label="旅游产品id" prop="id">
        <el-input
          v-model="queryParams.id"
          placeholder="请输入旅游产品id"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="旅游产品名称" prop="productName">
        <el-input
          v-model="queryParams.productName"
          placeholder="请输入旅游产品名称"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="旅游产品状态" prop="productStatus">
        <el-select v-model="queryParams.productStatus" placeholder="请选择旅游产品状态" clearable size="small">
          <el-option
            v-for="dict in productStatusOptions"
            :key="dict.dictValue"
            :label="dict.dictLabel"
            :value="dict.dictValue"
          />
        </el-select>
      </el-form-item>
      <!--      <el-form-item label="产品创建时间" prop="createTime">-->
      <!--        <el-date-picker clearable size="small"-->
      <!--          v-model="queryParams.createTime"-->
      <!--          type="date"-->
      <!--          value-format="yyyy-MM-dd"-->
      <!--          placeholder="选择产品创建时间">-->
      <!--        </el-date-picker>-->
      <!--      </el-form-item>-->
      <el-form-item label="产品最后编辑时间" prop="editTime">
        <el-date-picker clearable size="small"
                        v-model="queryParams.editTime"
                        type="date"
                        value-format="yyyy-MM-dd"
                        placeholder="选择产品最后编辑时间">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="旅行天数" prop="productDay">
        <el-input
          v-model="queryParams.productDay"
          placeholder="请输入旅行天数"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="出发地" prop="birthland">
        <el-input
          v-model="queryParams.birthland"
          placeholder="请输入出发地"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="目的地" prop="destination">
        <el-input
          v-model="queryParams.destination"
          placeholder="请输入目的地"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <!-- <el-form-item label="路线数量" prop="routeNumber">
        <el-input
          v-model="queryParams.routeNumber"
          placeholder="请输入路线数量"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item> -->
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery" style="margin-left: 150px">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery" style="margin-left: 75px">重置</el-button>
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button
          type="primary"
          plain
          icon="el-icon-plus"
          size="mini"
          @click="handleCreate"
          v-hasPermi="['travel:productBasic:add']"
        >新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['travel:productBasic:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="productBasicList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="旅游产品id" align="center" prop="id" width="100"/>
      <el-table-column label="旅游产品名称" align="center" prop="productName" width="500"/>
      <el-table-column label="旅游产品状态" align="center" prop="productStatus" :formatter="productStatusFormat" width="140"/>
      <el-table-column label="产品创建时间" align="center" prop="createTime" width="200">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.createTime, '{y}-{m}-{d} {h}:{i}:{s}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="产品最后编辑时间" align="center" prop="editTime" width="200">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.editTime, '{y}-{m}-{d} {h}:{i}:{s}') }}</span>
        </template>
      </el-table-column>
      <!--      <el-table-column label="产品策划" align="center" prop="productDesign" />-->
      <!--      <el-table-column label="产品计划" align="center" prop="productPlan" />-->
      <!--      <el-table-column label="出发地" align="center" prop="birthland" />-->
      <!--      <el-table-column label="目的地" align="center" prop="destination" />-->
      <!--      <el-table-column label="起始最低价格" align="center" prop="priceStart" />-->
      <!--      <el-table-column label="订单完成数量" align="center" prop="orderNumber" />-->
      <!--      <el-table-column label="产品展示文字" align="center" prop="description" />-->
      <!--      <el-table-column label="图片链接地址" align="center" prop="imgUrl" />-->
      <!--      <el-table-column label="图片宣传内容" align="center" prop="productDetailAds" />-->
      <!--      <el-table-column label="路线数量" align="center" prop="routeNumber" />-->
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="small"
            type="info"
            round
            icon="el-icon-edit"
            @click="handleView(scope.row)"
            v-hasPermi="['travel:productBasic:edit']"
          >查看详情</el-button>
          <el-button
            size="small"
            type="success"
            round
            icon="el-icon-edit"
            @click="handleDesign(scope.row)"
            v-hasPermi="['travel:productBasic:edit']"
          >设计产品</el-button>
          <el-button
            size="small"
            type="success"
            round
            icon="el-icon-edit"
            @click="handleEdit(scope.row)"
            v-hasPermi="['travel:productBasic:edit']"
          >编辑信息</el-button>
          <el-button
            size="small"
            type="danger"
            round
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['travel:productBasic:remove']"
          >删 除</el-button>
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

    <!-- 添加产品信息对话框 -->
    <el-dialog :title="title" :visible.sync="openCreate" width="1100px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="130px">
        <el-form-item label="旅游产品名称" prop="productName">
          <el-input v-model="form.productName" placeholder="请输入旅游产品名称" />
        </el-form-item>
        <el-form-item label="旅行天数" prop="productDay">
          <el-input v-model="form.productDay" placeholder="请输入旅行天数" />
        </el-form-item>
        <el-form-item label="产品设计">
          <editor v-model="form.productDesign" :min-height="192"/>
        </el-form-item>
        <el-form-item label="出发地" prop="birthland">
          <el-input v-model="form.birthland" placeholder="请输入出发地" />
        </el-form-item>
        <el-form-item label="目的地" prop="destination">
          <el-input v-model="form.destination" placeholder="请输入目的地" />
        </el-form-item>
        <el-form-item label="产品描述简介" prop="description">
          <el-input v-model="form.description" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="图片链接地址" prop="imgUrl">
          <el-input v-model="form.imgUrl" type="textarea" placeholder="请输入内容" />
          <span>多张图片请使用“;”（英文分号）作为分隔符</span>
        </el-form-item>
        <el-form-item label="图片宣传内容">
          <editor v-model="form.productDetailAds" :min-height="192"/>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>

    <!-- 修改产品信息对话框 -->
    <el-dialog :title="title" :visible.sync="openEdit" width="1100px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="130px">
        <el-form-item label="旅游产品名称" prop="productName">
          <el-input v-model="form.productName" placeholder="请输入旅游产品名称" />
        </el-form-item>
        <el-form-item label="旅行天数" prop="productDay">
          <el-input v-model="form.productDay" placeholder="请输入旅行天数" />
        </el-form-item>
        <el-form-item label="出发地" prop="birthland">
          <el-input v-model="form.birthland" placeholder="请输入出发地" />
        </el-form-item>
        <el-form-item label="目的地" prop="destination">
          <el-input v-model="form.destination" placeholder="请输入目的地" />
        </el-form-item>
        <el-form-item label="产品描述简介" prop="description">
          <el-input v-model="form.description" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="图片链接地址" prop="imgUrl">
          <el-input v-model="form.imgUrl" type="textarea" placeholder="请输入内容" />
          <span>多张图片请使用“;”（英文分号）作为分隔符</span>
        </el-form-item>
        <el-form-item label="图片宣传内容">
          <editor v-model="form.productDetailAds" :min-height="192"/>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>

    <!-- 查看产品信息对话框（无法编辑） -->
    <el-dialog :title="title" :visible.sync="openDetail" width="1100px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="130px">
        <el-form-item label="旅游产品名称" prop="productName">
          {{form.productName}}
        </el-form-item>
        <el-form-item label="旅游产品状态" prop="productStatus">
          <span v-if="form.productStatus === 0">已立项</span>
          <span v-else-if="form.productStatus === 1">筹备中</span>
          <span v-else-if="form.productStatus === 2">审核中</span>
          <span v-else-if="form.productStatus === 3">销售中</span>
          <span v-else-if="form.productStatus === 4">已下架</span>
          <span v-else-if="form.productStatus === 5">已隐藏</span>
        </el-form-item>
        <el-form-item label="旅行天数" prop="productDay">
          {{form.productDay}}
        </el-form-item>
        <el-form-item label="产品创建时间" prop="createTime">
          {{form.createTime}}
        </el-form-item>
        <el-form-item label="最后编辑时间" prop="editTime">
          {{form.editTime}}
        </el-form-item>
        <el-form-item label="产品设计" prop="productDesign">
          <span v-html="form.productDesign"></span>
        </el-form-item>
        <el-form-item label="产品策划" prop="productPlan">
          <span v-html="form.productPlan"></span>
        </el-form-item>
        <el-form-item label="出发地" prop="birthland">
          {{form.birthland}}
        </el-form-item>
        <el-form-item label="目的地" prop="destination">
          {{form.destination}}
        </el-form-item>
        <el-form-item label="起始最低价格" prop="priceStart">
          {{form.priceStart}}
        </el-form-item>
        <el-form-item label="订单完成数量" prop="orderNumber">
          {{form.orderNumber}}
        </el-form-item>
        <el-form-item label="产品展示文字" prop="description">
          {{form.description}}
        </el-form-item>
        <el-form-item label="图片链接地址" prop="imgUrl">
          {{form.imgUrl}}
        </el-form-item>
        <el-form-item label="图片宣传内容" prop="productDetailAds">
          <span v-html="form.productDetailAds"></span>
        </el-form-item>
        <el-form-item label="路线数量" prop="routeNumber">
          {{form.routeNumber}}
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <!--        <el-button type="primary" @click="submitForm">确 定</el-button>-->
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>

    <!-- 编辑产品设计对话框 -->
    <el-dialog :title="title" :visible.sync="openDesign" width="1000px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="100px">
        <el-form-item label="旅游产品名称" prop="productName">
          {{form.productName}}
        </el-form-item>
        <el-form-item label="产品设计">
          <editor v-model="form.productDesign" :min-height="192"/>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { listProductBasic, getProductBasic, delProductBasic, addProductBasic, updateProductBasic, exportProductBasic } from "@/api/travel/productBasic";
import Editor from '@/components/Editor';

export default {
  name: "ProductBasic",
  components: {
    Editor,
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
      // 产品信息表格数据
      productBasicList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      openCreate: false,
      openEdit: false,
      openDetail: false,
      openDesign: false,
      // 旅游产品状态字典
      productStatusOptions: [],
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        id: null,
        productName: null,
        productStatus: null,
        productDay: null,
        createTime: null,
        editTime: null,
        birthland: null,
        destination: null,
        routeNumber: null
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        productStatus: [
          { required: true, message: "旅游产品状态不能为空", trigger: "blur" }
        ],
      }
    };
  },
  created() {
    this.getList();
    this.getDicts("product_status_select").then(response => {
      this.productStatusOptions = response.data;
    });
  },
  methods: {
    /** 查询产品信息列表 */
    getList() {
      this.loading = true;
      listProductBasic(this.queryParams).then(response => {
        this.productBasicList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },
    // 旅游产品状态字典翻译
    productStatusFormat(row, column) {
      return this.selectDictLabel(this.productStatusOptions, row.productStatus);
    },
    // 取消按钮
    cancel() {
      this.openCreate = false;
      this.openDetail = false;
      this.openEdit = false;
      this.openDesign = false;
      this.reset();
    },
    // 表单重置
    reset() {
      this.form = {
        id: null,
        productName: null,
        productStatus: null,
        productDay: null,
        createTime: null,
        editTime: null,
        productDesign: null,
        productPlan: null,
        birthland: null,
        destination: null,
        priceStart: null,
        orderNumber: null,
        description: null,
        imgUrl: null,
        productDetailAds: null,
        routeNumber: null
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
    /** 新增按钮操作 */
    handleCreate() {
      this.reset();
      this.openCreate = true;
      this.title = "创建产品信息";
    },
    /** 修改按钮操作 */
    handleEdit(row) {
      this.reset();
      const id = row.id || this.ids
      getProductBasic(id).then(response => {
        this.form = response.data;
        this.openEdit = true;
        this.title = "修改产品信息";
      });
    },
    /** 详细按钮操作 */
    handleView(row) {
      this.openDetail = true;
      this.title = "产品信息详情";
      this.form = row;
    },
    /** 状态按钮操作 */
    handleDesign(row) {
      this.openDesign = true;
      this.title = "产品状态修改";
      this.form = row;
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateProductBasic(this.form).then(response => {
              this.msgSuccess("修改成功");
              this.openCreate = false;
              this.openEdit = false;
              this.openDesign = false;
              this.getList();
            });
          } else {
            addProductBasic(this.form).then(response => {
              this.msgSuccess("新增成功");
              this.openCreate = false;
              this.getList();
            });
          }
        }
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const ids = row.id || this.ids;
      this.$confirm('是否确认删除产品信息编号为"' + ids + '"的数据项?', "警告", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning"
      }).then(function() {
        return delProductBasic(ids);
      }).then(() => {
        this.getList();
        this.msgSuccess("删除成功");
      })
    },
    /** 导出按钮操作 */
    handleExport() {
      const queryParams = this.queryParams;
      this.$confirm('是否确认导出所有产品信息数据项?', "警告", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning"
      }).then(function() {
        return exportProductBasic(queryParams);
      }).then(response => {
        this.download(response.msg);
      })
    }
  }
};
</script>
