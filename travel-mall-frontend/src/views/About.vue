<!--
 * @Description: 关于我们页面组件，未完成
 * @Author: hai-27
 * @Date: 2020-02-07 16:23:00
 * @LastEditors: hai-27
 * @LastEditTime: 2020-03-12 19:36:46
 -->
<template>
  <div class="about" id="about" name="about">
    <div class="about-header">
      <div class="about-title">
        <i class="el-icon-tickets" style="color: #ff6700;"></i>
        关于我们
      </div>
    </div>
    <div class="about-content">
      <p>本商城系统是奥游旅行系统的配套前台页面，可以完成客户的登录注册、产品浏览、订单创建、订单查询等功能</p>
      <p>当前该系统仅满足了业务的最低需求，更多功能请等待新版本开发</p>
      <p style="margin-top: 30px">开发人员：祝思凡 17373038</p>
      <p>院校信息：北京航空航天大学 软件学院 2017级</p>
      <p>微信：13520540878</p>
      <p>qq：1940323593</p>
    </div>
  </div>
</template>
<script>
export default {
  components: {
  }
};
</script>
<style scoped>
.about {
  background-color: #f5f5f5;
}
.about .about-header {
  height: 64px;
  background-color: #fff;
  border-bottom: 2px solid #ff6700;
}
.about .about-header .about-title {
  width: 1225px;
  margin: 0 auto;
  height: 64px;
  line-height: 64px;
  font-size: 28px;
}
.about .content {
  padding: 20px 0;
  width: 1225px;
  margin: 0 auto;
}
.about .content .goods-list {
  margin-left: -13.7px;
  overflow: hidden;
}
.about .about-content {
  width: 1225px;
  margin: 0 auto;
  background-color: #fff;
}
</style>
