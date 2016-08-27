'use strict';

const NODE_ENV = process.env.NODE_ENV || 'development';

const cssnano = require('cssnano'),
    ExtractTextPlugin = require('extract-text-webpack-plugin'),
    path = require('path'),
    postcssFlexbugsFixes = require('postcss-flexbugs-fixes'),
    webpack = require('webpack');

module.exports = {
    context: path.resolve(__dirname, './assets'),
    entry: {
        bundle: './js/app.js',
        styles: './css/app.scss'
    },
    output: {
        path: path.resolve(__dirname, './public/assets'),
        filename: '[name].js'
    },

    devtool: NODE_ENV == 'development' ? 'cheap-eval-source-map' : null,

    module: {
        loaders: [
            // Compile SASS
            {
                test: /\.scss$/,
                loader: ExtractTextPlugin.extract('style-loader', 'css-loader!postcss-loader!resolve-url!sass-loader?sourceMap')
            }
        ]
    },

    plugins: [
        // Extract CSS to separate file
        new ExtractTextPlugin('[name].css', {
            allChunks: true
        }),
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
                    add: true
                },
                discardComments: NODE_ENV == 'production'
            })
        ];
    },

    resolve: {
        modulesDirectories: ['node_modules']
    },

    watch: NODE_ENV == 'development'
};

// Minify JS in production mode
if (NODE_ENV == 'production') {
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
