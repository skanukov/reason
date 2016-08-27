'use strict';

let ExtractTextPlugin = require("extract-text-webpack-plugin");

module.exports = {
    entry: {
        styles: './assets/css/app.scss'
    },
    output: {
        path: './public/assets',
        filename: '[name].js'
    },

    module: {
        loaders: [
            {
                test: /\.scss$/,
                loader: ExtractTextPlugin.extract('style-loader', 'css-loader!resolve-url!sass-loader?sourceMap')
            }
        ]
    },

    plugins: [
        new ExtractTextPlugin('[name].css', {
            allChunks: true
        })
    ]
};
