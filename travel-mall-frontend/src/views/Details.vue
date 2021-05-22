<!--
 * @Description: 商品详情页面组件
 * @Author: hai-27
 * @Date: 2020-02-16 20:20:26
 * @LastEditors: hai-27
 * @LastEditTime: 2020-03-07 21:59:26
 -->
<template>
  <div id="details">
    <!-- 头部 -->
    <div class="page-header">
      <div class="title">
        <p>{{productDetails.productName}}</p>
        <div class="list">
          <ul>
            <li>
              <router-link to>概述</router-link>
            </li>
            <li>
              <router-link to>旅游产品详情</router-link>
            </li>
          </ul>
        </div>
      </div>
    </div>
    <!-- 头部END -->

    <!-- 主要内容 -->
    <div class="main">
      <!-- 左侧商品轮播图 -->
      <div class="block">
        <el-carousel class="pictureplay" v-if="productPicture.length>1" indicator-position="outside" height="373px">
          <el-carousel-item v-for="(item, i) in productPicture" :key="item">
            <img :src="productPicture[i]" :alt="productDetails.productName" />
          </el-carousel-item>
        </el-carousel>
        <div v-else>
          <img
            :src="productPicture[0]"
            :alt="productDetails.productName"
          />
        </div>
      </div>
      <!-- 左侧商品轮播图END -->

      <!-- 右侧内容区 -->
      <div class="content">
        <span class="store">奥游出品</span>
        <span class="name">{{productDetails.productName}}</span>
        <p class="intro">{{productDetails.description}}</p>
        <div class="price">
          <span>{{productDetails.priceStart}}元起</span>
<!--          <span-->
<!--            v-show="productDetails.product_price != productDetails.priceStart"-->
<!--            class="del"-->
<!--          >{{productDetails.product_price}}元</span>-->
        </div>
        <div class="detail">
          <p>
            <span class="title">出发地：</span>
            <span class="info">{{productDetails.birthland}}</span>
          </p>
          <p>
            <span class="title">目的地：</span>
            <span class="info">{{productDetails.destination}}</span>
          </p>
          <p>
            <span class="title">旅行天数：</span>
            <span class="info">{{productDetails.productDay}}</span>
          </p>

        </div>
        <div class="pro-list">
<!--          <span class="pro-name">{{productDetails.productName}}</span>-->
          <p class="pro-price">
<!--            <span>{{productDetails.product_selling_price}}元</span>-->
<!--            <span-->
<!--              v-show="productDetails.product_price != productDetails.product_selling_price"-->
<!--              class="pro-del"-->
<!--            >{{productDetails.product_price}}元</span>-->
            <span class="pro-date" >出行日期：
              <el-date-picker
                v-model="selectDate"
                type="date"
                placeholder="请选择日期">
              </el-date-picker>
            </span>
            <span class="pro-route">产品路线选择：
              <el-select v-model="selectRoute" placeholder="请选择路线" size="small" @change="calcPrice">
                <el-option
                          v-for="item in productRouteList"
                          :key="item.routeId"
                          :label="item.routeName"
                          :value="item.index">
                </el-option>
              </el-select>
            </span>
            <span class="pro-people">人数：
              <el-input-number v-model="selectPeople" :min="0" :max="20" label="人数" size="small" placeholder="请选择人数" @change="calcPrice"></el-input-number>
            </span>
          </p>
          <p v-if="totalNumber === 0" class="price-sum">请选择路线和人数</p>
          <p v-else class="price-sum">预估价格总计：{{totalNumber}} 元</p>
        </div>
        <!-- 内容区底部按钮 -->
        <div class="button">
<!--          <el-button class="shop-cart" :disabled="dis" @click="addShoppingCart">加入购物车</el-button>-->
<!--          <el-button class="like" @click="addCollect">喜欢</el-button>-->
          <el-button class="order" @click="createOrder" type="primary">立即下单</el-button>
        </div>
        <!-- 内容区底部按钮END -->
        <div class="pro-policy">
          <ul>
            <li>
              <i class="el-icon-circle-check"></i> 专属导游
            </li>
            <li>
              <i class="el-icon-circle-check"></i> 专业客服全程服务
            </li>
            <li>
              <i class="el-icon-circle-check"></i> 出发前7天无理由取消
            </li>
<!--            <li>-->
<!--              <i class="el-icon-circle-check"></i> 7天价格保护-->
<!--            </li>-->
          </ul>
        </div>
      </div>
      <!-- 右侧内容区END -->
<!--      这一部分是展示产品的图文介绍-->
      <div>
        <span v-html="productDetails.productDetailAds"></span>

      </div>
    </div>
    <!-- 主要内容END -->
  </div>
</template>
<script>
import { mapActions } from "vuex";
export default {
  data() {
    return {
      dis: false, // 控制“加入购物车按钮是否可用”
      productID: "", // 商品id
      productDetails: "", // 商品详细信息
      productPicture: "", // 商品图片
      productRouteList: [],
      totalNumber: 0,
      selectPeople: undefined,
      selectRoute: null,
      selectDate: null
    };
  },
  // 通过路由获取商品id
  activated() {
    if (this.$route.query.productID != undefined) {
      this.productID = this.$route.query.productID;
    }
  },
  watch: {
    // 监听商品id的变化，请求后端获取商品数据
    productID: function(val) {
      this.getDetails(val);
      // this.getDetailsPicture(val);
    }
  },
  methods: {
    ...mapActions(["unshiftShoppingCart", "addShoppingCartNum"]),


    calcPrice(){
      if(this.selectRoute === null || this.selectPeople === 0 || this.selectPeople === undefined)
        this.totalNumber = 0;
      else
        this.totalNumber = this.productRouteList[this.selectRoute].price * this.selectPeople;
    },
    // 获取商品详细信息
    getDetails(val) {
      this.$axios
          .get("product/getProduct", {
            params:{id: val}
          },{withCredentials : true})
          .then(res => {
            if(res.data.code === 200){
              this.productDetails = res.data.data;
              this.productPicture = res.data.data.imgs;
              this.productRouteList = res.data.data.productRoutes;
            } else{
              this.notifyError(res.data.msg);
            }
          })
          .catch(res => {
            return Promise.reject(res.data.msg);
          });
        // .get("product/getDetails", {
        //   productID: val
        // })
        // .then(res => {
        //   this.productDetails = res.data.Product[0];
        // })
        // .catch(err => {
        //   return Promise.reject(err);
        // });
    },

    createOrder(){
      if(!this.$store.getters.getUser){
        this.$store.dispatch("setShowLogin", true);
        return;
      }
      //
      // console.log("userid:"+this.$store.getters.getUser.id);
      // console.log("productid:"+this.productDetails.id);
      // console.log("routeindex:"+this.selectRoute);
      // console.log("peoplenumber:"+this.selectPeople);
      // console.log("selectDate:"+this.selectDate);

      if(this.selectRoute === null){
        this.notifyError("请选择出行路线");
        return;
      }
      if(this.selectPeople === 0 || this.selectPeople === undefined){
        this.notifyError("请选择出行人数");
        return;
      }
      if(this.selectDate === null){
        this.notifyError("请选择出行时间");
        return;
      }

      this.$axios
          .post("order",{
            userId: this.$store.getters.getUser.id,
            productId: this.productDetails.id,
            routeId: this.selectRoute,
            peopleNumber: this.selectPeople,
            travelTime: this.selectDate
          },{withCredentials : true})
          .then(res =>{
            if(res.data.code === 200){
              this.notifySucceed(res.data.msg);
            }
            else
              this.notifyError(res.data.msg);
          })
      .catch(err => {
        return Promise.reject(err);
      });

    }

    //图片获取方式不同，原作者内容直接注释掉
    // 获取商品图片
    // getDetailsPicture(val) {
    //   this.$axios
    //     .post("product/getDetailsPicture", {
    //       productID: val
    //     })
    //     .then(res => {
    //       this.productPicture = res.data.ProductPicture;
    //     })
    //     .catch(err => {
    //       return Promise.reject(err);
    //     });
    // },

    //加购物车  暂不实现
    // // 加入购物车
    // addShoppingCart() {
    //   // 判断是否登录,没有登录则显示登录组件
    //   if (!this.$store.getters.getUser) {
    //     this.$store.dispatch("setShowLogin", true);
    //     return;
    //   }
    //   console.log(this.$store.getters.getUser.user_id);
    //   console.log(this.productID);
    //   this.$axios
    //     .post("shoppingCart/addShoppingCart", {
    //       user_id: this.$store.getters.getUser.user_id,
    //       product_id: this.productID
    //     },{withCredentials : true})
    //     .then(res => {
    //       switch (res.data.code) {
    //         case "001":
    //           // 新加入购物车成功
    //           this.unshiftShoppingCart(res.data.shoppingCartData[0]);
    //           this.notifySucceed(res.data.msg);
    //           break;
    //         case "002":
    //           // 该商品已经在购物车，数量+1
    //           this.addShoppingCartNum(this.productID);
    //           this.notifySucceed(res.data.msg);
    //           break;
    //         case "003":
    //           // 商品数量达到限购数量
    //           this.dis = true;
    //           this.notifyError(res.data.msg);
    //           break;
    //         default:
    //           this.notifyError(res.data.msg);
    //       }
    //     })
    //     .catch(err => {
    //       return Promise.reject(err);
    //     });
    // },

    //加入个人收藏，暂时不实现
    // addCollect() {
    //   // 判断是否登录,没有登录则显示登录组件
    //   if (!this.$store.getters.getUser) {
    //     this.$store.dispatch("setShowLogin", true);
    //     return;
    //   }
    //   this.$axios
    //     .post("collect/addCollect", {
    //       user_id: this.$store.getters.getUser.user_id,
    //       product_id: this.productID
    //     },{withCredentials : true})
    //     .then(res => {
    //       if (res.data.code == "001") {
    //         // 添加收藏成功
    //         this.notifySucceed(res.data.msg);
    //       } else {
    //         // 添加收藏失败
    //         this.notifyError(res.data.msg);
    //       }
    //     })
    //     .catch(err => {
    //       return Promise.reject(err);
    //     });
    // }
  }
};
</script>
<style>
/* 头部CSS */
#details .page-header {
  height: 64px;
  margin-top: -20px;
  z-index: 4;
  background: #fff;
  border-bottom: 1px solid #e0e0e0;
  -webkit-box-shadow: 0px 5px 5px rgba(0, 0, 0, 0.07);
  box-shadow: 0px 5px 5px rgba(0, 0, 0, 0.07);
}
#details .page-header .title {
  width: 1225px;
  height: 64px;
  line-height: 64px;
  font-size: 18px;
  font-weight: 400;
  color: #212121;
  margin: 0 auto;
}
#details .page-header .title p {
  float: left;
}
#details .page-header .title .list {
  height: 64px;
  float: right;
}
#details .page-header .title .list li {
  float: left;
  margin-left: 20px;
}
#details .page-header .title .list li a {
  font-size: 14px;
  color: #616161;
}
#details .page-header .title .list li a:hover {
  font-size: 14px;
  color: #ff6700;
}
/* 头部CSS END */

/* 主要内容CSS */
#details .main {
  width: 1225px;
  height: 560px;
  padding-top: 30px;
  margin: 0 auto;
}
#details .main .block {
  float: left;
  margin-top: 30px;
  width: 560px;
  height: 471px;
}
#details .main .block img{
  width: 100%;
  height: 100%;
}

#details .el-carousel .el-carousel__indicator .el-carousel__button {
  background-color: rgba(163, 163, 163, 0.8);
}
#details .main .content {
  float: left;
  margin-left: 45px;
  width: 620px;
  margin-top: 20px;
}
#details .main .content .name {
  /*height: 30px;*/
  /*line-height: 30px;*/
  font-size: 24px;
  font-weight: normal;
  color: #212121
}
#details .main .content .intro {
  color: #b0b0b0;
  padding-top: 10px;
}
#details .main .content .store {
  color: #ffffff;
  /*padding-top: 10px;*/
  width: 75px;
  height: 25px;
  text-align: center;
  vertical-align: center;
  background-color: rgba(50, 125, 255, 0.7);
  border-radius: 5px;
  /*padding: 0 5px 0;*/
  margin-right: 5px;
  display: inline-block;
}
#details .main .content .price {
  display: block;
  font-size: 18px;
  color: #ff6700;
  border-bottom: 1px solid #e0e0e0;
  padding: 25px 0 25px;
}
#details .main .content .price .del {
  font-size: 14px;
  margin-left: 10px;
  color: #b0b0b0;
  text-decoration: line-through;
}
#details .main .content .pro-list {
  background: #f9f9fa;
  padding: 30px 60px;
  margin: 50px 0 50px;
  width: 90%;
}
#details .main .content .pro-list span {
  line-height: 30px;
  color: #616161;
}
#details .main .content .pro-list .pro-date{
  display: block;
}
#details .main .content .pro-list .pro-route{
  display: block;
}
#details .main .content .pro-list .pro-people{
  display: block;
}
#details .main .content .pro-list .pro-price {
  /*float: left;*/
  display: block;
}
#details .main .content .pro-list .pro-price .pro-del {
  margin-left: 10px;
  text-decoration: line-through;
}
#details .main .content .pro-list .price-sum {
  color: #ff6700;
  font-size: 24px;
  float: left;
  /*padding-top: 20px;*/
}
#details .main .content .button {
  height: 55px;
  margin: 10px 0 20px 0;
}
#details .main .content .button .el-button {
  float: left;
  height: 55px;
  font-size: 16px;
  color: #fff;
  border: none;
  text-align: center;
}
#details .main .content .button .shop-cart {
  width: 340px;
  background-color: #ff6700;
}
#details .main .content .button .shop-cart:hover {
  background-color: #f25807;
}

#details .main .content .button .like {
  width: 260px;
  margin-left: 40px;
  background-color: #b0b0b0;
}
#details .main .content .button .like:hover {
  background-color: #757575;
}
#details .main .content .pro-policy li {
  float: left;
  margin-right: 20px;
  color: #b0b0b0;
}
/* 主要内容CSS END */
</style>
