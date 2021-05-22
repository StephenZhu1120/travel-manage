<template>
  <div class="home" id="home" name="home">
    <!-- 轮播图 -->
    <div class="block">
      <el-carousel height="550px">
        <el-carousel-item>
          <img style="height:550px;" src="../assets/img_banner/lunbo01.jpg" :alt="'欢迎来到奥游旅行社'" />
        </el-carousel-item>
        <el-carousel-item>
          <img style="height:550px;" src="../assets/img_banner/lunbo02.jpg" :alt="'欢迎来到奥游旅行社'" />
        </el-carousel-item>
        <el-carousel-item>
          <img style="height:550px;" src="../assets/img_banner/lunbo03.jpg" :alt="'欢迎来到奥游旅行社'" />
        </el-carousel-item>
<!--        <el-carousel-item>-->
         <!-- <img style="height:550px;" src="../assets/img_banner/lunbo04.jpg" :alt="'欢迎来到奥游旅行社'" /> -->
<!--        </el-carousel-item>-->
      </el-carousel>
    </div>
    <!-- 轮播图END -->
  </div>
</template>
<script>
export default {
  data() {
    return {
    };
  },
  watch: {
  },
  methods: {
  }
};
</script>
<style scoped>
@import "../assets/css/index.css";
#home{
  height: 648px;
}
#home .block{
  margin-top: 30px;
}
</style>
