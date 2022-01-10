module.exports = {
  devServer: {
    proxy: {
      '/': {
        target: 'http://localhost:8080',
         secure: false,
         ws: true,
         changeOrigin: true
      }
    },
    port: 8000
  },
  outputDir: "target/ui"
}