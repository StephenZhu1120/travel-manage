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
      <el-table-column label="订单状态" align="center" prop="orderStatus" :formatter="orderStatusFormat" width="120"/>
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
            size="small"
            type="info"
            round
            icon="el-icon-edit"
            @click="handleView(scope.row)"
          >查看详情</el-button>
<!--          <el-button-->
<!--            size="small"-->
<!--            type="success"-->
<!--            round-->
<!--            icon="el-icon-edit"-->
<!--            @click="handleSaleEditMember(scope.row)"-->
<!--            :disabled="! (scope.row.orderStatus===0 || scope.row.orderStatus===1)"-->
<!--            v-hasPermi="['travel:orderBasic:edit']"-->
<!--          >编辑成员</el-button>-->
<!--          <el-button-->
<!--            size="small"-->
<!--            type="success"-->
<!--            round-->
<!--            icon="el-icon-edit"-->
<!--            @click="handleSalePayOrder(scope.row)"-->
<!--            :disabled="scope.row.orderStatus !== 0"-->
<!--            v-hasPermi="['travel:orderBasic:edit']"-->
<!--          >支付订单</el-button>-->
<!--          <el-button-->
<!--            size="small"-->
<!--            type="success"-->
<!--            round-->
<!--            icon="el-icon-edit"-->
<!--            @click="handleSaleCancelOrder(scope.row)"-->
<!--            :disabled="! (scope.row.orderStatus===0 || scope.row.orderStatus===1)"-->
<!--            v-hasPermi="['travel:orderBasic:edit']"-->
<!--          >取消订单</el-button>-->
          <el-button
            size="small"
            type="danger"
            round
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            disabled
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

    <!-- 编辑订单成员对话框 -->
    <el-dialog :title="title" :visible.sync="openSaleEditMember" width="1000px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="100px">
        <el-form-item label="订单id" prop="id" >
          {{form.id}}
        </el-form-item>
        <el-form-item label="产品名称" prop="productName" >
          {{form.productName}}
        </el-form-item>
        <el-form-item label="下单用户id" prop="userId" >
          {{ form.userId }}
        </el-form-item>
        <el-form-item label="旅行时间" prop="travelTime">
          {{form.travelTime}}
        </el-form-item>
        <el-form-item label="订单人数" prop="peopleNumber">
          {{form.peopleNumber}}
        </el-form-item>
        <el-form-item label="订单状态" prop="orderStatus">
          <span v-if="form.orderStatus === 0">已下单，暂未支付</span>
          <span v-else-if="form.orderStatus === 1">已支付</span>
          <span v-else-if="form.orderStatus === 2">未支付，超时自动取消</span>
          <span v-else-if="form.orderStatus === 3">未支付，已主动取消</span>
          <span v-else-if="form.orderStatus === 4">已取消，待财务退款</span>
          <span v-else-if="form.orderStatus === 5">已退款</span>
          <span v-else-if="form.orderStatus === 6">已完成</span>
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
          <el-table-column label="真实姓名" prop="memberName" align="center">
            <template slot-scope="scope">
              <el-input v-model="scope.row.memberName" placeholder="请输入真实姓名" />
            </template>
          </el-table-column>
          <el-table-column label="身份证号" prop="memberIdCard" align="center">
            <template slot-scope="scope">
              <el-input v-model="scope.row.memberIdCard" placeholder="请输入身份证号" />
            </template>
          </el-table-column>
          <el-table-column label="手机号码" prop="memberPhonenumber" align="center">
            <template slot-scope="scope">
              <el-input v-model="scope.row.memberPhonenumber" placeholder="请输入手机号码" />
            </template>
          </el-table-column>
        </el-table>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>

    <!-- 门市部支付订单对话框 -->
    <el-dialog :title="title" :visible.sync="openSalePayOrder" width="1000px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="100px">
        <el-form-item label="下单手机号" prop="phonenumber">
          {{form.phonenumber}}
        </el-form-item>
        <el-form-item label="订单人数" prop="peopleNumber">
          {{form.peopleNumber}}
        </el-form-item>
        <el-form-item label="订单价格" prop="price">
          {{form.price}}
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
        <el-form-item label="支付备注" prop="payComment">
          <el-input v-model="form.payComment" type="textarea" placeholder="请输入内容" />
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitFormPay">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>

    <!-- 查看订单详情管理对话框(无法编辑) -->
    <el-dialog :title="title" :visible.sync="openDetail" width="1000px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="100px" label-position="right">
        <el-form-item label="下单产品id" prop="productId" >
          {{form.productId}}
        </el-form-item>
        <el-form-item label="产品名称" prop="productName" >
          {{form.productName}}
        </el-form-item>
        <el-form-item label="具体路线id" prop="routeId" >
          {{form.routeId}}
        </el-form-item>
        <el-form-item label="下单用户id" prop="userId" >
          {{form.userId}}
        </el-form-item>
        <el-form-item label="下单手机号" prop="phonenumber">
          {{ form.phonenumber }}
        </el-form-item>
        <el-form-item label="旅行时间" prop="travelTime">
          {{form.travelTime}}
        </el-form-item>
        <el-form-item label="下单时间" prop="orderTime">
          {{form.orderTime}}
        </el-form-item>
        <el-form-item label="订单人数" prop="peopleNumber">
          {{ form.peopleNumber }}
        </el-form-item>
        <el-form-item label="订单价格" prop="price">
          {{ form.price }}
        </el-form-item>
        <el-form-item label="订单状态" prop="orderStatus">
          <span v-if="form.orderStatus === 0">已下单，暂未支付</span>
          <span v-else-if="form.orderStatus === 1">已支付</span>
          <span v-else-if="form.orderStatus === 2">未支付，超时自动取消</span>
          <span v-else-if="form.orderStatus === 3">未支付，已主动取消</span>
          <span v-else-if="form.orderStatus === 4">已取消，待财务退款</span>
          <span v-else-if="form.orderStatus === 5">已退款</span>
          <span v-else-if="form.orderStatus === 6">已完成</span>
        </el-form-item>
        <el-form-item label="支付时间" prop="payTime">
          {{form.payTime}}
        </el-form-item>
        <el-form-item label="支付备注" prop="payComment">
          {{form.payComment}}
        </el-form-item>
        <el-form-item label="支付方式" prop="payWay">
          <span v-if="form.payWay === 0">现金</span>
          <span v-else-if="form.payWay === 1">银行卡</span>
          <span v-else-if="form.payWay === 2">电子支付</span>
        </el-form-item>
        <el-form-item label="退款时间" prop="refundTime">
          {{form.refundTime}}
        </el-form-item>
        <el-form-item label="退款备注" prop="refundComment">
          {{form.refundComment}}
        </el-form-item>
        <el-form-item label="最后编辑时间" prop="editTime">
          {{form.editTime}}
        </el-form-item>
        <el-divider content-position="center">订单成员管理信息</el-divider>
        <!--        <el-row :gutter="10" class="mb8">-->
        <!--          <el-col :span="1.5">-->
        <!--            <el-button type="primary" icon="el-icon-plus" size="mini" @click="handleAddOrderMember">添加</el-button>-->
        <!--          </el-col>-->
        <!--          <el-col :span="1.5">-->
        <!--            <el-button type="danger" icon="el-icon-delete" size="mini" @click="handleDeleteOrderMember">删除</el-button>-->
        <!--          </el-col>-->
        <!--        </el-row>-->
        <el-table :data="orderMemberList" :row-class-name="rowOrderMemberIndex" @selection-change="handleOrderMemberSelectionChange" ref="orderMember">
          <!--          <el-table-column type="selection" width="50" align="center" />-->
          <el-table-column label="序号" align="center" prop="index" width="50"/>
          <el-table-column label="真实姓名" prop="memberName" align="center">
            <template slot-scope="scope">
              {{scope.row.memberName}}
            </template>
          </el-table-column>
          <el-table-column label="身份证号" prop="memberIdCard" align="center">
            <template slot-scope="scope">
              {{scope.row.memberIdCard}}
            </template>
          </el-table-column>
          <el-table-column label="手机号码" prop="memberPhonenumber" align="center">
            <template slot-scope="scope">
              {{scope.row.memberPhonenumber}}
            </template>
          </el-table-column>
          <!--          <el-table-column label="性别" prop="memberSex">-->
          <!--            <template slot-scope="scope">-->
          <!--              <span v-if="scope.row.memberSex === 0">未设置</span>-->
          <!--              <span v-else-if="scope.row.memberSex === 1">男</span>-->
          <!--              <span v-else-if="scope.row.memberSex === 2">女</span>-->
          <!--            </template>-->
          <!--          </el-table-column>-->
        </el-table>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <!--        <el-button type="primary" @click="submitForm">确 定</el-button>-->
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { listOrderBasic, getOrderBasic, delOrderBasic, addOrderBasic, updateOrderBasic, exportOrderBasic,
  cancelOrderBasic, changeOrderStatus_PAY} from "@/api/travel/orderBasic";

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
      openDetail: false,
      openSaleEditMember: false,
      openSalePayOrder: false,
      // 订单状态字典
      orderStatusOptions: [],
      // 支付方式字典
      payWayOptions: [],
      //客户性别字典
      sexOptions: [],
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
    this.getDicts("user_sex_select").then(response => {
      this.sexOptions = response.data;
    })
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
    // 性别字典翻译
    sexFormat(row, column) {
      return this.selectDictLabel(this.sexOptions, row.sex);
    },
    // 取消按钮
    cancel() {
      this.open = false;
      this.openDetail = false;
      this.openSaleEditMember = false;
      this.openSalePayOrder = false;
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
      this.title = "添加订单信息";
    },
    /** 全变量！！！修改按钮操作 */
    // handleUpdate(row) {
    //   this.reset();
    //   const id = row.id || this.ids
    //   getOrderBasic(id).then(response => {
    //     this.form = response.data;
    //     this.orderMemberList = response.data.orderMemberList;
    //     this.open = true;
    //     this.title = "修改订单信息（管理员）";
    //   });
    // },
    /** 修改按钮操作 */
    handleSaleEditMember(row) {
      this.reset();
      const id = row.id || this.ids
      getOrderBasic(id).then(response => {
        this.form = response.data;
        this.orderMemberList = response.data.orderMemberList;
        this.openSaleEditMember = true;
        this.title = "修改订单信息";
      });
    },
    /** 支付按钮操作 */
    handleSalePayOrder(row) {
      this.reset();
      const id = row.id || this.ids
      getOrderBasic(id).then(response => {
        this.form = response.data;
        this.orderMemberList = response.data.orderMemberList;
        this.openSalePayOrder = true;
        this.title = "修改订单信息";
      });
    },
    /** 详情按钮操作 */
    handleView(row) {
      this.reset();
      const id = row.id || this.ids
      getOrderBasic(id).then(response => {
        this.form = response.data;
        this.orderMemberList = response.data.orderMemberList;
        this.openDetail = true;
        this.title = "查看订单详情";
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
              this.openSaleEditMember = false;
              this.openSalePayOrder  = false;
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

    /** 提交支付按钮 */
    submitFormPay() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          this.form.orderMemberList = this.orderMemberList;
          if (this.form.id != null) {
            updateOrderBasic(this.form).then(response => {
              this.msgSuccess("支付成功");
              this.openSalePayOrder  = false;
              this.getList();
              changeOrderStatus_PAY(this.form.id).then(response => {
                this.msgSuccess("订单状态修改成功");
                this.openSalePayOrder  = false;
                this.getList();
              });
            });

          } else {
            this.msgSuccess("新增成功");
            this.openSalePayOrder = false;
            this.getList();
          }
        }
      });
    },

    /** 取消订单按钮操作 */
    handleSaleCancelOrder(row) {
      const id = row.id;
      this.$confirm('是否确认取消订单编号为"' + id + '"的数据项?', "警告", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning"
      }).then(function() {
        return cancelOrderBasic(id);
      }).then(() => {
        this.getList();
        this.msgSuccess("取消成功");
      })
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
