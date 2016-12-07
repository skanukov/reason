'use strict';

const ExtractTextPlugin = require('extract-text-webpack-plugin'),
  path = require('path');

module.exports = {
  context: path.join(__dirname, './assets'),
  entry: {
    bundle: './js/app.js',
  },
  output: {
    path: path.join(__dirname, './public/assets'),
    filename: '[name].js'
  },

  module: {
    rules: [{
      test: /\.(sass|scss)$/,
      loader: ExtractTextPlugin.extract({
        fallbackLoader: 'style-loader',
        loader: 'css-loader!sass-loader'
      })
    }]
  },

  plugins: [
    // Extract CSS to separate file.
    new ExtractTextPlugin('[name].css'),
  ]
};
