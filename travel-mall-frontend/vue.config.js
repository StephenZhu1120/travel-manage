module.exports = {
  //history模式下使用 '/'
  publicPath: '/',
  devServer: {
    open: true,
    proxy: {
      '/api': {
        //target: 'http://47.98.145.198:7000', // 线上后端地址
        target: 'http://localhost:18080', // 本地后端地址  不使用candy
        // target: '/', // 本地后端地址   使用candy
        changeOrigin: true, //允许跨域
        pathRewrite: {
          '^/api': ''
        }
      }
    }
  }
}
