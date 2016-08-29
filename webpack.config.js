'use strict';

const NODE_ENV = process.env.NODE_ENV || 'development',
    isDevelopment = 'development' == NODE_ENV,
    isProduction = !isDevelopment;

const AssetsPlugin = require('assets-webpack-plugin'),
    autoprefixer = require('autoprefixer'),
    ExtractTextPlugin = require('extract-text-webpack-plugin'),
    path = require('path'),
    postcssFlexbugsFixes = require('postcss-flexbugs-fixes'),
    webpack = require('webpack');

// Use PostCSS and disable source maps for production
const sassLoader = 'css-loader' + (isDevelopment ? '?sourceMap' : '!postcss-loader') +
    '!sass-loader' + (isDevelopment ? '?sourceMap' : '');

// Add hash to asset name for production
function getAssetName() {
    return '[name]' + (isProduction ? '-[hash]' : '');
}

module.exports = {
    context: path.resolve(__dirname, './assets'),
    entry: {
        bundle: './js/app.js',
    },
    output: {
        path: path.resolve(__dirname, './public/assets'),
        filename: `${getAssetName()}.js`
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
                loader: `file-loader?name=${getAssetName()}.[ext]`
            }
        ]
    },

    plugins: [
        // Provide jQuery globally
        new webpack.ProvidePlugin({
            jQuery: 'jquery'
        }),
        // Extract CSS to separate file
        new ExtractTextPlugin(`${getAssetName()}.css`),
        // Create manifest file
        new AssetsPlugin({
            path: path.resolve(__dirname, './public/assets')
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

// Minify assets for production
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
