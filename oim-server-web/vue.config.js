module.exports = {
    publicPath: '',

    pluginOptions: {
        quasar: {
            importStrategy: 'kebab',
            rtlSupport: true
        }
    },

    transpileDependencies: [
        'quasar'
    ],
    devServer: {
        open: process.platform === "darwin",
        host: "localhost",
        port: 8010, //8080,
        https: false,
        hotOnly: false,
        proxy: {
            // 设置代理
            // proxy all requests starting with /api to jsonplaceholder
            "/main": {
                target: "http://localhost:10000/",
                changeOrigin: true,
                ws: true,
                pathRewrite: {
                    "^/main": ""
                }
            }
        },
        before: app => {
        }
    }
}
