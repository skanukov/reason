'use strict';

const NODE_ENV = process.env.NODE_ENV || 'development',
    isDevelopment = 'development' == NODE_ENV,
    isProduction = !isDevelopment;

const cssnano = require('cssnano'),
    ExtractTextPlugin = require('extract-text-webpack-plugin'),
    path = require('path'),
    postcssFlexbugsFixes = require('postcss-flexbugs-fixes'),
    webpack = require('webpack');

// Minify CSS for production
const sassLoader = 'css-loader' + (isDevelopment ? '?sourceMap' : '!postcss-loader') + '!resolve-url!sass-loader?sourceMap';

module.exports = {
    context: path.resolve(__dirname, './assets'),
    entry: {
        bundle: './js/app.js',
        styles: './scss/app.scss'
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
        return [
            postcssFlexbugsFixes,
            cssnano({
                autoprefixer: {
                    add: true,
                    remove: true
                },
                discardComments: {
                    removeAll: true
                },
                safe: true
            })
        ];
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
