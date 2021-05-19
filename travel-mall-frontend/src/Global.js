let base = {};
base.install = function (Vue) {
  //Vue.prototype.$target = "http://47.98.145.198:7000/"; // 线上后端地址
  Vue.prototype.$target = "http://localhost:18080/api/"; // 本地后端地址

  // 封装提示成功的弹出框
  Vue.prototype.notifySucceed = function (msg) {
    this.$notify({
      title: "成功",
      message: msg,
      type: "success",
      offset: 100
    });
  };
  // 封装提示失败的弹出框
  Vue.prototype.notifyError = function (msg) {
    this.$notify.error({
      title: "错误",
      message: msg,
      offset: 100
    });
  };
};

export default base;
