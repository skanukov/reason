'use strict';

const NODE_ENV = process.env.NODE_ENV || 'development',
  isDevelopment = 'development' == NODE_ENV,
  isProduction = !isDevelopment;

const ExtractTextPlugin = require('extract-text-webpack-plugin'),
  path = require('path'),
  webpack = require('webpack');

// Add hash to asset name for production.
function getAssetName() {
  return '[name]' + (isProduction ? '-[hash]' : '');
}

module.exports = {
  context: path.join(__dirname, './assets'),
  entry: {
    bundle: './js/app.js'
  },
  output: {
    path: path.join(__dirname, './public/assets'),
    filename: `${getAssetName()}.js`
  },

  devtool: isDevelopment ? '#cheap-module-inline-source-map' : '#cheap-module-source-map',

  module: {
    rules: [{
      test: /\.(sass|scss)$/,
      loader: ExtractTextPlugin.extract({
        fallbackLoader: 'style-loader',
        loader: 'css-loader?sourceMap!sass-loader?sourceMap'
      })
    }]
  },

  plugins: [
    // Extract CSS to separate file.
    new ExtractTextPlugin(`${getAssetName()}.css`)
  ]
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
      sourceMap: true
    })
  );
}
