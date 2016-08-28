'use strict';

const NODE_ENV = process.env.NODE_ENV || 'development',
    isDevelopment = 'development' == NODE_ENV,
    isProduction = !isDevelopment;

const autoprefixer = require('autoprefixer'),
    ExtractTextPlugin = require('extract-text-webpack-plugin'),
    path = require('path'),
    postcssFlexbugsFixes = require('postcss-flexbugs-fixes'),
    webpack = require('webpack');

// Minify CSS for production
const sassLoader = 'css-loader' + (isDevelopment ? '?sourceMap' : '!postcss-loader') +
    '!sass-loader' + (isDevelopment ? '?sourceMap' : '');

module.exports = {
    context: path.resolve(__dirname, './assets'),
    entry: {
        bundle: './js/app.js',
    },
    output: {
        path: path.resolve(__dirname, './public/assets'),
        filename: '[name].js'
    },

    devtool: isDevelopment ? '#cheap-module-inline-source-map' : null,

    module: {
        loaders: [
            // Compile SASS
            {
                test: /\.scss$/,
                loader: ExtractTextPlugin.extract('style-loader', sassLoader)
            },
            // Copy images, fonts, etc.
            {
                test: /\.woff2?$|\.ttf$|\.eot$|\.svg$|\.png$|\.jpe?g$|\.gif$/,
                loader: 'file-loader?name=[name]-[hash].[ext]'
            }
        ]
    },

    plugins: [
        // Extract CSS to separate file
        new ExtractTextPlugin('[name].css'),
        // Provide jQuery globally
        new webpack.ProvidePlugin({
            jQuery: 'jquery'
        })
    ],

    postcss: function () {
        return [postcssFlexbugsFixes, autoprefixer];
    },

    resolve: {
        modulesDirectories: ['./node_modules']
    },

    watch: isDevelopment
};

// Minify JS in production mode
if (isProduction) {
    module.exports.plugins.push(
        new webpack.optimize.UglifyJsPlugin({
            compress: {
                warnings: false
            },
            output: {
                comments: false,
            },
            sourceMap: false
        })
    );
}
