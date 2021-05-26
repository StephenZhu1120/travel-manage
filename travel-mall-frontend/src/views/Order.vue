<!--
 * @Description: 我的订单页面组件
 * @Author: hai-27
 * @Date: 2020-02-20 17:21:54
 * @LastEditors: hai-27
 * @LastEditTime: 2020-02-27 13:36:27
 -->
<template>
  <div class="order">
    <!-- 我的订单头部 -->
    <div class="order-header">
      <div class="order-header-content">
        <p>
          <i class="el-icon-s-order" style="font-size: 30px;color: #ff6700;"></i>
          我的订单
        </p>
      </div>
    </div>
    <!-- 我的订单头部END -->

    <!-- 我的订单主要内容 -->
    <div class="order-content" v-if="total>0">
      <div class="head-info">
        <span class="username">当前用户名称：{{$store.getters.getUser.userName}}</span>
        <span class="ordercount" style="float: right">共有：{{total}}个订单记录</span>
      </div>
      <div class="content" v-for="(item,index) in orders" :key="index">
        <ul>
          <!-- 我的订单表头 -->
          <li class="order-info">
            <div class="order-id">订单编号: {{item.orderId}}</div>
            <div class="order-time">订单时间: {{item.orderTime | dateFormat}}</div>
          </li>
          <li class="header">
            <div class="pro-img"></div>
            <div class="pro-name">产品名称</div>
            <div class="pro-route-name">路线名称</div>
            <div class="pro-phonenumber">下单手机号</div>
            <div class="pro-peoplenumber">旅行人数</div>

          </li>
          <!-- 我的订单表头END -->

          <!-- 订单列表 -->
          <li class="product-list">
            <div class="pro-img">
              <router-link :to="{ path: 'goods/getProduct', query: {id:item.productId}}">
                <img :src= "item.imgUrl" :alt="item.productName"/>
              </router-link>
            </div>
            <div class="pro-name">
              {{item.productName}}
            </div>
            <div class="pro-route-name">{{item.routeName}}</div>
            <div class="pro-phonenumber">{{item.phoneNumber}}</div>
            <div class="pro-peoplenumber">{{item.peopleNumber}}</div>

          </li>
        </ul>
        <div class="order-bar">
          <div class="order-bar-left">
            <span class="order-status">
              订单状态：
              <span class="order-status-word" v-if="item.orderStatus === 0">已下单，暂未支付</span>
              <span class="order-status-word" v-else-if="item.orderStatus === 1">已支付</span>
              <span class="order-status-word" v-else-if="item.orderStatus === 2">未支付，超时自动取消</span>
              <span class="order-status-word" v-else-if="item.orderStatus === 3">未支付，已主动取消</span>
              <span class="order-status-word" v-else-if="item.orderStatus === 4">已取消，待财务退款</span>
              <span class="order-status-word" v-else-if="item.orderStatus === 5">已退款</span>
              <span class="order-status-word" v-else-if="item.orderStatus === 6">已完成</span>
            </span>
          </div>
          <div class="order-bar-right">
            <span>
              <span class="total-price-title">订单价格：</span>
              <span class="total-price">{{item.price}}元</span>
            </span>
          </div>
        </div>
<!--        <div class="order-bar" id="order_status" v-if="orders">-->
<!--          <div class="status_right"  v-if="item[0].status=='0'">-->
<!--            <p>订单已失效</p>-->
<!--          </div>-->
<!--          <div class="status_right"  v-else-if="item[0].pay_time==null">-->
<!--            <span>本订单尚未支付，请您尽快付款</span>-->
<!--            <el-button size="medium" class="el-button&#45;&#45;primary" @click="orderPay(item[0].order_id)">付款</el-button>-->
<!--          </div>-->
<!--          <div class="status_right"  v-else>-->
<!--            <p>付款时间：{{item[0].pay_time|dateFormat}}</p>-->
<!--          </div>-->
<!--      &lt;!&ndash; 订单列表END &ndash;&gt;-->
<!--    </div>-->
  </div>
  <div style="margin-top:-40px;"></div>
  </div>
  <!-- 我的订单主要内容END -->

  <!-- 订单为空的时候显示的内容 -->
  <div v-else class="order-empty">
    <div class="empty">
      <h2>您的订单还是空的！</h2>
      <p>快去购物吧！</p>
      </div>
    </div>
    <!-- 订单为空的时候显示的内容END -->
  </div>
</template>
<script>
export default {
  data() {
    return {
      orders: [], // 订单列表
      total: 0,
    };
  },
  activated() {
  },
  created() {
    this.getData();
  },
  watch: {
    // 通过订单信息，计算出每个订单的商品数量及总价
    // orders: function(val) {
    //   let total = [];
    //   for (let i = 0; i < val.length; i++) {
    //     const element = val[i];
    //
    //     let totalNum = 0;
    //     let totalPrice = 0;
    //     for (let j = 0; j < element.length; j++) {
    //       const temp = element[j];
    //       totalNum += temp.product_num;
    //       totalPrice += temp.product_price * temp.product_num;
    //     }
    //     total.push({ totalNum, totalPrice });
    //   }
    //   this.total = total;
    // }
  },
  methods:{
    // orderPay(val) {
    //   this.$axios
    //       .post("order/orderPay", {
    //         order_id: val,
    //         user_id: this.$store.getters.getUser.user_id
    //       },{withCredentials : true})
    //       .then(res => {
    //         if(res.data.code=="001"){
    //           this.notifySucceed(res.data.msg);
    //           this.$router.go(0);  //刷新
    //         }
    //         else
    //           this.notifyError(res.data.msg);
    //       })
    //       .catch(err => {
    //         return Promise.reject(err);
    //       });
    // }
    getData(){
      this.$axios
          .get("user/isExist", {
            params:{id: this.$store.getters.getUser.id}
          },{withCredentials : true})
          .then(res => {
            //返回200即为查询订单列表成功
            if (res.data.code === 200) {
              console.log("用户存在");
              // 获取订单数据
              this.$axios
                  .get("order/getAllOrderList", {
                    params:{userId: this.$store.getters.getUser.id}
                  },{withCredentials : true})
                  .then(res => {
                    //返回200即为查询订单列表成功
                    if (res.data.code === 200) {
                      console.log(this);
                      this.orders = res.data.data;
                      this.total = this.orders.length;
                      console.log(this.total);
                    } else {
                      this.notifyError(res.data.msg);
                    }
                  })
                  .catch(err => {
                    return Promise.reject(err);
                  });
            } else {
              this.notifyError(res.data.msg);
              return;
            }
          })
          .catch(err => {
            return Promise.reject(err);
          });
    }
  }
};
</script>
<style scoped>
.order {
  background-color: #f5f5f5;
  padding-bottom: 20px;
}
/* 我的订单头部CSS */
.order .order-header {
  height: 64px;
  border-bottom: 2px solid #ff6700;
  background-color: #fff;
  margin-bottom: 20px;
}
.order .order-header .order-header-content {
  width: 1225px;
  margin: 0 auto;
}
.order .order-header p {
  font-size: 28px;
  line-height: 58px;
  float: left;
  font-weight: normal;
  color: #424242;
}

.order .head-info{
  width: 1225px;
  margin: 0 auto;
}

.order .head-info .username{

}

.order .head-info .ordercount{

}

/* 我的订单头部CSS END */
.order .content {
  width: 1225px;
  margin: 0 auto;
  background-color: #fff;
  margin-bottom: 50px;
}

.order .content ul {
  background-color: #fff;
  color: #424242;
  line-height: 85px;
}
/* 我的订单表头CSS */
.order .content ul .order-info {
  height: 60px;
  line-height: 60px;
  padding: 0 26px;
  color: #424242;
  border-bottom: 1px solid #ff6700;
}
.order .content ul .order-info .order-id {
  float: left;
  color: #ff6700;
}
.order .content ul .order-info .order-time {
  float: right;
}

.order .content ul .header {
  height: 85px;
  padding-right: 26px;
  color: #424242;
}
/* 我的订单表头CSS END */

/* 订单列表CSS */
.order .content ul .product-list {
  height: 85px;
  padding: 15px 26px 15px 0;
  border-top: 1px solid #e0e0e0;
}
.order .content ul .pro-img {
  float: left;
  height: 85px;
  width: 120px;
  padding-left: 30px;
  padding-right: 50px;
}
.order .content ul .pro-img img {
  height: 80px;
  width: 120px;
}
.order .content ul .pro-name {
  float: left;
  width: 380px;
  overflow: hidden;
  white-space: nowrap;
  text-overflow: ellipsis;
}
.order .content ul .pro-name a {
  color: #424242;
}
.order .content ul .pro-name a:hover {
  color: #ff6700;
}
.order .content ul .pro-route-name {
  float: left;
  width: 160px;
  padding-right: 18px;
  text-align: center;
  overflow: hidden;
  white-space: nowrap;
  text-overflow: ellipsis;
}
.order .content ul .pro-peoplenumber {
  float: left;
  width: 190px;
  text-align: center;
}
.order .content ul .pro-phonenumber {
  float: left;
  width: 160px;
  padding-right: 81px;
  text-align: right;
}
.order .content ul .pro-total-in {
  color: #ff6700;
}

.order .order-bar {
  width: 1185px;
  padding: 0 20px;
  border-top: 1px solid #ff6700;
  height: 50px;
  line-height: 50px;
  background-color: #fff;
}
#order_status{
  border-top: 0px;
  display: flex;
  position: relative;
  height: 51px;
}
#order_status .status_right{
  position: absolute;
  right:40px;
}
#order_status .status_right button{
  background-color: #ff6700;
  border-color:  #ff6700;
}
#order_status .status_right span{
  margin-right: 40px;
}
.order .order-bar .order-bar-left {
  float: left;
}
.order .order-bar .order-bar-left .order-status {
  color: #757575;
}
.order .order-bar .order-bar-left .order-status-word {
  color: #ff6700;
}
.order .order-bar .order-bar-right {
  float: right;
}
.order .order-bar .order-bar-right .total-price-title {
  color: #ff6700;
  font-size: 14px;
}
.order .order-bar .order-bar-right .total-price {
  color: #ff6700;
  font-size: 30px;
}
/* 订单列表CSS END */

/* 订单为空的时候显示的内容CSS */
.order .order-empty {
  width: 1225px;
  margin: 0 auto;
}
.order .order-empty .empty {
  height: 300px;
  padding: 0 0 130px 558px;
  margin: 65px 0 0;
  background: url(../assets/imgs/cart-empty.png) no-repeat 124px 0;
  color: #b0b0b0;
  overflow: hidden;
}
.order .order-empty .empty h2 {
  margin: 70px 0 15px;
  font-size: 36px;
}
.order .order-empty .empty p {
  margin: 0 0 20px;
  font-size: 20px;
}
/* 订单为空的时候显示的内容CSS END */
</style>
