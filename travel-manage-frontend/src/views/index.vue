<template>
  <div class="app-container home">
    <el-row :gutter="20">
      <el-col :sm="24" :lg="24">
<!--        <blockquote class="text-warning" style="font-size: 14px">-->
<!--          领取阿里云通用云产品1888优惠券-->
<!--          <br />-->
<!--          <el-link-->
<!--            href="https://www.aliyun.com/minisite/goods?userCode=brki8iof"-->
<!--            type="primary"-->
<!--            target="_blank"-->
<!--            >https://www.aliyun.com/minisite/goods?userCode=brki8iof</el-link-->
<!--          >-->
<!--          <br />-->
<!--          领取腾讯云通用云产品2860优惠券-->
<!--          <br />-->
<!--          <el-link-->
<!--            href="https://cloud.tencent.com/redirect.php?redirect=1025&cps_key=198c8df2ed259157187173bc7f4f32fd&from=console"-->
<!--            type="primary"-->
<!--            target="_blank"-->
<!--            >https://cloud.tencent.com/redirect.php?redirect=1025&cps_key=198c8df2ed259157187173bc7f4f32fd&from=console</el-link-->
<!--          >-->
<!--          <br />-->
<!--          阿里云服务器折扣区-->
<!--          <el-link href="http://aly.ruoyi.vip" type="primary" target="_blank"-->
<!--            >>☛☛点我进入☚☚</el-link-->
<!--          >-->
<!--          &nbsp;&nbsp;&nbsp; 腾讯云服务器秒杀区-->
<!--          <el-link href="http://txy.ruoyi.vip" type="primary" target="_blank"-->
<!--            >>☛☛点我进入☚☚</el-link-->
<!--          ><br />-->
<!--          <h4 class="text-danger">-->
<!--            云产品通用红包，可叠加官网常规优惠使用。(仅限新用户)-->
<!--          </h4>-->
<!--        </blockquote>-->

        <hr />
      </el-col>
    </el-row>
    <el-row :gutter="20">
      <el-col :sm="24" :lg="12" style="padding-left: 20px">
<!--        <h2>若依后台管理框架</h2>-->
        <h2>奥游旅游后台管理系统</h2>
<!--        <p>-->
<!--          一直想做一款后台管理系统，看了很多优秀的开源项目但是发现没有合适自己的。于是利用空闲休息时间开始自己写一套后台系统。如此有了若依管理系统。，她可以用于所有的Web应用程序，如网站管理后台，网站会员中心，CMS，CRM，OA等等，当然，您也可以对她进行深度定制，以做出更强系统。所有前端后台代码封装过后十分精简易上手，出错概率低。同时支持移动客户端访问。系统会陆续更新一些实用功能。-->
<!--        </p>-->
        <p>
          该系统是奥游旅行社实现业务电子化的线上管理系统，支持员工账号及部门管理、客户商城账户管理、旅游产品及路线策划及管理、旅客订单管理、财务信息管理等功能。更多功能模块正在开发中，敬请期待······
        </p>
        <p>
          <b>当前版本:</b> <span>v{{ version }}</span>
        </p>
<!--        <p>-->
<!--          <el-tag type="danger">&yen;免费开源</el-tag>-->
<!--        </p>-->
<!--        <p>-->
<!--          <el-button-->
<!--            type="primary"-->
<!--            size="mini"-->
<!--            icon="el-icon-cloudy"-->
<!--            plain-->
<!--            @click="goTarget('https://gitee.com/y_project/RuoYi-Vue')"-->
<!--            >访问码云</el-button-->
<!--          >-->
<!--          <el-button-->
<!--            size="mini"-->
<!--            icon="el-icon-s-home"-->
<!--            plain-->
<!--            @click="goTarget('http://ruoyi.vip')"-->
<!--            >访问主页</el-button-->
<!--          >-->
<!--        </p>-->
      </el-col>

      <el-col :sm="24" :lg="12" style="padding-left: 50px">
        <el-row>
          <el-col :span="12">
            <h2>技术选型</h2>
          </el-col>
        </el-row>
        <el-row>
          <el-col :span="6">
            <h4>后端技术</h4>
            <ul>
              <li>SpringBoot</li>
              <li>Spring Security</li>
              <li>JWT</li>
              <li>MyBatis</li>
              <li>Druid</li>
              <li>Fastjson</li>
              <li>...</li>
            </ul>
          </el-col>
          <el-col :span="6">
            <h4>前端技术</h4>
            <ul>
              <li>Vue</li>
              <li>Vuex</li>
              <li>Element-ui</li>
              <li>Axios</li>
              <li>Sass</li>
              <li>Quill</li>
              <li>...</li>
            </ul>
          </el-col>
        </el-row>
      </el-col>
    </el-row>
    <el-divider />
    <el-row :gutter="20">
      <el-col :xs="24" :sm="24" :md="12" :lg="12">
        <el-card class="update-log">
          <div slot="header" class="clearfix">
            <span>联系信息</span>
          </div>
          <div class="body">
<!--            <p>-->
<!--              <i class="el-icon-s-promotion"></i> 官网：<el-link-->
<!--                href="http://www.ruoyi.vip"-->
<!--                target="_blank"-->
<!--                >http://www.ruoyi.vip</el-link-->
<!--              >-->
<!--            </p>-->
            <p>
              <i class="el-icon-s-promotion"></i> 开发人员：17373038 祝思凡
            </p>
            <p>
              <i class="el-icon-school"></i> 院校信息：北京航空航天大学 软件学院 2017级
            </p>
            <p>
              <i class="el-icon-chat-line-round"></i> 微信：13520540878
            </p>
            <p>
              <i class="el-icon-chat-dot-square"></i> QQ：1940323593
            </p>
<!--            <p>-->
<!--              <i class="el-icon-user-solid"></i> QQ群：<s>满937441</s>-->
<!--              <s>满887144332</s> <s>满180251782</s> <s>满104180207</s>-->
<!--              <s>满186866453</s>-->
<!--              <a href="https://jq.qq.com/?_wv=1027&k=5vYAqA05" target="_blank">-->
<!--                201396349</a-->
<!--              >-->
<!--            </p>-->
<!--            <p>-->
<!--              <i class="el-icon-chat-dot-round"></i> 微信：<a-->
<!--                href="javascript:;"-->
<!--                >/ *若依</a-->
<!--              >-->
<!--            </p>-->
<!--            <p>-->
<!--              <i class="el-icon-money"></i> 支付宝：<a-->
<!--                href="javascript:;"-->
<!--                class="支付宝信息"-->
<!--                >/ *若依</a-->
<!--              >-->
<!--            </p>-->
          </div>
        </el-card>
      </el-col>
      <el-col :xs="24" :sm="24" :md="12" :lg="12">
        <el-card class="update-log">
          <div slot="header" class="clearfix">
            <span>更新日志</span>
          </div>
          <el-collapse>
            <el-collapse-item title="v2.1.1 - 2021-05-30">
              <ol>
                <p>修复问题，提升系统稳定性</p>
              </ol>
            </el-collapse-item>
            <el-collapse-item title="v2.1.0 - 2021-05-26">
              <ol>
                <p>增加定时任务</p>
                <p>修复问题，提升系统稳定性</p>
              </ol>
            </el-collapse-item>
            <el-collapse-item title="v2.0.2 - 2021-05-23">
              <ol>
                <p>修复问题，提升系统稳定性</p>
              </ol>
            </el-collapse-item>
            <el-collapse-item title="v2.0.1 - 2021-05-17">
              <ol>
                <p>修复问题，提升系统稳定性</p>
              </ol>
            </el-collapse-item>
            <el-collapse-item title="v2.0.0 - 2021-05-15">
              <ol>
                <p>新增多部门角色管理，各部门可按权限查看并办理业务</p>
              </ol>
            </el-collapse-item>
            <el-collapse-item title="v1.0.2 - 2021-05-04">
              <ol>
                <p>版本升级，新增财务管理模块</p>
              </ol>
            </el-collapse-item>
            <el-collapse-item title="v1.0.1 - 2021-05-01">
              <ol>
                <p>完善订单业务操作</p>
              </ol>
            </el-collapse-item>
            <el-collapse-item title="v1.0.0 - 2021-04-25">
              <ol>
                <p>奥游管理系统初版正式上线</p>
                <p>功能模块：客户管理、产品管理、订单管理</p>
              </ol>
            </el-collapse-item>
          </el-collapse>
        </el-card>
      </el-col>
<!--      <el-col :xs="24" :sm="24" :md="12" :lg="8">-->
<!--        <el-card class="update-log">-->
<!--          <div slot="header" class="clearfix">-->
<!--            <span>捐赠支持</span>-->
<!--          </div>-->
<!--          <div class="body">-->
<!--            <img-->
<!--              src="https://oscimg.oschina.net/oscnet/up-d6695f82666e5018f715c41cb7ee60d3b73.png"-->
<!--              alt="donate"-->
<!--              width="100%"-->
<!--            />-->
<!--            <span style="display: inline-block; height: 30px; line-height: 30px"-->
<!--              >你可以请作者喝杯咖啡表示鼓励</span-->
<!--            >-->
<!--          </div>-->
<!--        </el-card>-->
<!--      </el-col>-->
    </el-row>
  </div>
</template>

<script>
export default {
  name: "index",
  data() {
    return {
      // 版本号
      version: "2.1.1",
    };
  },
  methods: {
    goTarget(href) {
      window.open(href, "_blank");
    },
  },
};
</script>

<style scoped lang="scss">
.home {
  blockquote {
    padding: 10px 20px;
    margin: 0 0 20px;
    font-size: 17.5px;
    border-left: 5px solid #eee;
  }
  hr {
    margin-top: 20px;
    margin-bottom: 20px;
    border: 0;
    border-top: 1px solid #eee;
  }
  .col-item {
    margin-bottom: 20px;
  }

  ul {
    padding: 0;
    margin: 0;
  }

  font-family: "open sans", "Helvetica Neue", Helvetica, Arial, sans-serif;
  font-size: 13px;
  color: #676a6c;
  overflow-x: hidden;

  ul {
    list-style-type: none;
  }

  h4 {
    margin-top: 0px;
  }

  h2 {
    margin-top: 10px;
    font-size: 26px;
    font-weight: 100;
  }

  p {
    margin-top: 10px;
    font-size: large;

    b {
      font-weight: 700;
    }
  }

  .update-log {
    ol {
      display: block;
      list-style-type: decimal;
      margin-block-start: 1em;
      margin-block-end: 1em;
      margin-inline-start: 0;
      margin-inline-end: 0;
      padding-inline-start: 40px;
      font-size: medium;
    }
    span {
      font-size: large;
    }
  }
}
</style>

