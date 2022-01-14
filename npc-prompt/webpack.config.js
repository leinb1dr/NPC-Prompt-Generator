var path = require('path');

module.exports = {
    entry: {
     index: './src/main/js/index.js'
    },
    devtool: 'inline-source-map',
    cache: true,
    mode: 'development',
    output: {
        path: __dirname,
        filename: './src/main/resources/static/built/[name].bundle.js'
    },
    module: {
        rules: [
            {
                test: /\.svg$/,
                use: [{
                  loader: 'file-loader',
                  options: {
                    outputPath: './src/main/resources/static',
                    publicPath: '/'
                  }

              }]
            },
            {
                test: /\.css$/i,
                use: [
                  'style-loader',
                  'css-loader'
                ]
            },
            {
                test: /\.js$/i,
                exclude: /(node_modules)/,
                use: [{
                    loader: 'babel-loader',
                    options: {
                        presets: ["@babel/preset-env", "@babel/preset-react"]
                    }
                }]
            }
        ]
    }
};