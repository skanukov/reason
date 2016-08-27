'use strict';

const autoprefixer = require('autoprefixer');
const ExtractTextPlugin = require('extract-text-webpack-plugin');

module.exports = {
    entry: {
        bundle: './assets/js/app.js',
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
                loader: ExtractTextPlugin.extract('style-loader', 'css-loader!postcss-loader!resolve-url!sass-loader?sourceMap')
            }
        ]
    },

    postcss: function () {
        return [autoprefixer];
    },

    plugins: [
        new ExtractTextPlugin('[name].css', {
            allChunks: true
        })
    ]
};
