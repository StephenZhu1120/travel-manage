<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" :inline="true" v-show="showSearch" label-width="100px">
      <el-form-item label="订单id" prop="id">
        <el-input
          v-model="queryParams.id"
          placeholder="请输入订单id"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="产品id" prop="productId">
        <el-input
          v-model="queryParams.productId"
          placeholder="请输入产品id"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
<!--      <el-form-item label="路线id" prop="routeId">-->
<!--        <el-input-->
<!--          v-model="queryParams.routeId"-->
<!--          placeholder="请输入路线id"-->
<!--          clearable-->
<!--          size="small"-->
<!--          @keyup.enter.native="handleQuery"-->
<!--        />-->
<!--      </el-form-item>-->
<!--      <el-form-item label="产品名称" prop="productName">-->
<!--        <el-input-->
<!--          v-model="queryParams.productName"-->
<!--          placeholder="请输入产品名称"-->
<!--          clearable-->
<!--          size="small"-->
<!--          @keyup.enter.native="handleQuery"-->
<!--        />-->
<!--      </el-form-item>-->
      <el-form-item label="下单用户id" prop="userId">
        <el-input
          v-model="queryParams.userId"
          placeholder="请输入下单用户id"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="下单手机号" prop="phonenumber">
        <el-input
          v-model="queryParams.phonenumber"
          placeholder="请输入下单手机号"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
<!--      <el-form-item label="旅行时间" prop="travelTime">-->
<!--        <el-date-picker clearable size="small"-->
<!--          v-model="queryParams.travelTime"-->
<!--          type="date"-->
<!--          value-format="yyyy-MM-dd"-->
<!--          placeholder="选择旅行时间">-->
<!--        </el-date-picker>-->
<!--      </el-form-item>-->
<!--      <el-form-item label="下单时间" prop="orderTime">-->
<!--        <el-date-picker clearable size="small"-->
<!--          v-model="queryParams.orderTime"-->
<!--          type="date"-->
<!--          value-format="yyyy-MM-dd"-->
<!--          placeholder="选择下单时间">-->
<!--        </el-date-picker>-->
<!--      </el-form-item>-->
<!--      <el-form-item label="订单人数" prop="peopleNumber">-->
<!--        <el-input-->
<!--          v-model="queryParams.peopleNumber"-->
<!--          placeholder="请输入订单人数"-->
<!--          clearable-->
<!--          size="small"-->
<!--          @keyup.enter.native="handleQuery"-->
<!--        />-->
<!--      </el-form-item>-->
<!--      <el-form-item label="订单价格" prop="price">-->
<!--        <el-input-->
<!--          v-model="queryParams.price"-->
<!--          placeholder="请输入订单价格"-->
<!--          clearable-->
<!--          size="small"-->
<!--          @keyup.enter.native="handleQuery"-->
<!--        />-->
<!--      </el-form-item>-->
      <el-form-item label="订单状态" prop="orderStatus">
        <el-select v-model="queryParams.orderStatus" placeholder="请选择订单状态" clearable size="small">
          <el-option
            v-for="dict in orderStatusOptions"
            :key="dict.dictValue"
            :label="dict.dictLabel"
            :value="dict.dictValue"
          />
        </el-select>
      </el-form-item>
<!--      <el-form-item label="支付时间" prop="payTime">-->
<!--        <el-date-picker clearable size="small"-->
<!--          v-model="queryParams.payTime"-->
<!--          type="date"-->
<!--          value-format="yyyy-MM-dd"-->
<!--          placeholder="选择支付时间">-->
<!--        </el-date-picker>-->
<!--      </el-form-item>-->
<!--      <el-form-item label="支付方式" prop="payWay">-->
<!--        <el-select v-model="queryParams.payWay" placeholder="请选择支付方式" clearable size="small">-->
<!--          <el-option-->
<!--            v-for="dict in payWayOptions"-->
<!--            :key="dict.dictValue"-->
<!--            :label="dict.dictLabel"-->
<!--            :value="dict.dictValue"-->
<!--          />-->
<!--        </el-select>-->
<!--      </el-form-item>-->
<!--      <el-form-item label="退款时间" prop="refundTime">-->
<!--        <el-date-picker clearable size="small"-->
<!--          v-model="queryParams.refundTime"-->
<!--          type="date"-->
<!--          value-format="yyyy-MM-dd"-->
<!--          placeholder="选择退款时间">-->
<!--        </el-date-picker>-->
<!--      </el-form-item>-->
<!--      <el-form-item label="最后编辑时间" prop="editTime">-->
<!--        <el-date-picker clearable size="small"-->
<!--          v-model="queryParams.editTime"-->
<!--          type="date"-->
<!--          value-format="yyyy-MM-dd"-->
<!--          placeholder="选择最后编辑时间">-->
<!--        </el-date-picker>-->
<!--      </el-form-item>-->
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button
          type="primary"
          plain
          icon="el-icon-plus"
          size="mini"
          @click="handleAdd"
          v-hasPermi="['travel:orderBasic:add']"
        >新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          plain
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['travel:orderBasic:edit']"
        >修改</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          plain
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['travel:orderBasic:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['travel:orderBasic:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="orderBasicList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="订单id" align="center" prop="id" width="100"/>
<!--      <el-table-column label="产品id" align="center" prop="productId" />-->
<!--      <el-table-column label="具体路线id" align="center" prop="routeId" />-->
      <el-table-column label="产品名称" align="center" prop="productName" width="300"/>
<!--      <el-table-column label="下单用户id" align="center" prop="userId" />-->
      <el-table-column label="下单手机号" align="center" prop="phonenumber" width="150"/>
<!--      <el-table-column label="旅行时间" align="center" prop="travelTime" width="180">-->
<!--        <template slot-scope="scope">-->
<!--          <span>{{ parseTime(scope.row.travelTime, '{y}-{m}-{d}') }}</span>-->
<!--        </template>-->
<!--      </el-table-column>-->
      <el-table-column label="下单时间" align="center" prop="orderTime" width="300">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.orderTime, '{y}-{m}-{d} {h}:{i}:{s}') }}</span>
        </template>
      </el-table-column>
<!--      <el-table-column label="订单人数" align="center" prop="peopleNumber" />-->
      <el-table-column label="订单价格" align="center" prop="price" width="100"/>
      <el-table-column label="订单状态" align="center" prop="orderStatus" :formatter="orderStatusFormat" width="100"/>
<!--      <el-table-column label="支付时间" align="center" prop="payTime" width="180">-->
<!--        <template slot-scope="scope">-->
<!--          <span>{{ parseTime(scope.row.payTime, '{y}-{m}-{d}') }}</span>-->
<!--        </template>-->
<!--      </el-table-column>-->
<!--      <el-table-column label="支付备注" align="center" prop="payComment" />-->
<!--      <el-table-column label="支付方式" align="center" prop="payWay" :formatter="payWayFormat" />-->
<!--      <el-table-column label="退款时间" align="center" prop="refundTime" width="180">-->
<!--        <template slot-scope="scope">-->
<!--          <span>{{ parseTime(scope.row.refundTime, '{y}-{m}-{d}') }}</span>-->
<!--        </template>-->
<!--      </el-table-column>-->
<!--      <el-table-column label="退款备注" align="center" prop="refundComment" />-->
<!--      <el-table-column label="最后编辑时间" align="center" prop="editTime" width="180">-->
<!--        <template slot-scope="scope">-->
<!--          <span>{{ parseTime(scope.row.editTime, '{y}-{m}-{d}') }}</span>-->
<!--        </template>-->
<!--      </el-table-column>-->
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['travel:orderBasic:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['travel:orderBasic:remove']"
          >删除</el-button>
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

    <!-- 添加或修改订单管理对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="下单产品id" prop="productId">
          <el-input v-model="form.productId" placeholder="请输入下单产品id" />
        </el-form-item>
        <el-form-item label="具体路线id" prop="routeId">
          <el-input v-model="form.routeId" placeholder="请输入具体路线id" />
        </el-form-item>
        <el-form-item label="产品名称" prop="productName">
          <el-input v-model="form.productName" placeholder="请输入产品名称" />
        </el-form-item>
        <el-form-item label="下单用户id" prop="userId">
          <el-input v-model="form.userId" placeholder="请输入下单用户id" />
        </el-form-item>
        <el-form-item label="下单手机号" prop="phonenumber">
          <el-input v-model="form.phonenumber" placeholder="请输入下单手机号" />
        </el-form-item>
        <el-form-item label="旅行时间" prop="travelTime">
          <el-date-picker clearable size="small"
            v-model="form.travelTime"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="选择旅行时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="下单时间" prop="orderTime">
          <el-date-picker clearable size="small"
            v-model="form.orderTime"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="选择下单时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="订单人数" prop="peopleNumber">
          <el-input v-model="form.peopleNumber" placeholder="请输入订单人数" />
        </el-form-item>
        <el-form-item label="订单价格" prop="price">
          <el-input v-model="form.price" placeholder="请输入订单价格" />
        </el-form-item>
        <el-form-item label="订单状态" prop="orderStatus">
          <el-select v-model="form.orderStatus" placeholder="请选择订单状态">
            <el-option
              v-for="dict in orderStatusOptions"
              :key="dict.dictValue"
              :label="dict.dictLabel"
              :value="parseInt(dict.dictValue)"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="支付时间" prop="payTime">
          <el-date-picker clearable size="small"
            v-model="form.payTime"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="选择支付时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="支付备注" prop="payComment">
          <el-input v-model="form.payComment" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="支付方式" prop="payWay">
          <el-select v-model="form.payWay" placeholder="请选择支付方式">
            <el-option
              v-for="dict in payWayOptions"
              :key="dict.dictValue"
              :label="dict.dictLabel"
              :value="parseInt(dict.dictValue)"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="退款时间" prop="refundTime">
          <el-date-picker clearable size="small"
            v-model="form.refundTime"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="选择退款时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="退款备注" prop="refundComment">
          <el-input v-model="form.refundComment" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="最后编辑时间" prop="editTime">
          <el-date-picker clearable size="small"
            v-model="form.editTime"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="选择最后编辑时间">
          </el-date-picker>
        </el-form-item>
        <el-divider content-position="center">订单成员管理信息</el-divider>
        <el-row :gutter="10" class="mb8">
          <el-col :span="1.5">
            <el-button type="primary" icon="el-icon-plus" size="mini" @click="handleAddOrderMember">添加</el-button>
          </el-col>
          <el-col :span="1.5">
            <el-button type="danger" icon="el-icon-delete" size="mini" @click="handleDeleteOrderMember">删除</el-button>
          </el-col>
        </el-row>
        <el-table :data="orderMemberList" :row-class-name="rowOrderMemberIndex" @selection-change="handleOrderMemberSelectionChange" ref="orderMember">
          <el-table-column type="selection" width="50" align="center" />
          <el-table-column label="序号" align="center" prop="index" width="50"/>
          <el-table-column label="真实姓名" prop="memberName">
            <template slot-scope="scope">
              <el-input v-model="scope.row.memberName" placeholder="请输入真实姓名" />
            </template>
          </el-table-column>
          <el-table-column label="身份证号" prop="memberIdCard">
            <template slot-scope="scope">
              <el-input v-model="scope.row.memberIdCard" placeholder="请输入身份证号" />
            </template>
          </el-table-column>
          <el-table-column label="手机号码" prop="memberPhonenumber">
            <template slot-scope="scope">
              <el-input v-model="scope.row.memberPhonenumber" placeholder="请输入手机号码" />
            </template>
          </el-table-column>
          <el-table-column label="性别" prop="memberSex">
            <template slot-scope="scope">
              <el-input v-model="scope.row.memberSex" placeholder="请输入性别" />
            </template>
          </el-table-column>
        </el-table>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { listOrderBasic, getOrderBasic, delOrderBasic, addOrderBasic, updateOrderBasic, exportOrderBasic } from "@/api/travel/orderBasic";

export default {
  name: "OrderBasic",
  components: {
  },
  data() {
    return {
      // 遮罩层
      loading: true,
      // 选中数组
      ids: [],
      // 子表选中数据
      checkedOrderMember: [],
      // 非单个禁用
      single: true,
      // 非多个禁用
      multiple: true,
      // 显示搜索条件
      showSearch: true,
      // 总条数
      total: 0,
      // 订单管理表格数据
      orderBasicList: [],
      // 订单成员管理表格数据
      orderMemberList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 订单状态字典
      orderStatusOptions: [],
      // 支付方式字典
      payWayOptions: [],
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        id: null,
        productId: null,
        routeId: null,
        productName: null,
        userId: null,
        phonenumber: null,
        travelTime: null,
        orderTime: null,
        peopleNumber: null,
        price: null,
        orderStatus: null,
        payTime: null,
        payWay: null,
        refundTime: null,
        editTime: null
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
    this.getDicts("order_status_select").then(response => {
      this.orderStatusOptions = response.data;
    });
    this.getDicts("pay_way_select").then(response => {
      this.payWayOptions = response.data;
    });
  },
  methods: {
    /** 查询订单管理列表 */
    getList() {
      this.loading = true;
      listOrderBasic(this.queryParams).then(response => {
        this.orderBasicList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },
    // 订单状态字典翻译
    orderStatusFormat(row, column) {
      return this.selectDictLabel(this.orderStatusOptions, row.orderStatus);
    },
    // 支付方式字典翻译
    payWayFormat(row, column) {
      return this.selectDictLabel(this.payWayOptions, row.payWay);
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
        productId: null,
        routeId: null,
        productName: null,
        userId: null,
        phonenumber: null,
        travelTime: null,
        orderTime: null,
        peopleNumber: null,
        price: null,
        orderStatus: null,
        payTime: null,
        payComment: null,
        payWay: null,
        refundTime: null,
        refundComment: null,
        editTime: null
      };
      this.orderMemberList = [];
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
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加订单管理";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getOrderBasic(id).then(response => {
        this.form = response.data;
        this.orderMemberList = response.data.orderMemberList;
        this.open = true;
        this.title = "修改订单管理";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          this.form.orderMemberList = this.orderMemberList;
          if (this.form.id != null) {
            updateOrderBasic(this.form).then(response => {
              this.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addOrderBasic(this.form).then(response => {
              this.msgSuccess("新增成功");
              this.open = false;
              this.getList();
            });
          }
        }
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const ids = row.id || this.ids;
      this.$confirm('是否确认删除订单管理编号为"' + ids + '"的数据项?', "警告", {
          confirmButtonText: "确定",
          cancelButtonText: "取消",
          type: "warning"
        }).then(function() {
          return delOrderBasic(ids);
        }).then(() => {
          this.getList();
          this.msgSuccess("删除成功");
        })
    },
	/** 订单成员管理序号 */
    rowOrderMemberIndex({ row, rowIndex }) {
      row.index = rowIndex + 1;
    },
    /** 订单成员管理添加按钮操作 */
    handleAddOrderMember() {
      let obj = {};
      obj.memberName = "";
      obj.memberIdCard = "";
      obj.memberPhonenumber = "";
      obj.memberSex = "";
      this.orderMemberList.push(obj);
    },
    /** 订单成员管理删除按钮操作 */
    handleDeleteOrderMember() {
      if (this.checkedOrderMember.length == 0) {
        this.$alert("请先选择要删除的订单成员管理数据", "提示", { confirmButtonText: "确定", });
      } else {
        this.orderMemberList.splice(this.checkedOrderMember[0].index - 1, 1);
      }
    },
    /** 单选框选中数据 */
    handleOrderMemberSelectionChange(selection) {
      if (selection.length > 1) {
        this.$refs.orderMember.clearSelection();
        this.$refs.orderMember.toggleRowSelection(selection.pop());
      } else {
        this.checkedOrderMember = selection;
      }
    },
    /** 导出按钮操作 */
    handleExport() {
      const queryParams = this.queryParams;
      this.$confirm('是否确认导出所有订单管理数据项?', "警告", {
          confirmButtonText: "确定",
          cancelButtonText: "取消",
          type: "warning"
        }).then(function() {
          return exportOrderBasic(queryParams);
        }).then(response => {
          this.download(response.msg);
        })
    }
  }
};
</script>
