<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" :inline="true" v-show="showSearch" label-width="80px">
      <el-form-item label="用户id" prop="id">
        <el-input
          v-model="queryParams.id"
          placeholder="请输入用户id"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="用户昵称" prop="userName">
        <el-input
          v-model="queryParams.userName"
          placeholder="请输入用户昵称"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="用户状态" prop="userStatus">
        <el-select v-model="queryParams.userStatus" placeholder="请选择用户状态" clearable size="small">
          <el-option
            v-for="dict in userStatusOptions"
            :key="dict.dictValue"
            :label="dict.dictLabel"
            :value="dict.dictValue"
          />
        </el-select>
      </el-form-item>
      <!--      <el-form-item label="账号创建时间" prop="createTime">-->
      <!--        <el-date-picker clearable size="small"-->
      <!--          v-model="queryParams.createTime"-->
      <!--          type="date"-->
      <!--          value-format="yyyy-MM-dd"-->
      <!--          placeholder="选择账号创建时间">-->
      <!--        </el-date-picker>-->
      <!--      </el-form-item>-->
      <!--      <el-form-item label="真实姓名" prop="userIdName">-->
      <!--        <el-input-->
      <!--          v-model="queryParams.userIdName"-->
      <!--          placeholder="请输入真实姓名"-->
      <!--          clearable-->
      <!--          size="small"-->
      <!--          @keyup.enter.native="handleQuery"-->
      <!--        />-->
      <!--      </el-form-item>-->
      <!--      <el-form-item label="身份证号" prop="userIdCard">-->
      <!--        <el-input-->
      <!--          v-model="queryParams.userIdCard"-->
      <!--          placeholder="请输入身份证号"-->
      <!--          clearable-->
      <!--          size="small"-->
      <!--          @keyup.enter.native="handleQuery"-->
      <!--        />-->
      <!--      </el-form-item>-->
      <!--      <el-form-item label="电子邮箱" prop="email">-->
      <!--        <el-input-->
      <!--          v-model="queryParams.email"-->
      <!--          placeholder="请输入电子邮箱"-->
      <!--          clearable-->
      <!--          size="small"-->
      <!--          @keyup.enter.native="handleQuery"-->
      <!--        />-->
      <!--      </el-form-item>-->
      <el-form-item label="手机号码" prop="phoneNumber">
        <el-input
          v-model="queryParams.phoneNumber"
          placeholder="请输入手机号码"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <!--      <el-form-item label="性别" prop="sex">-->
      <!--        <el-select v-model="queryParams.sex" placeholder="请选择性别" clearable size="small">-->
      <!--          <el-option-->
      <!--            v-for="dict in sexOptions"-->
      <!--            :key="dict.dictValue"-->
      <!--            :label="dict.dictLabel"-->
      <!--            :value="dict.dictValue"-->
      <!--          />-->
      <!--        </el-select>-->
      <!--      </el-form-item>-->
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="userBasicList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="用户id" align="center" prop="id" width="100"/>
      <el-table-column label="用户昵称" align="center" prop="userName" width="300" />
      <!--      <el-table-column label="用户密码" align="center" prop="password" />-->
      <el-table-column label="用户状态" align="center" prop="userStatus" width="100" :formatter="userStatusFormat" />
      <el-table-column label="账号创建时间" align="center" prop="createTime" width="300">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.createTime, '{y}-{m}-{d} {h}:{i}:{s}') }}</span>
        </template>
      </el-table-column>
      <!--      <el-table-column label="真实姓名" align="center" prop="userIdName" />-->
      <!--      <el-table-column label="身份证号" align="center" prop="userIdCard" />-->
      <!--      <el-table-column label="电子邮箱" align="center" prop="email" />-->
      <el-table-column label="手机号码" align="center" prop="phoneNumber" width="250"/>
      <!--      <el-table-column label="性别" align="center" prop="sex" :formatter="sexFormat" />-->
      <!--      <el-table-column label="头像链接地址" align="center" prop="avatar" />-->
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="small"
            type="info"
            round
            icon="el-icon-edit"
            @click="handleView(scope.row)"
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

    <!--    查看详情页（无法编辑）-->
    <el-dialog :title="title" :visible.sync="openDetail" width="600px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="110px">
        <el-form-item label="用户昵称" prop="userName">
          {{form.userName}}
        </el-form-item>
        <el-form-item label="用户状态" prop="userStatus">
          <span v-if="form.userStatus === 0">封禁</span>
          <span v-else>正常</span>
        </el-form-item>
        <el-form-item label="账号创建时间" prop="createTime">
          {{form.createTime}}
        </el-form-item>
        <el-form-item label="真实姓名" prop="userIdName">
          {{form.userIdName}}
        </el-form-item>
        <el-form-item label="身份证号" prop="userIdCard">
          {{form.userIdCard}}
        </el-form-item>
        <el-form-item label="电子邮箱" prop="email">
          {{form.email}}
        </el-form-item>
        <el-form-item label="手机号码" prop="phoneNumber">
          {{form.phoneNumber}}
        </el-form-item>
        <el-form-item label="性别" prop="sex">
          <span v-if="form.sex === 0">未设置</span>
          <span v-else-if="form.sex === 1">男</span>
          <span v-else-if="form.sex === 2">女</span>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <!--        <el-button type="primary" @click="submitForm">确 定</el-button>-->
        <el-button @click="cancel">关 闭</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { listUserBasic, getUserBasic, delUserBasic, addUserBasic, updateUserBasic, exportUserBasic, resetUserPwd } from "@/api/travel/userBasic";
import ScrollPane from "@/layout/components/TagsView/ScrollPane";

export default {
  name: "UserBasic",
  components: {
    ScrollPane
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
      // 账户管理表格数据
      userBasicList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      openDetail: false,
      // 用户状态字典
      userStatusOptions: [],
      // 性别字典
      sexOptions: [],
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        id: null,
        userName: null,
        userStatus: null,
        createTime: null,
        userIdName: null,
        userIdCard: null,
        email: null,
        phoneNumber: null,
        sex: null,
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
    this.getDicts("user_status_select").then(response => {
      this.userStatusOptions = response.data;
    });
    this.getDicts("user_sex_select").then(response => {
      this.sexOptions = response.data;
    });
  },
  methods: {
    /** 查询账户管理列表 */
    getList() {
      this.loading = true;
      listUserBasic(this.queryParams).then(response => {
        this.userBasicList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },
    // 用户状态字典翻译
    userStatusFormat(row, column) {
      return this.selectDictLabel(this.userStatusOptions, row.userStatus);
    },
    // 性别字典翻译
    sexFormat(row, column) {
      return this.selectDictLabel(this.sexOptions, row.sex);
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
        userName: null,
        password: null,
        userStatus: 0,
        createTime: null,
        userIdName: null,
        userIdCard: null,
        email: null,
        phoneNumber: null,
        sex: null,
        avatar: null
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
      this.title = "详情";
      this.form = row;
    }
  }
};
</script>
