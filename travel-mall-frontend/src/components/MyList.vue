<template>
  <div id="myList" class="myList">
    <ul>
      <div v-for="(item,index) in list" :key="item.id">
        <!--showLength为展示的产品个数-->
        <li v-show="index<showLength">
          <el-popover placement="top">
            <p>确定删除吗？</p>
            <div style="text-align: right; margin: 10px 0 0">
              <el-button type="primary" size="mini" @click="deleteCollect(item.id)">确定</el-button>
            </div>
            <i class="el-icon-close delete" slot="reference" v-show="isDelete"></i>
          </el-popover>
          <router-link :to="{ path: 'goods/details', query: {productID:item.id} }" @click="routerRefresh">
            <img :src="item.imgUrl" alt />
            <h2>{{item.productName}}</h2>
            <p>
              <span v-if="item.priceStart != null">{{item.priceStart}} 元起</span>
              <span v-else>暂无报价</span>
            </p>
          </router-link>
        </li>
      </div>
    </ul>
  </div>
</template>
<script>
export default {
  name: "MyList",
  // list为父组件传过来的商品列表
  // isMore为是否显示“浏览更多”
  // showLength为父组件传过来的展示的产品个数
  props: ["list", "isMore", "isDelete","showLength"],
  data() {
    return {};
  },
  methods: {
    /*来摧毁<router-link>，然后再重新创建<router-link>起到刷新页面的效果*/
    routerRefresh(){
      this.setRouterAlive(false);
      this.$nextTick(()=>{
        this.setRouterAlive(true);
      });
    },
    deleteCollect(product_id) {
      this.$axios
          .post("collect/deleteCollect", {
            user_id: this.$store.getters.getUser.user_id,
            product_id: product_id
          },{withCredentials : true})
          .then(res => {
            switch (res.data.code) {
              case "001":
                // 删除成功
                // 删除删除列表中的该商品信息
                for (let i = 0; i < this.list.length; i++) {
                  const temp = this.list[i];
                  if (temp.product_id == product_id) {
                    this.list.splice(i, 1);
                  }
                }
                // 提示删除成功信息
                this.notifySucceed(res.data.msg);
                break;
              default:
                // 提示删除失败信息
                this.notifyError(res.data.msg);
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
.myList ul li {
  z-index: 1;
  float: left;
  width: 295px;
  height: 270px;
  padding: 10px 0;
  margin: 0 0 14.5px 13.7px;
  background-color: rgba(244, 252, 255, 0.79);
  -webkit-transition: all 0.2s linear;
  transition: all 0.2s linear;
  position: relative;
}
.myList ul li:hover {
  z-index: 2;
  -webkit-box-shadow: 0 15px 30px rgba(0, 0, 0, 0.1);
  box-shadow: 10px 20px 35px rgba(0, 0, 0, 0.1);
  -webkit-transform: translate3d(0, -2px, 0);
  transform: translate3d(0, -2px, 0);
}
.myList ul li img {
  display: block;
  width: 285px;
  height: 200px;
  background: url(../assets/imgs/product_img_error.png) no-repeat 50%;
  margin: 0 auto;
}
.myList ul li h2 {
  margin: 15px 35px 0;
  font-size: 14px;
  font-weight: 400;
  color: #333;
  text-align: center;
  text-overflow: ellipsis;
  white-space: nowrap;
  overflow: hidden;
}
.myList ul li h3 {
  margin: 5px 10px;
  height: 18px;
  font-size: 12px;
  font-weight: 400;
  color: #b0b0b0;
  text-align: center;
  text-overflow: ellipsis;
  white-space: nowrap;
  overflow: hidden;
}
.myList ul li p {
  margin: 10px 10px 10px;
  text-align: center;
  color: #ff6700;
}
.myList ul li p .del {
  margin-left: 0.5em;
  color: #b0b0b0;
  text-decoration: line-through;
}
.myList #more {
  text-align: center;
  line-height: 280px;
}
.myList #more a {
  font-size: 18px;
  color: #333;
}
.myList #more a:hover {
  color: #ff6700;
}
.myList ul li .delete {
  position: absolute;
  top: 10px;
  right: 10px;
  display: none;
}
.myList ul li:hover .delete {
  display: block
}
.myList ul li .delete:hover {
  color: #ff6700;
}
</style>
