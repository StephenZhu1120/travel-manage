<template>
  <div class="goods" id="goods" name="goods">
    <!-- 面包屑 -->
    <div class="breadcrumb">
      <el-breadcrumb separator-class="el-icon-arrow-right">
        <el-breadcrumb-item to="/">首页</el-breadcrumb-item>
        <el-breadcrumb-item>全部商品</el-breadcrumb-item>
      </el-breadcrumb>
    </div>
    <!-- 面包屑END -->

    <!-- 主要内容区 -->
    <div class="main">
      <div class="list">
        <MyList :list="product" v-if="product.length>0" :showLength="product.length"></MyList>
        <div v-else class="none-product">抱歉没有找到相关的商品，请看看其他的商品</div>
      </div>
      <!-- 分页 -->
      <div class="pagination">
        <el-pagination
            background
            layout="prev, pager, next"
            :page-size="pageSize"
            :total="total"
            @current-change="currentChange"
        ></el-pagination>
      </div>
      <!-- 分页END -->
    </div>
    <!-- 主要内容区END -->
  </div>
</template>
<script>


export default {
  data() {
    return {
      product: "", // 商品列表
      productList: "",
      total: 0, // 商品总量
      pageSize: 15, // 每页显示的商品数量
      // currentPage: 1, //当前页码
      // activeName: "-1", // 分类列表当前选中的id
      pageNum :1, //页码
      search: "" // 搜索条件
    };
  },
  created() {
    this.getData();
  },
  activated() {
    this.total = 0; // 初始化商品总量为0
    // this.currentPage = 1; //初始化当前页码为1
    this.pageNum = 1;
    // // 如果路由没有传递参数，默认为显示全部商品
    // if (Object.keys(this.$route.query).length == 0) {
    //   this.categoryID = [];
    //   this.activeName = "0";
    //   return;
    // }
    // // 如果路由传递了categoryID，则显示对应的分类商品
    // if (this.$route.query.categoryID != undefined) {
    //   this.categoryID = this.$route.query.categoryID;
    //   if (this.categoryID.length == 1) {
    //     this.activeName = "" + this.categoryID[0];
    //   }
    //   return;
    // }
    // 如果路由传递了search，则为搜索，显示对应的分类商品
    // if (this.$route.query.search != undefined) {
    //   this.search = this.$route.query.search;
    // }
  },
  watch: {
    // 监听搜索条件，响应相应的商品
    search: function(val) {
      if (val != "") {
        this.getProductBySearch(val);
      }
      else
        this.getData();
    },
    // 监听路由变化，更新路由传递了搜索条件
    $route: function(val) {
      if (val.path == "/goods") {
        if (val.query.search != undefined) {
          // this.activeName = "-1";
          // this.currentPage = 1;
          this.pageNum = 1
          this.total = 0;
          this.search = val.query.search;
        }
      }
    }
  },
  methods: {
    // 返回顶部
    backtop() {
      const timer = setInterval(function() {
        const top = document.documentElement.scrollTop || document.body.scrollTop;
        const speed = Math.floor(-top / 5);
        document.documentElement.scrollTop = document.body.scrollTop =
            top + speed;

        if (top === 0) {
          clearInterval(timer);
        }
      }, 20);
    },
    // 页码变化调用currentChange方法
    // currentChange(currentPage) {
    //   this.currentPage = currentPage;
    currentChange(pageNum) {
      this.pageNum = pageNum;
      if (this.search != "") {
        this.getProductBySearch();
      } else {
        this.getData();
      }
      this.backtop();
    },
    // 向后端请求全部商品
    getData() {
      //const api ="/product/getAllProductList"
      this.$axios
          .get("product/getAllProductList", {
            // currentPage: this.currentPage,
            // pageNum: this.pageNum,
            // pageSize: this.pageSize,
            params:{pageNum: this.pageNum, pageSize: this.pageSize, productName:null}
          },{withCredentials : true})
          .then(res => {
            this.product = res.data.rows;
            this.total = res.data.total;
          })
          .catch(res => {
            return Promise.reject(res.data.msg);
          });
    },
    // 通过搜索条件向后端请求商品数据
    getProductBySearch() {
      this.$axios
          .get("product/getAllProductList", {
            // productName: this.search,
            // currentPage: this.currentPage,
            // pageNum: this.pageNum,
            // pageSize: this.pageSize,
            params:{pageNum: this.pageNum, pageSize: this.pageSize, productName:this.search}
          },{withCredentials : true})
          .then(res => {
            this.product = res.data.rows;
            this.total = res.data.total;
          })
          .catch(res => {
            return Promise.reject(res.data.msg);
          });
    }
  }
};
</script>

<style scoped>
.goods {
  background-color: #f5f5f5;
}
/* 面包屑CSS */
.el-tabs--card .el-tabs__header {
  border-bottom: none;
}
.goods .breadcrumb {
  height: 50px;
  background-color: white;
}
.goods .breadcrumb .el-breadcrumb {
  width: 1225px;
  line-height: 30px;
  font-size: 16px;
  margin: 0 auto;
}
/* 面包屑CSS END */

/* 分类标签CSS */
.goods .nav {
  background-color: white;
}
.goods .nav .product-nav {
  width: 1225px;
  height: 40px;
  line-height: 40px;
  margin: 0 auto;
}
.nav .product-nav .title {
  width: 50px;
  font-size: 16px;
  font-weight: 700;
  float: left;
}
/* 分类标签CSS END */

/* 主要内容区CSS */
.goods .main {
  margin: 0 auto;
  max-width: 1225px;
}
.goods .main .list {
  min-height: 650px;
  padding-top: 14.5px;
  margin-left: -13.7px;
  overflow: auto;
}
.goods .main .pagination {
  height: 50px;
  text-align: center;
}
.goods .main .none-product {
  color: #333;
  margin-left: 13.7px;
}
/* 主要内容区CSS END */
</style>
